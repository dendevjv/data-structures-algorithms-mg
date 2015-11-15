/*
    P-5.29 
    Provide a nonrecursive implementation of the drawInterval method for the English ruler project of Section 5.1.2. 
    There should be precisely 2c - 1 lines of
    output if c represents the length of the center tick. If incrementing a counter from
    0 to 2c - 2, the number of dashes for each tick line should be exactly one more
    than the number of consecutive 1’s at the end of the binary representation of the
    counter.
 */
package ru.dendevjv.dsalgjavamg.ch05recursion.projects;

import java.util.Scanner;

public class P0529NonRecursiveDrawInterval {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of intervals: ");
        int numIntervals = sc.nextInt();
        sc.close();
        for (int i = 1; i <= numIntervals; i++) {
            System.out.println("Central Length = " + i);
            drawInterval(i);
        }
    }
    
    private static void drawInterval(int centralLength) {
        if (centralLength > 0) {
            int limit = (int) (Math.pow(2, centralLength)) - 2;
            for (int i = 0; i <= limit; i++) {
                drawLine(countOnesAtTheEnd(i) + 1);
            }
        }
    }
    
    private static int countOnesAtTheEnd(int i) {
        int count = 0;
        while ((i & 1) == 1) {
            i >>= 1;
            count++;
        }
        return count;
    }

    private static void drawLine(int tickLength) {
        drawLine(tickLength, -1);
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
    
}
