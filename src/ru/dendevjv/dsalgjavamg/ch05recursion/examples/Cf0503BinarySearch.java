package ru.dendevjv.dsalgjavamg.ch05recursion.examples;

import java.util.Arrays;

import ru.dendevjv.dsalgjavamg.utils.Array;

public class Cf0503BinarySearch {

    public static void main(String[] args) {
        int[] array = Array.ofRandomElements(10, 10);
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        int target = 5;
        boolean found = binarySearch(array, target , 0 , array.length - 1);
        int foundAt = binarySearchMine(array, target, 0, array.length - 1);
        if (found) {
            System.out.println("Found at: " + foundAt);
        } else {
            System.out.println("Not found.");
        }
    }
    
    /**
     * Returns true if the target value is found in the indicated portion of the data array.
     * This search only considers the array portion from data[low] to data[high] inclusive.
     */
    private static boolean binarySearch(int[] data, int target, int low, int high) {
        if (low > high) {
            return false;
        } else {
            int mid = (low + high) / 2;
            if (target == data[mid]) {
                return true;
            } else if (target < data[mid]) {
                return binarySearch(data, target, low, mid - 1);
            } else {
                return binarySearch(data, target, mid + 1, high);
            }
        }
    }

    /**
     * My implementation of binary search.
     */
    private static int binarySearchMine(int[] data, int target, int low, int high) {
        while (low <= high) {
            int median = (low + high) /  2;
            int current = data[median];
            if (current == target) {
                return median;
            } else if (target < current) {
                return binarySearchMine(data, target, low, median - 1);
            } else {
                return binarySearchMine(data, target, median + 1, high);
            }
        }
        return -1;
    }

}
