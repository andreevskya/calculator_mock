package org.calculator;

import org.calculator.operators.AdditionOperator;
import org.calculator.operators.ClosingBracketOperator;
import org.calculator.operators.DivisionOperator;
import org.calculator.operators.MultiplicationOperator;
import org.calculator.operators.NumberOperator;
import org.calculator.operators.OpeningBracketOperator;
import org.calculator.operators.Operator;
import org.calculator.operators.SubtractionOperator;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Map;

public class ExpressionParser {
    private static final Map<String, Operator> OPERATORS = Map.of(
            AdditionOperator.OPERATOR, new AdditionOperator(),
            SubtractionOperator.OPERATOR, new SubtractionOperator(),
            MultiplicationOperator.OPERATOR, new MultiplicationOperator(),
            DivisionOperator.OPERATOR, new DivisionOperator(),
            OpeningBracketOperator.OPERATOR, new OpeningBracketOperator(),
            ClosingBracketOperator.OPERATOR, new ClosingBracketOperator()
    );

    public List<Operator> parse(String input) throws ParseException {
        List<Operator> reversePolishNotation = new ArrayList<>();
        Deque<Operator> stack = new ArrayDeque<>();
        input = input.replaceAll("[ \t]", "");
        for (int i = 0; i < input.length(); ++i) {
            char currentSymbol = input.charAt(i);
            ParseResult result;

            if (Character.isDigit(currentSymbol)) {
                result = parseNumber(input, i);
                try {
                    reversePolishNotation.add(new NumberOperator(new BigDecimal(result.result)));
                } catch (NumberFormatException nex) {
                    throw new ParseException("Invalid operand \"" + result.result + "\"", result.index);
                }
                i = result.index - 1;
                continue;
            }

            Operator operator = OPERATORS.get(String.valueOf(currentSymbol));

            if (operator == null) {
                throw new ParseException("Invalid operator \"" + currentSymbol + "\"", i);
            }

            if (operator instanceof OpeningBracketOperator) {
                stack.push(operator);
                continue;
            }

            if (operator instanceof ClosingBracketOperator) {
                while (!stack.isEmpty() && !(stack.peek() instanceof OpeningBracketOperator)) {
                    reversePolishNotation.add(stack.pop());
                }
                stack.pop();
                continue;
            }

            while (!stack.isEmpty() && operator.getPriority() <= stack.peek().getPriority()) {
                reversePolishNotation.add(stack.pop());
            }
            stack.push(operator);
        }
        while (!stack.isEmpty()) {
            reversePolishNotation.add(stack.pop());
        }
        return reversePolishNotation;
    }

    private ParseResult parseNumber(String input, int index) throws ParseException {
        if (!Character.isDigit(input.charAt(index))) {
            throw new ParseException("Invalid character", index);
        }
        boolean hasDecimalPoint = false;
        StringBuilder sb = new StringBuilder();
        int i = index;
        for (; i < input.length(); ++i) {
            char currentSymbol = input.charAt(i);
            if (Character.isDigit(currentSymbol)) {
                sb.append(currentSymbol);
                continue;
            }
            if (currentSymbol == '.' || currentSymbol == ',') {
                if (hasDecimalPoint) {
                    throw new ParseException("Invalid character", i);
                }
                hasDecimalPoint = true;
                sb.append(currentSymbol);
                continue;
            }
            break;
        }
        return new ParseResult(sb.toString(), i);
    }

    private static class ParseResult {
        public final String result;
        public final int index;

        public ParseResult(String result, int index) {
            this.result = result;
            this.index = index;
        }
    }
}
