/*
    C-5.12 
    Describe an efficient recursive algorithm for solving the element uniqueness
    problem, which runs in time that is at most O(n2) in the worst case without using
    sorting.
 */
package ru.dendevjv.dsalgjavamg.ch05recursion.exercises;

import java.util.Arrays;

import ru.dendevjv.dsalgjavamg.utils.Array;

public class R0512Uniqueness {

    public static void main(String[] args) {
        int[] a = Array.ofRandomElements(15, 100);
        System.out.println(Arrays.toString(a));
        boolean r = uniqueFromIndex(a, 0);
        boolean r2 = Array.allElementsUnique(a);
        if (r) {
            System.out.println("All elements are unique");
        } else {
            System.out.println("The array contains non unique elements");
        }
        System.out.println("Second check: " + (r2 ? " unique" : " non unique"));
    }

    private static boolean uniqueFromIndex(int[] a, int index) {
        if (index == a.length - 1) {
            return true;
        }
        boolean u = true;
        for (int i = index + 1; i < a.length; i++) {
            if (a[index] == a[i]) {
                u = false;
                break;
            }
        }
        if (!u) {
            return false;
        }
        return uniqueFromIndex(a, index + 1);
    }

}
