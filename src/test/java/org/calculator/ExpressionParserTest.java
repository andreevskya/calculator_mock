package org.calculator;

import org.calculator.operators.Operator;
import org.junit.Test;
import java.text.ParseException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class ExpressionParserTest {
    private static final ExpressionParser parserUnderTest = new ExpressionParser();

    @Test
    public void parse_operationPriority() throws ParseException {
        List<Operator> operators = parserUnderTest.parse("1+2*3");
        assertThat(operators.stream().map(Object::toString).reduce((s1, s2) -> s1 + s2).get())
                .isEqualTo("123*+");

        operators = parserUnderTest.parse("1 + 2 * 3 + 5");
        assertThat(operators.stream().map(Object::toString).reduce((s1, s2) -> s1 + s2).get())
                .isEqualTo("123*+5+");
    }

    @Test
    public void parse_malformedExpression_throwsParseException() {
        assertThatExceptionOfType(ParseException.class).isThrownBy(() -> parserUnderTest.parse("n+3.14"));
    }
}
