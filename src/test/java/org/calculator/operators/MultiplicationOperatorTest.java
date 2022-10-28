package org.calculator.operators;

import org.junit.Test;
import java.math.BigDecimal;
import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

public class MultiplicationOperatorTest {
    private static final MultiplicationOperator operatorUnderTest = new MultiplicationOperator();

    @Test
    public void apply_multipliesValues() {
        Stack<BigDecimal> stack = new Stack<>();
        stack.push(BigDecimal.valueOf(6));
        stack.push(BigDecimal.valueOf(3));
        assertThat(operatorUnderTest.apply(stack)).isEqualTo(BigDecimal.valueOf(18));
    }
}
