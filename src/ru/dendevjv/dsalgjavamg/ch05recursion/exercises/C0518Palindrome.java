/*
    C-5.18 
    Write a short recursive Java method that determines if a string s is a palindrome,
    that is, it is equal to its reverse. Examples of palindromes include ' racecar'
    and ' gohangasalamiimalasagnahog' .
 */
package ru.dendevjv.dsalgjavamg.ch05recursion.exercises;

import java.util.Scanner;

public class C0518Palindrome {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("> ");
        String s = sc.nextLine();
        sc.close();
        boolean r = isPalindrome(s);
        System.out.println(r ? "is palindrome" : "is NOT palindrome");
    }

    private static boolean isPalindrome(String s) {
        if (s.length() < 2) {
            return true;
        }
        int last = s.length() - 1;
        if (s.charAt(0) != s.charAt(last)) {
            return false;
        }
        return isPalindrome(s.substring(1, last));
    }

}
