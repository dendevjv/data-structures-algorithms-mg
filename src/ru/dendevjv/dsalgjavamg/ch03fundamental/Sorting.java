package ru.dendevjv.dsalgjavamg.ch03fundamental;

public class Sorting {
    /** Insertion-sort of array of characters into nondecreasing order. */
    public static void insertionSort(char[] data) {
        for (int k = 1; k < data.length; k++) {
            char current = data[k];
            int j = k;
            while (j > 0 && data[j - 1] > current) {
                data[j] = data[j - 1];
                j--;
            }
            data[j] = current;
        }
    }
}
