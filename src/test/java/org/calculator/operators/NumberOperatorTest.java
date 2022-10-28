package org.calculator.operators;

import org.junit.Test;
import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberOperatorTest {

    @Test
    public void apply_returnsNumber() {
        NumberOperator numberOperator = new NumberOperator(BigDecimal.valueOf(3.14));
        assertThat(numberOperator.apply(null)).isEqualTo(BigDecimal.valueOf(3.14));
    }
}
