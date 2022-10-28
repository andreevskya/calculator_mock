package org.calculator.operators;

import org.junit.Test;
import java.math.BigDecimal;
import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

public class AdditionOperatorTest {
    private static final AdditionOperator operatorUnderTest = new AdditionOperator();

    @Test
    public void apply_createsSum() {
        Stack<BigDecimal> stack = new Stack<>();
        stack.push(BigDecimal.valueOf(5));
        stack.push(BigDecimal.valueOf(3.5));
        assertThat(operatorUnderTest.apply(stack)).isEqualTo(BigDecimal.valueOf(8.5));
    }
}
