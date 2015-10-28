package ru.dendevjv.dsalgjavamg.ch04analysis.examples;

import java.util.Arrays;

import ru.dendevjv.dsalgjavamg.utils.Array;

public class E0407ElementUniqueness {

    public static void main(String[] args) {
        int[] a = Array.ofRandomElements(20, 100);
        System.out.println(Arrays.toString(a));
        System.out.printf("Array has %s elements%n", unique1(a) ? "unique"
                : "not unique");
    }

    private static boolean unique1(int[] data) {
        int n = data.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (data[i] == data[j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
