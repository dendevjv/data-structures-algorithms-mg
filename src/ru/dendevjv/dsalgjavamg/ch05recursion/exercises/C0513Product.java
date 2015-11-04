/*
    C-5.13 
    Give a recursive algorithm to compute the product of two positive integers, m and
    n, using only addition and subtraction.
 */
package ru.dendevjv.dsalgjavamg.ch05recursion.exercises;

import java.util.Scanner;

public class C0513Product {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a and b: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        sc.close();
        int c = product(a, b);
        System.out.printf("%d * %d = %d%n", a, b, c);
    }

    private static int product(int a, int b) {
        if (b == 1) {
            return a;
        }
        return a + product(a, b - 1);
    }

}
