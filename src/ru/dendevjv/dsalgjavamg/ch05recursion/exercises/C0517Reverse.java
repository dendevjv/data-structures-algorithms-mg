package ru.dendevjv.dsalgjavamg.ch05recursion.exercises;

import java.util.Scanner;

public class C0517Reverse {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("> ");
        String s = sc.nextLine();
        sc.close();
        s = reverse(s);
        System.out.println(s);
    }

    private static String reverse(String s) {
        if (s.length() < 2) {
            return s;
        } else {
            int last = s.length() - 1;
            return s.substring(last) + reverse(s.substring(0, last));
        }
    }

}
