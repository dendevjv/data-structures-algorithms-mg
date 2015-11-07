/*
    C-5.21 
    Given an unsorted array, A, of integers and an integer k, describe a recursive
    algorithm for rearranging the elements in A so that all elements less than or equal
    to k come before any elements larger than k. 
 */
/*
Logic cases:
left    k   right
    2   5   9           lo++ hi--
    5   5   9           hi--
    9   5   9           hi--    
    
    2   5   5           lo++
    5   5   5           hi--    
    9   5   5   swap    hi--
    
    2   5   2           lo++
    5   5   2   swap    lo++
    9   5   2   swap    lo++ hi--
 */
package ru.dendevjv.dsalgjavamg.ch05recursion.exercises;

import java.util.Arrays;

import ru.dendevjv.dsalgjavamg.utils.Array;

public class C0521Partitioning {

    public static void main(String[] args) {
//        String as = "[5, 5, 8, 1, 5, 9, 3, 2, 6, 5]";
//        String as = "[3, 0, 4, 6, 7, 5, 6, 1, 7, 6]";
//        int[] a = Array.parse(as);
        
        final int size = 10;
        int[] a = Array.ofRandomElements(size, size);
        
        System.out.println(Arrays.toString(a));
        partition(a, size / 2);
        System.out.println(Arrays.toString(a));
        System.out.printf("Array is %s%n", isPartitioned(a, size/2) ? "partitioned" : "NOT partitioned");
    }

    private static void partition(int[] a, int k) {
        partition(a, k, 0, a.length - 1);
    }
    
    /*
     * 
     */
    private static void partition(int[] a, int k, int lo, int hi) {
        if (lo < hi) {
            int left = a[lo];
            int right = a[hi];
//            System.out.printf("a[%d]=%d ? a[%d]=%d%n", lo, left, hi, right);
            if (right > k) {
                if (left <  k) {
                    lo++;
                }
                hi--;
            } else if (right == k) {
                if (left < k) {
                    lo++;
                } else {
                    if (left > k) {
                        swap(a, lo, hi);
                    }
                    hi--;
                }
            } else { // right < k
                if (left >= k) {
                    swap(a, lo, hi);
                    lo++;
                    if (left > k) {
                        hi--;
                    }
                } else {
                    lo++;
                }
            }
            partition(a, k, lo, hi);
        }
    }
    
    private static boolean isPartitioned(int[] a, int k) {
        boolean foundDivider = false;
        for (int i = 0; i < a.length; i++) {
            if (a[i] >= k) {
                foundDivider = true;
                continue;
            }
            if (foundDivider && a[i] < k) {
                return false;
            }
        }
        return true;
    }
    
    private static void swap(int[] a, int i, int j) {
//        System.out.printf("swapping a[%d]=%d and a[%d]=%d%n", i, a[i], j, a[j]);
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
