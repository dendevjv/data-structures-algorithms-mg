package ru.dendevjv.dsalgjavamg.ch05recursion.examples;

import java.util.Scanner;

public class Cf0508Power {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number and power: ");
        int x = sc.nextInt();
        int n = sc.nextInt();
        sc.close();
        System.out.println(power1(x, n));
        System.out.println(power(x, n));
    }

    private static int power1(int x, int n) {
        if (n == 0) {
            return 1;
        } else {
            return x * power1(x, n - 1);
        }
    }

    /**
     * Computes the value of x raised to the n-th power, for nonnegative integer n.
     */
    private static double power(double x, int n) {
        if (n == 0) {
            return 1;
        } else {
            double partial = power(x, n / 2);
            double result = partial * partial;
            if ((n % 2) == 1) {
                result *= x;
            } 
            return result;
        }
    }

}
