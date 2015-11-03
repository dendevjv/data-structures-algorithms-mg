package ru.dendevjv.dsalgjavamg.ch05recursion.examples;

import java.util.Arrays;
import java.util.Scanner;

import ru.dendevjv.dsalgjavamg.utils.Array;

public class Cf0515BinarySearch {

    public static void main(String[] args) {
        int[] array = Array.ofRandomElements(10, 10);
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter target: ");
        int target = sc.nextInt();
        sc.close();
        boolean found = binarySearchIterative(array, target);
        System.out.printf("Target %d is %s%n", target, found ? "found" : "not found");
    }
    
    /**
     * Returns true if the target value is found in the data array.
     */
    private static boolean binarySearchIterative(int[] data, int target) {
        int low = 0;
        int high = data.length - 1;
        int middle;
        while (low <= high) {
            middle = low + (high - low) / 2;
            if (data[middle] == target) {
                return true;
            } else if (target < data[middle]) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return false;
    }

}
