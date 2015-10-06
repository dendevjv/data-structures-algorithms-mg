package ru.dendevjv.dsalgjavamg.ch01.exercises;

import java.util.Scanner;

public class P0127SimpleCalculator {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        String operator = null;
        double operand;
        double result = 0;
        while (running) {
            System.out.print("> ");
            if (sc.hasNextDouble()) {
                operand = sc.nextDouble();
                if (operator != null) {
                    result = calculate(operand, operator, result);
                } else {
                    result = operand;
                }
            } else if (sc.hasNext()) {
                operator = sc.next();
                if ("=".equals(operator)) {
                    System.out.println("Result = " + result);
                    running = false;
                }
            }
        }
    } // end main()

    private static double calculate(double operand, String operator,
            double result) {
        switch (operator) {
        case "+":
            result += operand;
            break;
        case "-":
            result -= operand;
            break;
        case "*":
            result *= operand;
            break;
        case "/":
            result /= operand;
            break;
        default:
            throw new RuntimeException("Invalid operator: "
                    + operator);
        }
        return result;
    }
    
}
