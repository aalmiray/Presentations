package com.acme.ast;

import org.codehaus.groovy.ast.ClassHelper;
import org.codehaus.groovy.ast.ClassNode;
import org.codehaus.groovy.ast.FieldNode;
import org.codehaus.groovy.ast.Parameter;
import org.codehaus.groovy.ast.expr.*;
import org.codehaus.groovy.ast.stmt.*;
import org.codehaus.groovy.syntax.Token;
import org.codehaus.groovy.syntax.Types;

import java.util.ArrayList;
import java.util.List;

public class GroovyASTUtils {
    public static final ClassNode[] NO_EXCEPTIONS = ClassNode.EMPTY_ARRAY;
    public static final Parameter[] NO_PARAMS = Parameter.EMPTY_ARRAY;
    public static final Expression THIS = VariableExpression.THIS_EXPRESSION;
    public static final Expression SUPER = VariableExpression.SUPER_EXPRESSION;
    public static final ArgumentListExpression NO_ARGS = ArgumentListExpression.EMPTY_ARGUMENTS;
    public static final Token ASSIGN = Token.newSymbol(Types.ASSIGN, -1, -1);
    public static final Token EQ = Token.newSymbol(Types.COMPARE_EQUAL, -1, -1);
    public static final Token NE = Token.newSymbol(Types.COMPARE_NOT_EQUAL, -1, -1);
    public static final Token AND = Token.newSymbol(Types.LOGICAL_AND, -1, -1);
    public static final Token OR = Token.newSymbol(Types.LOGICAL_OR, -1, -1);
    public static final Token CMP = Token.newSymbol(Types.COMPARE_TO, -1, -1);
    public static final Token INSTANCEOF = Token.newSymbol(Types.KEYWORD_INSTANCEOF, -1, -1);

    public static Statement returns(Expression expr) {
        return new ReturnStatement(new ExpressionStatement(expr));
    }

    public static ArgumentListExpression vars(String... names) {
        List<Expression> vars = new ArrayList<Expression>();
        for (String name : names) {
            vars.add(var(name));
        }
        return new ArgumentListExpression(vars);
    }

    public static ArgumentListExpression args(Expression... expressions) {
        List<Expression> args = new ArrayList<Expression>();
        for (Expression expression : expressions) {
            args.add(expression);
        }
        return new ArgumentListExpression(args);
    }

    public static VariableExpression var(String name) {
        return new VariableExpression(name);
    }

    public static VariableExpression var(String name, ClassNode type) {
        return new VariableExpression(name, type);
    }

    public static Parameter param(ClassNode type, String name) {
        return param(type, name, null);
    }

    public static Parameter param(ClassNode type, String name, Expression initialExpression) {
        Parameter param = new Parameter(type, name);
        if (initialExpression != null) {
            param.setInitialExpression(initialExpression);
        }
        return param;
    }

    public static ClassNode[] throwing(ClassNode... exceptions) {
        return exceptions;
    }

    public static Parameter[] params(Parameter... params) {
        return params != null ? params : Parameter.EMPTY_ARRAY;
    }

    public static NotExpression not(Expression expr) {
        return new NotExpression(expr);
    }

    public static ConstantExpression constx(Object val) {
        return new ConstantExpression(val);
    }

    public static ClassExpression classx(ClassNode clazz) {
        return new ClassExpression(clazz);
    }

    public static ClassExpression classx(Class clazz) {
        return classx(ClassHelper.makeWithoutCaching(clazz).getPlainNodeReference());
    }

    public static BlockStatement block(Statement... stms) {
        BlockStatement block = new BlockStatement();
        for (Statement stm : stms) block.addStatement(stm);
        return block;
    }

    public static Statement ifs(Expression cond, Expression trueExpr) {
        return new IfStatement(
            cond instanceof BooleanExpression ? (BooleanExpression) cond : new BooleanExpression(cond),
            new ReturnStatement(trueExpr),
            new EmptyStatement()
        );
    }

    public static Statement ifs(Expression cond, Expression trueExpr, Expression falseExpr) {
        return new IfStatement(
            cond instanceof BooleanExpression ? (BooleanExpression) cond : new BooleanExpression(cond),
            new ReturnStatement(trueExpr),
            new ReturnStatement(falseExpr)
        );
    }

    public static Statement ifs_no_return(Expression cond, Expression trueExpr) {
        return new IfStatement(
            cond instanceof BooleanExpression ? (BooleanExpression) cond : new BooleanExpression(cond),
            new ExpressionStatement(trueExpr),
            new EmptyStatement()
        );
    }

    public static Statement ifs_no_return(Expression cond, Expression trueExpr, Expression falseExpr) {
        return new IfStatement(
            cond instanceof BooleanExpression ? (BooleanExpression) cond : new BooleanExpression(cond),
            new ExpressionStatement(trueExpr),
            new ExpressionStatement(falseExpr)
        );
    }

    public static Statement ifs_no_return(Expression cond, Statement trueStmnt) {
        return new IfStatement(
            cond instanceof BooleanExpression ? (BooleanExpression) cond : new BooleanExpression(cond),
            trueStmnt,
            new EmptyStatement()
        );
    }

    public static Statement ifs_no_return(Expression cond, Statement trueStmnt, Statement falseStmnt) {
        return new IfStatement(
            cond instanceof BooleanExpression ? (BooleanExpression) cond : new BooleanExpression(cond),
            trueStmnt,
            falseStmnt
        );
    }

    public static Statement decls(Expression lhv, Expression rhv) {
        return new ExpressionStatement(new DeclarationExpression(lhv, ASSIGN, rhv));
    }

    public static Statement assigns(Expression expression, Expression value) {
        return new ExpressionStatement(assign(expression, value));
    }

    public static BinaryExpression assign(Expression lhv, Expression rhv) {
        return new BinaryExpression(lhv, ASSIGN, rhv);
    }

    public static BinaryExpression eq(Expression lhv, Expression rhv) {
        return new BinaryExpression(lhv, EQ, rhv);
    }

    public static BinaryExpression ne(Expression lhv, Expression rhv) {
        return new BinaryExpression(lhv, NE, rhv);
    }

    public static BinaryExpression and(Expression lhv, Expression rhv) {
        return new BinaryExpression(lhv, AND, rhv);
    }

    public static BinaryExpression or(Expression lhv, Expression rhv) {
        return new BinaryExpression(lhv, OR, rhv);
    }

    public static BinaryExpression cmp(Expression lhv, Expression rhv) {
        return new BinaryExpression(lhv, CMP, rhv);
    }

    public static BinaryExpression iof(Expression lhv, Expression rhv) {
        return new BinaryExpression(lhv, INSTANCEOF, rhv);
    }

    public static BinaryExpression iof(Expression lhv, ClassNode rhv) {
        return new BinaryExpression(lhv, INSTANCEOF, new ClassExpression(rhv));
    }

    public static Expression prop(Expression owner, String property) {
        return new PropertyExpression(owner, property);
    }

    public static Expression prop(Expression owner, Expression property) {
        return new PropertyExpression(owner, property);
    }

    public static MethodCallExpression call(Expression receiver, String methodName, ArgumentListExpression args) {
        return new MethodCallExpression(receiver, methodName, args);
    }

    public static StaticMethodCallExpression call(ClassNode receiver, String methodName, ArgumentListExpression args) {
        return new StaticMethodCallExpression(receiver, methodName, args);
    }

    public static ExpressionStatement stmnt(Expression expression) {
        return new ExpressionStatement(expression);
    }

    public static FieldExpression field(FieldNode fieldNode) {
        return new FieldExpression(fieldNode);
    }

    public static FieldExpression field(ClassNode owner, String fieldName) {
        return new FieldExpression(owner.getField(fieldName));
    }

    public static ConstructorCallExpression ctor(ClassNode type, Expression args) {
        return new ConstructorCallExpression(type, args);
    }

    public static ClassNode makeClassSafe(Class klass) {
        return makeClassSafe(ClassHelper.makeWithoutCaching(klass));
    }

    public static ClassNode makeClassSafe(ClassNode classNode) {
        return classNode.getPlainNodeReference();
    }
}
