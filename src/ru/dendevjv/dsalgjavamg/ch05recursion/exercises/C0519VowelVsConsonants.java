package ru.dendevjv.dsalgjavamg.ch05recursion.exercises;

import java.util.Scanner;

public class C0519VowelVsConsonants {
    private static final String CONSONANTS = "bcdfghjklmnpqrstvwxyz" + "bcdfghjklmnpqrstvwxyz".toUpperCase();
    private static final String VOWELS = "aeiou" + "aeiou".toUpperCase();
    
    private static class Data {
        int vowels = 0;
        int consonants = 0;
        
        boolean moreVowels() { return vowels > consonants; }
        
        @Override
        public String toString() {
            return "[" + vowels + " vowels, " + consonants + " consonants]";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("> ");
        String s = sc.nextLine();
        sc.close();
        boolean r = hasMoreVowels(s);
        System.out.println(s + (r ? " has more vowels" : " has not more vowels"));
    }
    
    private static boolean hasMoreVowels(String s) {
        Data data = new Data();
        data = countVowelsAndConsonants(s, data);
        System.out.println(data);
        return data.moreVowels();
    }
    
    private static Data countVowelsAndConsonants(String s, Data data) {
        if (s != null && !s.isEmpty()) {
            char ch = s.charAt(0);
            if (isVowel(ch)) {
                data.vowels++;
            } else if (isConsonant(ch)) {
                data.consonants++;
            }
            countVowelsAndConsonants(s.substring(1), data);
        }
        return data;
    }

    private static boolean isConsonant(char ch) {
        return CONSONANTS.indexOf(ch) > -1;
    }
    
    private static boolean isVowel(char ch) {
        return VOWELS.indexOf(ch) > -1;
    }
}
