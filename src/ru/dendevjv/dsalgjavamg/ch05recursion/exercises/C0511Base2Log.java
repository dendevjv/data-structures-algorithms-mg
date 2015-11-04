/*
    C-5.11 
    Describe a recursive algorithm to compute the integer part of the base-two 
    logarithm of n using only addition and integer division.
 */
package ru.dendevjv.dsalgjavamg.ch05recursion.exercises;

import java.util.Scanner;

public class C0511Base2Log {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("x: ");
        double x = sc.nextDouble();
        sc.close();
        int r = base2log(x);
        System.out.println("r = " + r);
    }

    // 1 -> 0
    // 2 -> 1
    // 4 -> 2
    // 8 -> 3
    static int base2log(double x) {
        if (x < 1.0) {
            throw new IllegalArgumentException("Argument must be >= 1.0");
        }
        if (x < 2.0) {
            return 0;
        }
        return 1 + base2log(x / 2.0);
    }

}
