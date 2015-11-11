/*
    C-5.22 
    Suppose you are given an array, A, containing n distinct integers that are listed
    in increasing order. Given a number k, describe a recursive algorithm to find two
    integers in A that sum to k, if such a pair exists. 
 */
package ru.dendevjv.dsalgjavamg.ch05recursion.exercises;

import java.util.Arrays;
import java.util.Scanner;

import ru.dendevjv.dsalgjavamg.utils.Array;

public class C0522FindSumOfTwo {

    public static void main(String[] args) {
        int[] a = Array.ofRandomDistinctElements(10, 20);
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        
        Scanner sc = new Scanner(System.in);
        System.out.print("k: ");
        int k = sc.nextInt();
        sc.close();
        
        findTwoThatSumTo(k, a, 0);
    }
    
    private static void findTwoThatSumTo(int k, int[] a, int start) {
        int t = a[start];
        boolean pairNotFound = true;
        for (int i = start + 1; pairNotFound && i < a.length; i++) {
            if (t + a[i] == k) {
                System.out.printf("Found two numbers: %d + %d = %d%n", t, a[i], k);
                pairNotFound = false;
            }
        }
        if (pairNotFound) {
            start++;
            if (start < a.length) {
                findTwoThatSumTo(k, a, start);
            } else {
                System.out.println("Nothing found");
            }
        }
    }

}
