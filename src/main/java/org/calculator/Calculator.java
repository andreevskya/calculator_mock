package org.calculator;

import org.calculator.operators.Operator;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.EmptyStackException;
import java.util.Stack;

public class Calculator {

    public BigDecimal calculate(String input) throws ParseException {
        Stack<BigDecimal> stack = new Stack<>();
        try {
            for (Operator operator : new ExpressionParser().parse(input)) {
                stack.push(operator.apply(stack));
            }
        } catch (EmptyStackException ex) {
            throw new ParseException("Malformed expression", 0);
        }
        return stack.pop();
    }
}
