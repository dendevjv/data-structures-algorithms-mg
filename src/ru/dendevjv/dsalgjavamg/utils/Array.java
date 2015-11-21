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
    
    public static int[] ofRandomDistinctElements(int size, int upperBoundary) {
        if (upperBoundary < size) {
            throw new IllegalArgumentException(
                    String.format(
                            "Value of upper boundary (%d) must not be less than size of array (%d)",
                            upperBoundary, size));
        }
        int[] a = new int [size];
        int value;
        boolean foundDuplicate, foundDistinct;
        for (int i = 0; i < size; i++) {
            foundDistinct = false;
            while (!foundDistinct) {
                value = random.nextInt(upperBoundary);
                foundDuplicate = false;
                for (int j = 0; !foundDuplicate && j < i; j++) {
                    if (a[j] == value) {
                        foundDuplicate = true;
                    }
                }
                if (!foundDuplicate) {
                    a[i] = value;
                    foundDistinct = true;
                }
            }
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
    
    /**
     * Returns the string containing <code>length</code> elements of array.
     * @param data array of objects
     * @param length number of elements to include in the resulting string
     * @return string of the form as returned in <code>java.util.Arrays.toString</code>
     */
    public static String toString(Object[] data, int length) {
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
    
    /**
     * Parses string representation of array into array of integers.
     * @param arrayAsString string as returned by Arrays.toString(int[])
     * @return array of integers
     */
    public static int[] parse(String arrayAsString) {
        if (arrayAsString.startsWith("[")) {
            arrayAsString = arrayAsString.substring(1);
        }
        if (arrayAsString.endsWith("]")) {
            arrayAsString = arrayAsString.substring(0, arrayAsString.length() - 1);
        }
        String[] tokens = arrayAsString.split(",\\s");
        int[] result = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            result[i] = Integer.parseInt(tokens[i]);
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[] a = ofRandomDistinctElements(20, 40);
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
