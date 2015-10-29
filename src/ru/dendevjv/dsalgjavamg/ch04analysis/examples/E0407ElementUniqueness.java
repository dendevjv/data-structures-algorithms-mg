package ru.dendevjv.dsalgjavamg.ch04analysis.examples;

import java.util.Arrays;

import ru.dendevjv.dsalgjavamg.utils.Array;

public class E0407ElementUniqueness {

    public static void main(String[] args) {
        int[] a = Array.ofRandomElements(20, 100);
        System.out.println(Arrays.toString(a));
        System.out.printf("1: Array has %s elements%n", unique1(a) ? "unique"
                : "not unique");
        System.out.printf("2: Array has %s elements%n", unique2(a) ? "unique"
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
    
    private static boolean unique2(int[] data) {
        int[] array = Arrays.copyOf(data, data.length);
        Arrays.sort(array);
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == array[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
