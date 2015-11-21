package ru.dendevjv.dsalgjavamg.ch06stacks.examples;

import java.util.Arrays;

public class Cf0605ReversingArray {
    /**
     * Generic method for reversing an array.
     * @param a array of objects
     */
    private static <E> void reverse(E[] a) {
        Stack<E> buffer = new ArrayStack<>(a.length);
        for (E e : a) {
            buffer.push(e);
        }
        for (int i = 0; i < a.length; i++) {
            a[i] = buffer.pop();
        }
    }

    /**
     * Test routine for reversing arrays.
     */
    public static void main(String[] args) {
        Integer[] a = {2, 4, 8, 16, 32, 64};
        String[] s = {"Jack", "Kate", "Hurley", "Jin", "Michael"};
        System.out.println("a = " + Arrays.toString(a));
        System.out.println("s = " + Arrays.toString(s));
        
        System.out.println("Reversing...");
        reverse(a);
        reverse(s);
        
        System.out.println("a = " + Arrays.toString(a));
        System.out.println("s = " + Arrays.toString(s));
    }

}
