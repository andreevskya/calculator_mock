package org.calculator.operators;

import java.math.BigDecimal;
import java.util.Stack;

public class AdditionOperator implements Operator {
    public static final String OPERATOR = "+";
    private static final int PRIORITY = 1;

    @Override
    public BigDecimal apply(Stack<BigDecimal> operandStack) {
        BigDecimal operand2 = operandStack.pop();
        return operandStack.pop().add(operand2);
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
