package ru.dendevjv.dsalgjavamg.ch05recursion.examples;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * My own solution to a summation puzzle.
 * @author dendevjv
 */
public class SummationPuzzle {

    private static final String DIGITS = "0123456789";

    public static void main(String[] args) {
//        String puzzle = "aba + baba = bbcb";
        String puzzle = "boy + girl = baby";
        String r = solvePuzzle(puzzle);
        System.out.println(r);
    }

    static String solvePuzzle(String puzzle) {
        String[] tokens = puzzle.split("\\s*=\\s*");
        String expression = tokens[0];
        Pattern pattern = Pattern.compile("(\\w+)\\s*(\\+|-|\\*|/)\\s*(\\w+)");
        Matcher matcher = pattern.matcher(expression);
        if (matcher.matches()) {
            String operator = matcher.group(2);
            if ("+".equals(operator)) {
                return solveSummationPuzzle(puzzle.toCharArray(), DIGITS);
            }
        } else {
            throw new IllegalArgumentException("Expression does not match expression pattern.");
        }
        return null;
    }

    /**
     * Tries to solve the specified puzzle using supplied digits.
     * @param puzzle array of characters representing the puzzle
     * @param digits digit characters for substitution
     * @return string representing valid expression or <em>null</em> if the puzzle could not be solved
     */
    private static String solveSummationPuzzle(char[] puzzle, String digits) {
        for (int i = 0; i < digits.length(); i++) {
            char digit = digits.charAt(i);
            String nextDigits = digits.substring(0, i) + digits.substring(i + 1);
            char[] nextPuzzle = substituteNonDigits(puzzle, digit);
            if (containsValidChars(nextPuzzle) && isCorrectSummationExpression(nextPuzzle)) {
                return new String(nextPuzzle);
            } else {
                String result = solveSummationPuzzle(nextPuzzle, nextDigits);
                if (result != null) {
                    return result;
                }
            }
        }
        return null;
    }
    
    /**
     * Substitutes supplied digit for first non digit char in the given array.
     * @param characters array of digit and non digit characters
     * @param digit digit character for substitution
     * @return array where specified digit substitutes first non digit character and all its occurrences
     *                  in the source array
     */
    private static char[] substituteNonDigits(char[] characters, char digit) {
        char[] copy = Arrays.copyOf(characters, characters.length);
        for (int i = 0; i < copy.length; i++) {
            char ch = copy[i];
            if (ch != ' ' && ch != '+' && ch != '=' && !Character.isDigit(ch)) {
                char nonDigit = ch;
                copy[i] = digit;
                for (int j = i + 1; j < copy.length; j++) {
                    if (copy[j] == nonDigit) {
                        copy[j] = digit;
                    }
                }
                return copy;
            }
        }
        return copy;
    }
    
    private static boolean containsValidChars(char[] expression) {
        for (int i = 0; i < expression.length; i++) {
            if (Character.isLetter(expression[i])) {
                return false;
            }
        }
        return true;
    }
    
    private static boolean isCorrectSummationExpression(char[] expression) {
        int i = 0;
        while (expression[i] == ' ') {
            i++;
        }
        int j = 0;
        try {
            while (Character.isDigit(expression[j])) {
                j++;
            }
            String operand1 = new String(expression, i, j - i);
            i = j;
            while (expression[i] == ' ' || expression[i] == '+') {
                i++;
            }
            j = i;
            while (Character.isDigit(expression[j])) {
                j++;
            }
            String operand2 = new String(expression, i, j - i);
            i = j;
            while (expression[i] == ' ' || expression[i] == '=') {
                i++;
            }
            j = i;
            while (j < expression.length && Character.isDigit(expression[j])) {
                j++;
            }
            String result = new String(expression, i, j - i);
            int op1 = Integer.parseInt(operand1);
            int op2 = Integer.parseInt(operand2);
            int resInt = Integer.parseInt(result);
            return (op1 + op2) == resInt;
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }
}
