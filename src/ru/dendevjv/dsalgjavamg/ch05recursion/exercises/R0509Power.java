package ru.dendevjv.dsalgjavamg.ch05recursion.exercises;

import java.util.Scanner;
import java.util.logging.Logger;

public class R0509Power {
    private static Logger logger = Logger.getLogger(R0509Power.class.getName());
    static {
        logger.setLevel(java.util.logging.Level.INFO);
        
        /* Setting handler programmatically (not using file "logging.properties") */
//        logger.setUseParentHandlers(false);
//        java.util.logging.ConsoleHandler handler = new java.util.logging.ConsoleHandler();
//        handler.setLevel(java.util.logging.Level.FINE);
//        logger.addHandler(handler);
    }
    private static boolean allTestsPassed = true;

    public static void main(String[] args) {
        test(1.0, 2.0, 0);
        test(2.0, 2.0, 1);
        test(4.0, 2.0, 2);
        test(8.0, 2.0, 3);
        test(16.0, 2.0, 4);
        test(32.0, 2.0, 5);
        test(2048.0, 2.0, 11);
        
        if (allTestsPassed) {
            logger.info("All tests passed");
        } else {
            logger.info("Some tests FAILED");
        }
        
//        interactive();
    }
    
    private static void test(double expected, double x, int e) {
        double actual = power(x, e);
        boolean passed = Math.abs(expected - actual) < 1e-14;
        String format = "test(%.1f, %.1f, %d)";
        if (passed) {
            logger.info(String.format(format + " passed%n", expected, x, e));
        } else {
            allTestsPassed = false;
            logger.info(String.format(format + " FAILED (expected=%.1f but actual=%.1f)%n", 
                    expected, x, e, expected, actual));
        }
    }
    
    @SuppressWarnings("unused")
    private static double power2(double x, int e) {
        double r = 1.0;
        int p = -1;
        while (p < e) {
            if (p == -1) {
                r = 1.0;
                p++;
            } else if (p == 0) {
                r *= x;
                p++;
            } else if (p * 2 <= e) {
                r = r * r;
                p *= 2;
            } else {
                r *= x;
                p++;
            }
        }
        assert p == e: String.format("p=%d != e=%d", p, e);
        return r;
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
            double r1 = r;
            if (p * 2 <= e) {
                r = r * r;
                logger.fine(String.format("Squaring: %.1f * %.1f = %.1f%n", r1, r1, r));
                p *= 2;
            } else {
                r = r * x;
                logger.fine(String.format("Multiplying: %.1f * %.1f = %.1f%n", r1, x, r));
                p++;
            }
        }
        assert p == e: String.format("p=%d != e=%d", p, e);
        return r;
    }

    @SuppressWarnings("unused")
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
