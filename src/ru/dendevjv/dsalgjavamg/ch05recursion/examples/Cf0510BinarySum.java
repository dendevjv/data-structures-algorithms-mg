package ru.dendevjv.dsalgjavamg.ch05recursion.examples;

import java.util.Arrays;
import java.util.Scanner;

import ru.dendevjv.dsalgjavamg.utils.Array;

public class Cf0510BinarySum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter length of array: ");
        int length = sc.nextInt();
        sc.close();
        int[] a = Array.makeSequence(length, 1);
        System.out.println(Arrays.toString(a));
        int sum = binarySum(a, 0, a.length - 1);
        System.out.println("sum = " + sum);
    }

    private static int binarySum(int[] a, int lo, int hi) {
        if (lo < hi) {
            int m = lo + (hi - lo) / 2;
            int sum1 = binarySum(a, lo, m);
            int sum2 = binarySum(a, m + 1, hi);
            return sum1 + sum2;
        } else if (lo == hi) {
            return a[lo];
        } else {
            return 0;
        }
    }

}
