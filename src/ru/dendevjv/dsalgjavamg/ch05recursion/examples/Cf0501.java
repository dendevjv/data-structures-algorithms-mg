/* Code Fragment 5.1: A recursive implementation of the factorial function. */
package ru.dendevjv.dsalgjavamg.ch05recursion.examples;

import java.util.Scanner;

public class Cf0501 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        int f = factorial(n);
        System.out.println(f);
    }

    private static int factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        } else if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

}
