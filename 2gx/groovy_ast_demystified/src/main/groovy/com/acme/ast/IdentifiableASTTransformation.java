package com.acme.ast;

import org.codehaus.groovy.ast.ASTNode;
import org.codehaus.groovy.ast.AnnotationNode;
import org.codehaus.groovy.ast.ClassNode;
import org.codehaus.groovy.control.CompilePhase;
import org.codehaus.groovy.control.SourceUnit;
import org.codehaus.groovy.transform.ASTTransformation;
import org.codehaus.groovy.transform.GroovyASTTransformation;

import java.lang.reflect.Modifier;

import static org.codehaus.groovy.ast.ClassHelper.Long_TYPE;

@GroovyASTTransformation(phase = CompilePhase.CANONICALIZATION)
public class IdentifiableASTTransformation implements ASTTransformation {
    private static final String IDENTITY = "id";

    @Override
    public void visit(ASTNode[] nodes, SourceUnit source) {
        // step #1: verify nodes
        if (!(nodes[0] instanceof AnnotationNode) || !(nodes[1] instanceof ClassNode)) {
            throw new RuntimeException("Internal error: wrong types: " + nodes[0].getClass() + " / " + nodes[1].getClass());
        }

        // step #2: verify preconditions
        ClassNode theClass = (ClassNode) nodes[1];
        if (theClass.hasProperty(IDENTITY)) {
            return;
        }

        // step #3: do the work
        theClass.addProperty(
            IDENTITY,        // name
            Modifier.PUBLIC, // visibility
            Long_TYPE,       // type
            null,            // initial expression
            null,            // getter
            null             // setter
        );
    }
}
