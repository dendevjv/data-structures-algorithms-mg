/*
    C-3.22 
    Write a method, shuffle(A), that rearranges the elements of array A so that every
    possible ordering is equally likely. You may rely on the nextInt(n) method of
    the java.util.Random class, which returns a random number between 0 and n - 1
    inclusive.
 */
package ru.dendevjv.dsalgjavamg.ch03fundamental.exercises;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class C0322Shuffling {
    private static final int SIZE = 20;
    private static Random random = new Random();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of repetitions: ");
        int numRepetitions = sc.nextInt();
        sc.close();
        
        int[][] stats = new int[SIZE][SIZE + 1];
        
        for (int k = 0; k < numRepetitions; k++) {
            int[] arr = new int[SIZE];
            for (int i = 1; i <= arr.length; i++) {
                arr[i - 1] = i;
            }
            
            shuffle(arr);
            for (int i = 0; i < arr.length; i++) {
                stats[i][arr[i]]++;
            }
        }
        print(stats);
    }

    private static void print(int[][] arr) {
        for (int row = 0; row < arr.length; row++) {
            System.out.println(Arrays.toString(arr[row]));
        }
    }

    private static void shuffle(int[] arr) {
        int target = 0;
        while (target < arr.length - 1) {
            int source = target + random.nextInt(arr.length - target);
            swap(arr, target, source);
            target++;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
