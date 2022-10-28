package org.calculator.operators;


import org.junit.Test;
import java.math.BigDecimal;
import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

public class SubtractionOperatorTest {
    private static final SubtractionOperator operatorUnderTest = new SubtractionOperator();

    @Test
    public void apply_subtractsValues() {
        Stack<BigDecimal> stack = new Stack<>();
        stack.push(BigDecimal.valueOf(6));
        stack.push(BigDecimal.valueOf(8));
        assertThat(operatorUnderTest.apply(stack)).isEqualTo(BigDecimal.valueOf(-2));
    }
}
