package com.acme.ast;

import com.acme.util.AbstractComparator;
import org.codehaus.groovy.ast.*;
import org.codehaus.groovy.ast.expr.ConstantExpression;
import org.codehaus.groovy.ast.expr.Expression;
import org.codehaus.groovy.ast.expr.ListExpression;
import org.codehaus.groovy.ast.stmt.BlockStatement;
import org.codehaus.groovy.ast.stmt.Statement;
import org.codehaus.groovy.control.CompilePhase;
import org.codehaus.groovy.control.SourceUnit;
import org.codehaus.groovy.transform.ASTTransformation;
import org.codehaus.groovy.transform.GroovyASTTransformation;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static com.acme.ast.GroovyASTUtils.*;
import static java.lang.reflect.Modifier.*;
import static org.codehaus.groovy.runtime.DefaultGroovyMethods.capitalize;

@GroovyASTTransformation(phase = CompilePhase.CANONICALIZATION)
public class SortableASTTransformation implements ASTTransformation {
    private static final ClassNode COMPARABLE_TYPE = makeClassSafe(Comparable.class);
    private static final ClassNode COMPARATOR_TYPE = makeClassSafe(Comparator.class);
    private static final ClassNode ABSTRACT_COMPARATOR_TYPE = makeClassSafe(AbstractComparator.class);
    private static final Expression NIL = ConstantExpression.NULL;

    private static final String VALUE = "value";
    private static final String OBJ = "obj";
    private static final String A = "a";
    private static final String B = "b";

    public void visit(ASTNode[] nodes, SourceUnit source) {
        if (!(nodes[0] instanceof AnnotationNode) || !(nodes[1] instanceof ClassNode)) {
            throw new RuntimeException("Internal error: wrong types: " + nodes[0].getClass() + " / " + nodes[1].getClass());
        }
        AnnotationNode annotation = (AnnotationNode) nodes[0];
        AnnotatedNode parent = (AnnotatedNode) nodes[1];

        if (parent instanceof ClassNode) {
            createSortable(source, annotation, (ClassNode) parent);
        }
    }

    public static void createSortable(SourceUnit sourceUnit, AnnotationNode annotation, ClassNode classNode) {
        List<PropertyNode> properties = findProperties(annotation, classNode);
        if (!classNode.implementsInterface(COMPARABLE_TYPE)) {
            classNode.addInterface(COMPARABLE_TYPE);
        }

        classNode.addMethod(new MethodNode(
            "compareTo",
            PUBLIC,
            ClassHelper.int_TYPE,
            params(param(ClassHelper.OBJECT_TYPE, OBJ)),
            ClassNode.EMPTY_ARRAY,
            createCompareToMethodBody(classNode, properties)
        ));

        for (PropertyNode property : properties) {
            createComparatorFor(classNode, property);
        }
    }

    private static Statement createCompareToMethodBody(ClassNode classNode, List<PropertyNode> properties) {
        List<Statement> statements = new ArrayList<Statement>();

        // if(this.is(obj)) return 0;
        statements.add(ifs(call(THIS, "is", vars(OBJ)), constx(0)));
        // if(!(obj instanceof <type>)) return -1;
        statements.add(ifs(not(iof(var(OBJ), classx(classNode))), constx(-1)));
        // int value = 0;
        statements.add(decls(var(VALUE, ClassHelper.int_TYPE), constx(0)));
        for (PropertyNode property : properties) {
            String name = property.getName();
            // value = this.prop <=> obj.prop;
            statements.add(
                assigns(var(VALUE), cmp(prop(THIS, name), prop(var(OBJ), name)))
            );
            // if(value != 0) return value;
            statements.add(
                ifs(ne(var(VALUE), constx(0)), var(VALUE))
            );
        }

        if (properties.isEmpty()) {
            // let this object be less than obj
            statements.add(returns(constx(-1)));
        } else {
            // objects are equal
            statements.add(returns(constx(0)));
        }

        final BlockStatement body = new BlockStatement();
        body.addStatements(statements);
        return body;
    }

    private static Statement createCompareToMethodBody(ClassNode classNode, PropertyNode property) {
        String propertyName = property.getName();
        return block(
            // if(a == b) return 0;
            ifs(eq(var(A), var(B)), constx(0)),
            // if(a != null && b == null) return -1;
            ifs(and(ne(var(A), NIL), eq(var(B), NIL)), constx(-1)),
            // if(a == null && b != null) return 1;
            ifs(and(eq(var(A), NIL), ne(var(B), NIL)), constx(1)),
            // return a.prop <=> b.prop;
            returns(cmp(prop(var(A), propertyName), prop(var(B), propertyName)))
        );
    }

    private static void createComparatorFor(ClassNode classNode, PropertyNode property) {
        String propertyName = property.getName();
        String className = classNode.getName() + "$" + capitalize(propertyName) + "Comparator";
        InnerClassNode cmpClass = new InnerClassNode(classNode, className, PRIVATE | STATIC, ABSTRACT_COMPARATOR_TYPE);
        classNode.getModule().addClass(cmpClass);

        cmpClass.addMethod(new MethodNode(
            "compare",
            PUBLIC,
            ClassHelper.int_TYPE,
            params(
                param(ClassHelper.OBJECT_TYPE, A),
                param(ClassHelper.OBJECT_TYPE, B)),
            ClassNode.EMPTY_ARRAY,
            createCompareToMethodBody(classNode, property)
        ));

        String fieldName = "this$" + capitalize(propertyName) + "Comparator";
        // private final Comparator this$<property>Comparator = new <type>$<property>Comparator();
        FieldNode cmpField = classNode.addField(
            fieldName,
            STATIC | FINAL | PRIVATE | 4096 /* SYNTHETIC */,
            COMPARATOR_TYPE,
            ctor(cmpClass, NO_ARGS));

        classNode.addMethod(new MethodNode(
            "comparatorBy" + capitalize(propertyName),
            PUBLIC | STATIC,
            COMPARATOR_TYPE,
            Parameter.EMPTY_ARRAY,
            ClassNode.EMPTY_ARRAY,
            returns(field(cmpField))
        ));
    }

    private static List<PropertyNode> findProperties(AnnotationNode annotation, ClassNode classNode) {
        List<PropertyNode> properties = new ArrayList<PropertyNode>();
        List<String> includes = new ArrayList<String>();
        List<String> excludes = new ArrayList<String>();

        Expression expr = annotation.getMember("includes");
        if (expr instanceof ListExpression) {
            for (Expression x : ((ListExpression) expr).getExpressions()) {
                if (x instanceof ConstantExpression) {
                    includes.add(String.valueOf(((ConstantExpression) x).getValue()));
                }
            }
        }
        expr = annotation.getMember("excludes");
        if (expr instanceof ListExpression) {
            for (Expression x : ((ListExpression) expr).getExpressions()) {
                if (x instanceof ConstantExpression) {
                    excludes.add(String.valueOf(((ConstantExpression) x).getValue()));
                }
            }
        }

        for (PropertyNode property : classNode.getProperties()) {
            String propertyName = property.getName();
            if (property.isStatic() ||
                excludes.contains(propertyName) ||
                !includes.isEmpty() && !includes.contains(propertyName)) continue;
            properties.add(property);
        }

        return properties;
    }
}