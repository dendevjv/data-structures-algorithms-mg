/*
    C-5.15 
    Write a recursive method that will output all the subsets of a set of n elements
    (without repeating any subsets).
 */
package ru.dendevjv.dsalgjavamg.ch05recursion.exercises;

public class C0515SubSets {

    public static void main(String[] args) {
        String s = "123";
        subSets4(s);
    }

    private static void subSets4(String s) {
        if (s.length() == 1) {
            System.out.println(s);
        } else {
            String p2 = s.substring(0, 1);
            String tail = s.substring(1);
            subSets4(p2, tail);
            subSets4(tail);
        }
    }
    
    private static void subSets4(String f, String s) {
        if (s.length() < 2) {
            System.out.println(f + s);
        } else {
            String p2 = s.substring(0, 1);
            String tail = s.substring(1);
            subSets4(f + p2, tail);
            subSets4(tail);
        }
    }
    
    private static void subSets3(String prefix, String s) {
        if (s.length() < 2) {
            System.out.println(prefix + s);
        } else {
            String p2 = s.substring(0, 1);
            String tail = s.substring(1);
            subSets3(prefix + p2, tail);
            subSets3(tail);
        }
    }
    
    private static void subSets3(String s) {
        if (s == null || s.isEmpty()) {
            return;
        }
        if (s.length() == 1) {
            System.out.println(s);
        } else {
            String h = s.substring(0, 1);
            String t = s.substring(1);
            subSets3(h, t);
        }
    }

    @SuppressWarnings("unused")
    private static void subSets(String a) {
        if (a == null || a.isEmpty()) {
            return;
        }
        System.out.println(a);
        for (int i = 0; i < a.length(); i++) {
            String next = a.substring(0, i) + a.substring(i + 1);
            subSets(next);
        }
    }
    
    @SuppressWarnings("unused")
    private static void subSets2(String p, String a) {
        if (a.isEmpty()) {
            System.out.println(p);
        } else {
            for (int  i = 0; i < a.length(); i++) {
                char ch = a.charAt(i);
                String s = p + ch;
                String next = a.substring(0, i) + a.substring(i + 1);
                System.out.println(p + s);
            }
        }
    }
}
