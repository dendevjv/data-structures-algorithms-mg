/*
    P-5.28 
    Write a program for solving summation puzzles by enumerating and testing all
    possible configurations. Using your program, solve the three puzzles given in
    Section 5.3.3.
    
    Summation puzzles:
    pot + pan = bib
    dog + cat = pig
    boy + girl = baby
    
    To solve such a puzzle, we need to assign a unique digit (that is, 0, 1,... , 9) to each
    letter in the equation, in order to make the equation true.
 */
package ru.dendevjv.dsalgjavamg.ch05recursion.projects;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P0528SolveSummationPuzzles {

    public static void main(String[] args) {
        // solvePuzzle("boy + girl = baby");
        // solvePuzzle("dog + cat = pig");
        // solvePuzzle("pot + pan = bib");
        solvePuzzle("aba + ab = aaa"); // 101 + 10 = 111
    }
    
    private static void solvePuzzle(String puzzle) {
        System.out.println("Trying to solve puzzle:\n" + puzzle);
        boolean found = enumerateConfigurations(puzzle, Puzzle.DECIMAL_DIGITS);
        System.out.printf("Solution(s) %s%n", found ? "found" : "not found");
    }
    
    private static boolean enumerateConfigurations(String conf, String digits) {
        boolean success = false;
        if (new Puzzle(conf).isCorrect()) {
            System.out.println(conf);
            success = true;
        } else {
            int letterIndex = findFirstLetter(conf);
            if (letterIndex > -1) {
                for (int i = 0; i < digits.length(); i++) {
                    String nextConf = replaceLetterWithDigit(conf, letterIndex, digits.substring(i, i + 1));
                    String newDigits = digits.substring(0, i) + digits.substring(i + 1);
                    boolean r = enumerateConfigurations(nextConf, newDigits);
                    success = success ? success : r;
                }
            }
        }
        return success;
    }
    
    private static String replaceLetterWithDigit(String s, int from, String digit) {
        StringBuilder sb = new StringBuilder(s);
        char ch = sb.charAt(from);
        for (int i = from; i < sb.length(); i++) {
            if (sb.charAt(i) == ch) {
                sb.replace(i, i + 1, digit);
            }
        }
        return sb.toString();
    }
    
    private static int findFirstLetter(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                return i;
            }
        }
        return -1;
    }
    
    private static class Puzzle {
        private static final String DECIMAL_DIGITS = "1234567890";
        private static final Pattern EXPRESSION_PATTERN = Pattern.compile("(\\w+)\\s*(\\+|-|\\*|/)\\s*(\\w+)\\s*=\\s+(\\w+)");
        
        private String puzzleAsString;
        private String operand0asString;
        private String operand1asString;
        private String operator;
        private String resultAsString;

        private Puzzle(String puzzleAsString) {
            this.puzzleAsString = puzzleAsString;
            parse(puzzleAsString);
        }
        
        private void parse(String puzzleAsString) {
            Matcher matcher = EXPRESSION_PATTERN.matcher(puzzleAsString);
            if (matcher.matches()) {
                operand0asString = matcher.group(1);
                operator = matcher.group(2);
                operand1asString = matcher.group(3);
                resultAsString = matcher.group(4);
            } else {
                throw new IllegalArgumentException("Expression string can not be parsed: " + puzzleAsString);
            }
        }
        
        private boolean isCorrect() {
            if (containsNonExpressionChar(puzzleAsString)) {
                return false;
            }
            try {
                int operand0 = Integer.parseInt(operand0asString);
                int operand1 = Integer.parseInt(operand1asString);
                int expectedResult = Integer.parseInt(resultAsString);
                int actualResult;
                switch (operator) {
                case "+":
                    actualResult = operand0 + operand1;
                    break;
                case "-":
                    actualResult = operand0 - operand1;
                    break;
                case "*":
                    actualResult = operand0 * operand1;
                    break;
                case "/":
                    actualResult = operand0 / operand1;
                    break;
                default:
                    throw new IllegalStateException("Invalid operator: "
                            + operator);
                }
                return actualResult == expectedResult;
            } catch (NumberFormatException e) {
                return false;
            }
        }
        
        private boolean containsNonExpressionChar(String s) {
            for (int i = 0; i < s.length(); i++) {
                if (!isExpressionChar(s.charAt(i))) {
                    return true;
                }
            }
            return false;
        }

        private boolean isExpressionChar(char ch) {
            return Character.isDigit(ch) || ch == ' ' || "+-*/=".indexOf(ch) > -1;
        }
    } // end of class Puzzle
}
