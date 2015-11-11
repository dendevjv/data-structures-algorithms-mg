/*
    C-5.24 
    Isabel has an interesting way of summing up the values in an array A of n integers,
    where n is a power of two. She creates an array B of half the size of A and sets
    B[i] = A[2i] + A[2i + 1], for i = 0, 1,..., (n/2) - 1. If B has size 1, then she
    outputs B[0]. Otherwise, she replaces A with B, and repeats the process. What is
    the running time of her algorithm?
 */
package ru.dendevjv.dsalgjavamg.ch05recursion.exercises;

import java.util.Scanner;

import ru.dendevjv.dsalgjavamg.utils.Array;
import ru.dendevjv.dsalgjavamg.utils.StopWatch;

public class C0524RecursiveSumming {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Array size: ");
        int arraySize = sc.nextInt();
        sc.close();

        StopWatch watch = new StopWatch();
        int numTests = 1000;
        int numTestArrays = 10;
        int[][] testArrays = new int[numTestArrays][];
        for (int i = 0; i < numTestArrays; i++) {
            testArrays[i] = Array.ofRandomElements(arraySize, arraySize);
        }
        
        watch.start("Recursion");
        for (int i = 0; i < numTests; i++) {
            int[] a = testArrays[i % testArrays.length];
            sumRecursive(a);
        }
        watch.stop();
        
        watch.start("Iteration");
        for (int i = 0; i < numTests; i++) {
            int[] a = testArrays[i % testArrays.length];
            expectedSum(a);
        }
        watch.stop();
    }

    private static int sumRecursive(int[] a) {
        if (Integer.bitCount(a.length) != 1) {
            throw new IllegalArgumentException("Length of array must be power of 2");
        }
        if (a.length == 1) {
            return a[0];
        }
        int[] b = new int[a.length / 2];
        for (int i = 0; i < b.length; i++) {
            b[i] = a[2 * i] + a[2 * i + 1];
        }
        return sumRecursive(b);
    }

    private static int expectedSum(int[] a) {
        int sum = 0;
        for (int i : a) {
            sum += i;
        }
        return sum;
    }
}
