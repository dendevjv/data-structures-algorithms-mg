package ru.dendevjv.dsalgjavamg.ch05recursion.exercises;

import java.util.Scanner;

public class R0508StringToInteger {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("String of digits: ");
        String s = sc.nextLine();
        sc.close();
        int n = stringToInteger(s);
        System.out.printf("%s converted to integer %d%n", s, n);
    }

    private static int stringToInteger(String s) {
        if (s.length() == 1) {
            return s.charAt(0) - '0';
        } else {
            char lastChar = s.charAt(s.length() - 1);
            int last = lastChar - '0';
            String head = s.substring(0, s.length() - 1);
            return stringToInteger(head) * 10 + last;
        }
    }

}
