package org.calculator.operators;

import java.math.BigDecimal;
import java.util.Stack;

public class ClosingBracketOperator implements Operator {
    public static final String OPERATOR = ")";
    public static final int PRIORITY = 0;

    @Override
    public BigDecimal apply(Stack<BigDecimal> stack) {
        return null;
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
