package com.acme.ast;

import org.codehaus.groovy.ast.*;
import org.codehaus.groovy.ast.expr.BinaryExpression;
import org.codehaus.groovy.ast.expr.ConstantExpression;
import org.codehaus.groovy.ast.expr.Expression;
import org.codehaus.groovy.ast.expr.VariableExpression;
import org.codehaus.groovy.ast.stmt.ReturnStatement;
import org.codehaus.groovy.control.CompilePhase;
import org.codehaus.groovy.control.SourceUnit;
import org.codehaus.groovy.syntax.Token;
import org.codehaus.groovy.syntax.Types;
import org.codehaus.groovy.transform.ASTTransformation;
import org.codehaus.groovy.transform.GroovyASTTransformation;

import java.lang.reflect.Modifier;

@GroovyASTTransformation(phase = CompilePhase.CANONICALIZATION)
public class GreetableASTTransformation implements ASTTransformation {
    private static final String GREET = "greet";
    private static final String SUBJECT = "subject";
    private static final Parameter[] PARAMS = new Parameter[]{new Parameter(ClassHelper.STRING_TYPE, SUBJECT)};

    @Override
    public void visit(ASTNode[] nodes, SourceUnit source) {
        // step #1: verify nodes
        if (!(nodes[0] instanceof AnnotationNode) || !(nodes[1] instanceof ClassNode)) {
            throw new RuntimeException("Internal error: wrong types: " + nodes[0].getClass() + " / " + nodes[1].getClass());
        }

        // step #2: verify preconditions
        ClassNode theClass = (ClassNode) nodes[1];
        if (theClass.hasMethod(GREET, PARAMS)) {
            return;
        }

        // step #3: do the work
        AnnotationNode annotation = (AnnotationNode) nodes[0];
        Expression expr = annotation.getMember("salutation");
        String salutation = "Hello ";
        if (expr instanceof ConstantExpression) salutation = expr.getText();

        theClass.addMethod(
            GREET,
            Modifier.PUBLIC,
            ClassHelper.STRING_TYPE,
            PARAMS,
            ClassNode.EMPTY_ARRAY,
            new ReturnStatement(
                new BinaryExpression(
                    new ConstantExpression(salutation),
                    new Token(Types.PLUS, "+", -1, -1),
                    new VariableExpression(SUBJECT, ClassHelper.STRING_TYPE)
                )
            )
        );
    }
}
