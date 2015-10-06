package ru.dendevjv.dsalgjavamg.ch01.exercises;

import java.util.Random;

public class P0128RandomTypos {
    private static Random rnd = new Random();

    public static void main(String[] args) {
        String s = "I will never spam my friends again";
        for (int i = 0; i < 10; i++) {
            System.out.println(makeTypos(s, 8));
        }
    }

    private static String makeTypos(String s, int numTypos) {
        StringBuilder sb = new StringBuilder(s);
        int step = s.length() / numTypos;
        for (int i = 0; i < numTypos; i++) {
            Typo typo = new Typo();
            int from = i * step;
            int to = (i + 1) * step;
            typo.makeTypo(sb, from, to);
        }
        return sb.toString();
    }

    private static class Typo {
        enum Type {
            CHANGE_VOWEL, SWAP_LETTERS
        }

        private static char[] vowels = { 'a', 'e', 'i', 'o', 'u' };
        private static Type[] typeValues = Type.values();

        private Type type;

        Typo() {
            type = typeValues[rnd.nextInt(typeValues.length)];
        }

        void makeTypo(StringBuilder sb, int from, int to) {
            switch (type) {
            case CHANGE_VOWEL:
                int vowelIdx = findVowel(sb, from, to);
                if (vowelIdx > -1) {
                    replaceVowel(sb, vowelIdx);
                    break;
                }
            case SWAP_LETTERS:
                int pos = from + rnd.nextInt(to - from);
                if (from == 0) {
                    swapChars(sb, pos, 1); // swap right
                } else if (to == sb.length()) {
                    swapChars(sb, pos, -1); // swap left
                } else { // swap random
                    swapChars(sb, pos, Math.random() > 0.5 ? 1 : -1);
                }
                break;
            default:
                throw new RuntimeException("Invalid type of typo: " + type);
            }
        }

        private static void swapChars(StringBuilder sb, int pos, int move) {
            char ch2 = sb.charAt(pos + move);
            sb.setCharAt(pos + move, sb.charAt(pos));
            sb.setCharAt(pos, ch2);
        }

        private void replaceVowel(StringBuilder sb, int vowelIdx) {
            char v = sb.charAt(vowelIdx);
            char nv = getOtherVowel(v);
            sb.setCharAt(vowelIdx, nv);
        }

        private char getOtherVowel(char v) {
            do {
                int i = rnd.nextInt(vowels.length);
                if (vowels[i] != v) {
                    return vowels[i];
                }
            } while (true);
        }

        private int findVowel(StringBuilder sb, int from, int to) {
            for (int i = from; i < to; i++) {
                char ch = Character.toLowerCase(sb.charAt(i));
                if (isVowel(ch)) {
                    return i;
                }
            }
            return -1;
        }

        private static boolean isVowel(char ch) {
            for (char v : vowels) {
                if (ch == v) {
                    return true;
                }
            }
            return false;
        }
    }
}
