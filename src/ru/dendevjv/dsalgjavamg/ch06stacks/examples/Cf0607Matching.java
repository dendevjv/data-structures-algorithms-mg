package ru.dendevjv.dsalgjavamg.ch06stacks.examples;

import java.util.Scanner;

public class Cf0607Matching {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.print("Enter parentheses: ");

            String p = scanner.nextLine();
            if (p.equals("exit")) {
                break;
            }
            Matcher m = new Matcher();
            boolean r = m.matches(p);
            System.out.println(r ? "match" : "do not match");
        }
        scanner.close();
    }
    
    /**
     * Textbook implementation.
     */
    public static boolean isMatched(String expression) {
        final String opening = "({[";
        final String closing = ")}]";
        Stack<Character> buffer = new Cf0604LinkedStack<>();
        for (char c : expression.toCharArray()) {
            if (opening.indexOf(c) != -1) {
                buffer.push(c);
            } else if (closing.indexOf(c) != -1) {
                if (buffer.isEmpty()) {
                    return false;
                }
                if (opening.indexOf(buffer.pop()) != closing.indexOf(c)) {
                    return false;
                }
            }
        }
        return buffer.isEmpty();
    }

    /**
     * My attempt to implement parentheses matching.
     *
     * @author dendevjv
     */
    private static class Matcher {
        private static final int EMPTY_TOP = -1;
        private static final int DEFAULT_SIZE = 100;
        private char[] stack;
        private int top;
        
        private Matcher() {
            stack = new char[DEFAULT_SIZE];
            top = EMPTY_TOP;
        }
        
        private void push(char ch) {
            stack[++top] = ch;
        }
        
        private char pop() {
            return stack[top--];
        }
        
        private int size() {
            return top + 1;
        }
        
        private boolean isEmpty() {
            return top == EMPTY_TOP;
        }
        
        boolean matches(String p) {
            top = EMPTY_TOP;
            char c;
            for (int i = 0; i < p.length(); i++) {
                char ch = p.charAt(i);
                switch (ch) {
                case '[':
                case '{':
                case '(':
                    push(ch);
                    break;
                case ']':
                case '}':
                case ')':
                    if (isEmpty()) {
                        return false;
                    }
                    c = pop();
                    if (ch == ']' && c != '[') {
                        return false;
                    }
                    if (ch == '}' && c != '{') {
                        return false;
                    }
                    if (ch == ')' && c != '(') {
                        return false;
                    }
                    break;
                }
            }
            return size() == 0;
        }
        
    }
}
