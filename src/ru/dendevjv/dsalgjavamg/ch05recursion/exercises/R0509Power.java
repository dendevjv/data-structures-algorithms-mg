package ru.dendevjv.dsalgjavamg.ch05recursion.exercises;

import java.util.Scanner;

public class R0509Power {

    public static void main(String[] args) {
        test(1.0, 2.0, 0);
        test(2.0, 2.0, 1);
        test(4.0, 2.0, 2);
        test(8.0, 2.0, 3);
        test(16.0, 2.0, 4);
        test(32.0, 2.0, 5);
        test(2048.0, 2.0, 11);
    }
    
    private static void test(double expected, double x, int e) {
        double actual = power(x, e);
        boolean r = Math.abs(expected - actual) < 1e-14;
        String format = "test(%.1f, %.1f, %d)";
        if (r) {
            System.out.printf(format + " passed%n", expected, x, e);
        } else {
            System.out.printf(format + " FAILED (expected=%.1f but actual=%.1f)%n", 
                    expected, x, e, expected, actual);
        }
    }

    private static double power(double x, int e) {
        if (e == 0) {
            return 1.0;
        } else if (e == 1) {
            return x;
        }
        double r = x;
        int p = 1;
        while (p < e) {
            if (p * 2 <= e) {
                r = r * r;
                p *= 2;
            } else {
                r = r * x;
                p++;
            }
        }
        assert p == e: String.format("p=%d != e=%d", p, e);
        return r;
    }

    private static void interactive() {
        Scanner sc = new Scanner(System.in);
        System.out.print("x and e: ");
        double x = sc.nextDouble();
        int e = sc.nextInt();
        sc.close();
        double r = power(x, e);
        System.out.println(r);
    }


}
