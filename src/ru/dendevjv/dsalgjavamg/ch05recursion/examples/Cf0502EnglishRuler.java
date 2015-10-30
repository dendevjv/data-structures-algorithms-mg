package ru.dendevjv.dsalgjavamg.ch05recursion.examples;

import java.util.Scanner;

public class Cf0502EnglishRuler {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of inches and tick length: ");
        int n = sc.nextInt();
        int length = sc.nextInt();
        sc.close();
        drawRuler(n, length);
    }
    
    private static void drawRuler(int nInches, int majorLength) {
        drawLine(majorLength, 0);
        for (int j = 1; j <= nInches; j++) {
            drawInterval(majorLength - 1);
            drawLine(majorLength, j);
        }
    }

    private static void drawInterval(int centralLength) {
        if (centralLength > 0) {
            drawInterval(centralLength - 1);
            drawLine(centralLength);
            drawInterval(centralLength - 1);
        }
    }

    private static void drawLine(int tickLength, int tickLabel) {
        for (int j = 0; j < tickLength; j++) {
            System.out.print("-");
        }
        if (tickLabel >= 0) {
            System.out.print(" " + tickLabel);
        }
        System.out.println();
    }

    private static void drawLine(int tickLength) {
        drawLine(tickLength, -1);
    }


}
