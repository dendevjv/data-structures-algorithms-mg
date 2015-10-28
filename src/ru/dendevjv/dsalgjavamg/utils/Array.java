package ru.dendevjv.dsalgjavamg.utils;

import java.util.Random;

public class Array {
    private static Random random = new Random();
    
    public static int[] ofRandomElements(int size, int upperBoundary) {
        int[] a = new int [size];
        for (int i = 0; i < size; i++) {
            a[i] = random.nextInt(upperBoundary);
        }
        return a;
    }
}
