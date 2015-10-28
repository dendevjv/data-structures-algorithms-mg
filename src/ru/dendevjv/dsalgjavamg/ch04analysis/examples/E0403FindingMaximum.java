package ru.dendevjv.dsalgjavamg.ch04analysis.examples;

public class E0403FindingMaximum {

    public static void main(String[] args) {
        int[] a = {3, 7, 11, 4};
        int m = arrayMax(a);
        System.out.println(m);
    }

    private static int arrayMax(int[] array) {
        int currentMaximum = array[0];
        for (int j = 1; j < array.length; j++) {
            if (array[j] > currentMaximum) {
                currentMaximum = array[j];
            }
        }
        return currentMaximum;
    }
}
