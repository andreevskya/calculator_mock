package org.calculator.operators;

import java.math.BigDecimal;
import java.util.Stack;

public class SubtractionOperator implements Operator {
    public static final String OPERATOR = "-";
    private static final int PRIORITY = 1;

    @Override
    public BigDecimal apply(Stack<BigDecimal> stack) {
        BigDecimal operand2 = stack.pop();
        return stack.pop().subtract(operand2);
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
