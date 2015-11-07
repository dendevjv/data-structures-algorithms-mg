/*
    C-5.20 
    Write a short recursive Java method that rearranges an array of integer values so
    that all the even values appear before all the odd values.
 */
package ru.dendevjv.dsalgjavamg.ch05recursion.exercises;

import java.util.Arrays;

import ru.dendevjv.dsalgjavamg.utils.Array;

public class C0520EvenBeforeOdd {

    public static void main(String[] args) {
        int[] a = Array.ofRandomElements(10, 10);
        System.out.println(Arrays.toString(a));
        arrange(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }
    
    /**
     * Rearranges array of integer values so that all the even values appear
     * before all the odd values.
     * @param a array of integer values
     * @param low lowest index
     * @param high highest index
     */
    private static void arrange(int[] a, int low, int high) {
        if (low < high) {
            if (a[low] % 2 == 0) {
                low++;
            } else {
                if (a[high] % 2 == 0) {
                    int tmp = a[low];
                    a[low] = a[high];
                    a[high] = tmp;
                    low++;
                }
                high--;
            }
            arrange(a, low, high);
        }
    }

}
