package org.calculator.operators;

import java.math.BigDecimal;
import java.util.Stack;

public interface Operator {

    BigDecimal apply(Stack<BigDecimal> stack);

    int getPriority();

    String getOperator();
}
