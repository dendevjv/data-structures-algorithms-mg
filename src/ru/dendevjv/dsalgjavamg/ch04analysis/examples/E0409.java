package ru.dendevjv.dsalgjavamg.ch04analysis.examples;

import java.util.Arrays;

public class E0409 {

    public static void main(String[] args) {
        double[] x = {1, 2, 3, 4};
        System.out.println(Arrays.toString(x));
        double[] a1 = prefixAverage1(x);
        System.out.println(Arrays.toString(a1));
        double[] a2 = prefixAverage2(x);
        System.out.println(Arrays.toString(a2));
    }

    /** Returns an array a such that, for all j, a[j] equals the average of x[0], ..., x[j]. */
    private static double[] prefixAverage1(double[] x) {
        double[] a = new double[x.length];
        for (int i = 0; i < x.length; i++) {
            double total = 0.0;
            for (int j = 0; j <= i; j++) {
                total += x[j];
            }
            a[i] = total / (i + 1);
        }
        return a;
    }
    
    private static double[] prefixAverage2(double[] x) {
        double[] a = new double[x.length];
        double total = 0;
        for (int i = 0; i < a.length; i++) {
            total += x[i];
            a[i] = total / (i + 1);
        }
        return a;
    }
}
