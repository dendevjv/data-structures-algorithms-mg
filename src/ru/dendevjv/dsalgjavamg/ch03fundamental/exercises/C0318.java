package ru.dendevjv.dsalgjavamg.ch03fundamental.exercises;

import java.util.Arrays;

public class C0318 {

    public static void main(String[] args) {
        test(new int[] {0, 2, 3, 4, 5}, new int[] {1, 2, 1, 1, 1, 1});
        test(new int[] {0, 1, 2, 3, 4}, new int[] {1, 1, 1, 1, 1, 2});
        test(new int[] {1, 2, 3, 4, 5}, new int[] {2, 1, 1, 1, 1, 1});
        test(new int[] {4, 5, 6, 7, 8}, new int[] {2, 2, 2, 2, 1, 1, 1, 1, 1});
        test(new int[] {0, 2, 3, 4, 5}, new int[] {1, 2, 1, 1, 1, 1});
        test(new int[] {0, 1, 2, 3, 5}, new int[] {1, 1, 1, 1, 2, 1});
    }

    private static void test(int[] expected, int[] arr) {
        int[] actual = findFive(arr);
        if (Arrays.equals(expected, actual)) {
            System.out.printf("OK: found %s%n", Arrays.toString(actual));
        } else {
            System.out.printf("failed: expected=%s, actual=%s%n", 
                    Arrays.toString(expected), Arrays.toString(actual));
        }
    }

    private static int[] findFive(int[] a) {
        int numDupes = 5;
        int[] r = new int[numDupes];
        for (int i = 0; i < a.length - (numDupes - 1); i++) {
            int value = a[i];
            int k = 0;
            r[k] = i;
            int count = 1;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] == value) {
                    r[++k] = j;
                    count++;
                    if (count == numDupes) {
                        return r;
                    }
                }
            }
        }
        return null;
    }

}
