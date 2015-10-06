package ru.dendevjv.dsalgjavamg.ch01.exercises;

/**
 * Write a short Java program that outputs all possible strings formed by using
 * the characters 'c', 'a', 't', 'd', 'o' and 'g' exactly once.
 */
public class C0122 {

    public static void main(String[] args) {
        // char[] a = {'c', 'a', 't', 'd', 'o', 'g'};
        char[] a = { 'c', 'a', 't' };
        permutations(a);
    }

    private static void permutations(char[] a) {
        for (int i = 0; i < a.length; i++) {
            permutations(a, i + 1);
            shiftLeft(a);
        }
    }

    private static void permutations(char[] a, int from) {
        if (from == a.length - 1) {
            System.out.println(a);
            return;
        }
        for (int i = from; i < a.length; i++) {
            permutations(a, i + 1);
            shiftLeft(a);
        }
    }

    @SuppressWarnings("unused")
    private static void shiftLeft(char[] a, int from) {
        char leftest = a[from];
        for (int i = from; i < a.length - 1; i++) {
            a[i] = a[i + 1];
        }
        a[a.length - 1] = leftest;
    }

    private static void shiftLeft(char[] a) {
        char leftest = a[0];
        for (int i = 0; i < a.length - 1; i++) {
            a[i] = a[i + 1];
        }
        a[a.length - 1] = leftest;
    }

}
