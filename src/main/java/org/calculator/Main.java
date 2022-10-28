package org.calculator;

import java.math.BigDecimal;
import java.text.ParseException;

public class Main {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("No argument present");
            System.exit(-1);
            return;
        }
        try {
            BigDecimal result = new Calculator().calculate(args[0]);
            System.out.println(result.toPlainString());
            return;
        } catch (ParseException pex) {
            System.err.println(pex.getMessage() + " at position " + pex.getErrorOffset());
        } catch (ArithmeticException ex) {
            System.err.println(ex.getMessage());
        } catch (Exception ex) {
            ex.printStackTrace(System.err);
        }
        System.exit(-1);
    }
}
