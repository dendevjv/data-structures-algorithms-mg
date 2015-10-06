package ru.dendevjv.dsalgjavamg.ch02;

import java.util.Arrays;

public class GenericDemo {
    public static <T> void reverse(T[] data) {
        int lo = 0, hi = data.length - 1;
        T temp;
        while (lo < hi) {
            temp = data[lo];
            data[lo++] = data[hi];
            data[hi--] = temp;
        }
    }
    
    public static void main(String[] args) {
        Integer[] ai = {2, 3, 5};
        System.out.println(Arrays.toString(ai));
        reverse(ai);
        System.out.println(Arrays.toString(ai));
    }
}
