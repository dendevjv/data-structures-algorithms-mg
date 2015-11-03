package ru.dendevjv.dsalgjavamg.ch05recursion.exercises;

import java.util.Scanner;

public class R0507HarmonicNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("n: ");
        int n = sc.nextInt();
        sc.close();
        double hn = harmonicNumber(n);
        System.out.println(hn);
    }

    private static double harmonicNumber(int n) {
        if (n == 1) {
            return 1.0;
        }
        return harmonicNumber(n - 1) + 1.0 / n;
    }

}
