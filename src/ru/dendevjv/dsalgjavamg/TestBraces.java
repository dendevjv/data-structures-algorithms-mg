package ru.dendevjv.dsalgjavamg;

public class TestBraces {
    private static class BracesChecker {
        public static boolean isCorrect(String text) {
            java.util.Deque<Character> stack = new java.util.ArrayDeque<>();
            Character openingBrace;
            int pos = 0;
            while (pos < text.length()) {
                char ch = text.charAt(pos++);
                switch (ch) {
                case '{':
                case '(':
                    stack.push(ch);
                    break;
                case '}':
                case ')':
                    openingBrace = stack.peek();
                    if (openingBrace == null) {
                        return false;
                    }
                    if (ch == '}' && openingBrace.charValue() == '{'
                            || ch == ')' && openingBrace.charValue() == '(') {
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
                }
            }
            return stack.size() == 0;
        }
    }

    private static void assertTrue(boolean b) {
        System.out.println(b ? "Ok" : "failed");
    }

    private static void assertFalse(boolean b) {
        System.out.println(!b ? "Ok" : "failed");
    }

    public static void main(String[] args) {
         assertTrue(BracesChecker.isCorrect(""));
         assertTrue(BracesChecker.isCorrect("()"));
         assertTrue(BracesChecker.isCorrect("{()}"));
         assertTrue(BracesChecker.isCorrect("{()}{}"));
         assertTrue(BracesChecker.isCorrect("(())"));
         assertTrue(BracesChecker.isCorrect("((a))"));
         assertTrue(BracesChecker.isCorrect("{({({({()})})})}"));
         assertFalse(BracesChecker.isCorrect("{(})"));
         assertFalse(BracesChecker.isCorrect("(})"));
         assertFalse(BracesChecker.isCorrect("{(}"));
    }

}
