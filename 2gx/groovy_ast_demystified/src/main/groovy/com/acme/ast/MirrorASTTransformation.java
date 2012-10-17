package com.acme.ast;

import org.codehaus.groovy.ast.*;
import org.codehaus.groovy.control.CompilePhase;
import org.codehaus.groovy.control.SourceUnit;
import org.codehaus.groovy.transform.ASTTransformation;
import org.codehaus.groovy.transform.GroovyASTTransformation;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

@GroovyASTTransformation(phase = CompilePhase.CANONICALIZATION)
public class MirrorASTTransformation implements ASTTransformation {
    @Override
    public void visit(ASTNode[] nodes, SourceUnit source) {
        if (!(nodes[0] instanceof AnnotationNode) || !(nodes[1] instanceof ClassNode)) {
            throw new RuntimeException("Internal error: wrong types: " + nodes[0].getClass() + " / " + nodes[1].getClass());
        }

        ClassNode theClass = (ClassNode) nodes[1];
        ClassNode mirrorClass = new ClassNode(
            theClass.getName() + "Mirror",
            Modifier.PUBLIC,
            ClassHelper.OBJECT_TYPE);
        theClass.getModule().addClass(mirrorClass);

        for (PropertyNode property : findProperties(theClass)) {
            mirrorClass.addProperty(
                property.getName(),
                property.getModifiers(),
                property.getType().getPlainNodeReference(),
                property.getInitialExpression(),
                property.getGetterBlock(),
                property.getSetterBlock()
            );
        }
    }

    private List<PropertyNode> findProperties(ClassNode sourceClass) {
        List<PropertyNode> properties = new ArrayList<PropertyNode>();

        for (PropertyNode property : sourceClass.getProperties()) {
            if (!property.isStatic()) properties.add(property);
        }

        return properties;
    }
}
