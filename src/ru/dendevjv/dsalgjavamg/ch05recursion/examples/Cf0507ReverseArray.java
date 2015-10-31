package ru.dendevjv.dsalgjavamg.ch05recursion.examples;

import java.util.Arrays;

public class Cf0507ReverseArray {

    public static void main(String[] args) {
        int[] a = new int[10];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        System.out.println(Arrays.toString(a));
        reverseArray(a, 0, a.length - 1);
//        reverseArray(a, 2, 7);
        System.out.println(Arrays.toString(a));
    }

    /**
     * Reverses the contents of subarray data[low] through data[high] inclusive.
     */
    private static void reverseArray(int[] data, int low, int high) {
        if (low < high) {
            int tmp = data[low];
            data[low] = data[high];
            data[high] = tmp;
            reverseArray(data, low + 1, high - 1);
        }
    }

}
