package ru.dendevjv.dsalgjavamg.utils;

import java.util.Arrays;
import java.util.Random;

/**
 * Utility class contains methods for creating arrays, checking arrays and converting to strings.
 * @author dendevjv
 */
public class Array {
    private static Random random = new Random();
    
    public static int[] makeSequence(int size, int startingValue) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i + startingValue;
        }
        return array;
    }
    
    public static int[] ofRandomElements(int size, int upperBoundary) {
        int[] a = new int [size];
        for (int i = 0; i < size; i++) {
            a[i] = random.nextInt(upperBoundary);
        }
        return a;
    }
    
    public static boolean allElementsUnique(int[] data) {
        int[] a = Arrays.copyOf(data, data.length);
        Arrays.sort(a);
        int n = a.length - 1;
        for (int i = 0; i < n; i++) {
            if (a[i] == a[i + 1]) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Returns the string containing <code>length</code> elements of array.
     * @param data array of integer elements
     * @param length number of elements to include in the resulting string
     * @return string of the form as returned in <code>java.util.Arrays.toString</code>
     */
    public static String toString(int[] data, int length) {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        if (length > 0) {
            sb.append(data[0]);
        }
        for (int i = 1; i < length; i++) {
            sb.append(", ");
            sb.append(data[i]);
        }
        sb.append(']');
        return sb.toString();
    }
}
