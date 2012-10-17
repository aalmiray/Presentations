package com.acme;

import org.codehaus.groovy.transform.GroovyASTTransformationClass;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@GroovyASTTransformationClass("com.acme.ast.SortableASTTransformation")
public @interface Sortable {
    /**
     * Property names to include in the comparison algorithm
     */
    String[] includes() default {};

    /**
     * Property names to exclude in the comparison algorithm
     */
    String[] excludes() default {};
}