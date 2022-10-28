package org.calculator.operators;

import org.junit.Test;
import java.math.BigDecimal;
import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class DivisionOperatorTest {
    private static final DivisionOperator operatorUnderTest = new DivisionOperator();

    @Test
    public void apply_division() {
        Stack<BigDecimal> stack = new Stack<>();
        stack.push(BigDecimal.valueOf(6));
        stack.push(BigDecimal.valueOf(3));
        assertThat(operatorUnderTest.apply(stack)).isEqualTo(BigDecimal.valueOf(2));
    }

    @Test
    public void apply_decimalPoint_appliesRounding() {
        Stack<BigDecimal> stack = new Stack<>();
        stack.push(BigDecimal.valueOf(9));
        stack.push(BigDecimal.valueOf(3.3));
        assertThat(operatorUnderTest.apply(stack)).isEqualTo(BigDecimal.valueOf(2.727273));
    }

    @Test
    public void apply_divisionByZero_throwsArithmeticException() {
        Stack<BigDecimal> stack = new Stack<>();
        stack.push(BigDecimal.valueOf(6));
        stack.push(BigDecimal.valueOf(0));
        assertThatExceptionOfType(ArithmeticException.class).isThrownBy(() -> operatorUnderTest.apply(stack));
    }
}
