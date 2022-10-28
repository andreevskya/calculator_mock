package org.calculator;

import org.junit.Test;
import java.math.BigDecimal;
import java.text.ParseException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;


public class CalculatorTest {
    private static final Calculator calculatorUnderTest = new Calculator();

    @Test
    public void calculate_simpleAddition() throws ParseException {
        BigDecimal result = calculatorUnderTest.calculate("3 + 2");
        assertThat(result).isEqualTo(BigDecimal.valueOf(5));
    }

    @Test
    public void calculate_simpleSubtraction() throws ParseException {
        BigDecimal result = calculatorUnderTest.calculate("3 - 2");
        assertThat(result).isEqualTo(BigDecimal.valueOf(1));
    }

    @Test
    public void calculate_simpleMultiplication() throws ParseException {
        BigDecimal result = calculatorUnderTest.calculate("3*5");
        assertThat(result).isEqualTo(BigDecimal.valueOf(15));
    }

    @Test
    public void calculate_priorityOperations() throws ParseException {
        BigDecimal result = calculatorUnderTest.calculate("1 + 2 * 3");
        assertThat(result).isEqualTo(BigDecimal.valueOf(7));
    }

    @Test
    public void calculate_priorityOperations2() throws ParseException {
        BigDecimal result = calculatorUnderTest.calculate("1 + 2 * 3 + 5");
        assertThat(result).isEqualTo(BigDecimal.valueOf(12));
    }

    @Test
    public void calculate_brackets() throws ParseException {
        BigDecimal result = calculatorUnderTest.calculate("(1 + 2) * 3");
        assertThat(result).isEqualTo(BigDecimal.valueOf(9));
    }

    @Test
    public void calculate_divisionByZero_throwsArithmeticException() {
        assertThatExceptionOfType(ArithmeticException.class).isThrownBy(() -> calculatorUnderTest.calculate("3/0"));
    }

    @Test
    public void calculate_malformedExpression_throwsParseException() {
        assertThatExceptionOfType(ParseException.class).isThrownBy(() -> calculatorUnderTest.calculate("3/+3"));
    }
}
