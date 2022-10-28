package org.calculator.operators;

import java.math.BigDecimal;
import java.util.Stack;

public class NumberOperator implements Operator {
    private final BigDecimal value;

    public NumberOperator(BigDecimal value) {
        this.value = value;
    }

    @Override
    public BigDecimal apply(Stack<BigDecimal> stack) {
        return value;
    }

    @Override
    public int getPriority() {
        return 0;
    }

    @Override
    public String getOperator() {
        return value.toPlainString();
    }

    @Override
    public String toString() {
        return value.toPlainString();
    }
}
