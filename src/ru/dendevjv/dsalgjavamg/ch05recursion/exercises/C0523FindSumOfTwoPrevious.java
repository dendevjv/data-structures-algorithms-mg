/*
    C-5.23 
    Describe a recursive algorithm that will check if an array A of integers contains
    an integer A[i] that is the sum of two integers that appear earlier in A, that is, such
    that A[i] = A[ j] + A[k] for j, k < i.
 */
package ru.dendevjv.dsalgjavamg.ch05recursion.exercises;

import java.util.Arrays;

import ru.dendevjv.dsalgjavamg.utils.Array;

public class C0523FindSumOfTwoPrevious {

    public static void main(String[] args) {
        int[] a = Array.ofRandomElements(10, 40);
        System.out.println(Arrays.toString(a));
        
        boolean r = findSumOf2Previous(a, a.length - 1);
        System.out.println(r ? "Sum is found" : "Sum is not found");
    }

    private static boolean findSumOf2Previous(int[] a, int last) {
        int sum = a[last];
        boolean sumNotFound = true;
        for (int i = last - 1; sumNotFound && i > 0; i--) {
            for (int j = i - 1; sumNotFound && j >= 0; j--) {
                if (a[j] + a[i] == sum) {
                    System.out.printf("Found sum: %d + %d = %d%n", a[i], a[j], sum);
                    sumNotFound = false;
                }
            }
        }
        if (sumNotFound) {
            last--;
            if (last > 1) {
                return findSumOf2Previous(a, last);
            } else {
                return false;
            }
        } else {
            return true;
        }
    }
}
