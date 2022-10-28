package org.calculator.operators;

import java.math.BigDecimal;
import java.util.Stack;

public class MultiplicationOperator implements Operator {
    public static final String OPERATOR = "*";
    private static final int PRIORITY = 2;

    @Override
    public BigDecimal apply(Stack<BigDecimal> stack) {
        BigDecimal operand2 = stack.pop();
        return stack.pop().multiply(operand2);
    }

    @Override
    public int getPriority() {
        return PRIORITY;
    }

    @Override
    public String getOperator() {
        return OPERATOR;
    }

    @Override
    public String toString() {
        return getOperator();
    }
}
