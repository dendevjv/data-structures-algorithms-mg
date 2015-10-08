package ru.dendevjv.dsalgjavamg.ch03fundamental;

import java.util.Arrays;
import java.util.Random;

public class ArrayTest {

    public static void main(String[] args) {
        int data[] = new int[10];
        Random rand = new Random();
        
        for (int i = 0; i < data.length; i++) {
            data[i] = rand.nextInt(100);
        }
        int[] original = Arrays.copyOf(data, data.length);
        System.out.println("arrays equal before sort: " + Arrays.equals(data, original));
        Arrays.sort(data);
        System.out.println("arrays equal before after: " + Arrays.equals(data, original));
        System.out.println("original = " + Arrays.toString(original));
        System.out.println("    data = " + Arrays.toString(data));
    }

}
