package ru.dendevjv.dsalgjavamg.ch02.projects.p0230;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class P0230AlphabetFrequency {

    public static void main(String[] args) {
        String fileName = "D:/Lit/big_texts/alice30.txt";
        String text = readFile(fileName);
        
        if (text != null) {
            System.out.println("Analysing file " + fileName + ":");
            Map<Character, Long> charCount = countCharacters(text );
            System.out.println("Number of characters = " + charCount.size());
            TreeMap<Character, Double> frequencies = calculateFrequencies(charCount);
//            printMap(frequencies);
            printBarChar(frequencies);
        }
    }
    
    @SuppressWarnings("unused") // used for testing
    private static void printMap(Map<Character, Double> map) {
        double total = 0, value;
        for (Entry<Character, Double> e : map.entrySet()) {
            value = e.getValue().doubleValue();
            System.out.printf("%s : %.15f%n", e.getKey().toString(), value);
            total += value;
        }
        System.out.printf("Total: %.15f%n", total);
    }
    
    private static String readFile(String fileName) {
        StringBuilder sb = new StringBuilder();
        try (Scanner sc = new Scanner(new File(fileName))) {
            while (sc.hasNextLine()) {
                sb.append(sc.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.err.println("File \"" + fileName + "\" not found");
            return null;
        }
        return sb.toString();
    }

    static void printBarChar(TreeMap<Character, Double> frequencies) {
        int maxNumRows = 100;
        Character[] characters = new Character[frequencies.size()];
        characters = frequencies.keySet().toArray(characters);
        int[] values = new int[characters.length];
        for (int i = 0; i < values.length; i++) {
            values[i] = (int) Math.ceil(frequencies.get(characters[i]) * maxNumRows);
        }
        
        int row = findNonEmptyRow(values, maxNumRows);
        while (row > 0) {
            for (int col = 0; col < values.length; col++) {
                if (values[col] < row) {
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }
            row--;
            System.out.println();
        }
        for (int i = 0; i < values.length; i++) System.out.print("-");
        System.out.println();
        for (int i = 0; i < values.length; i++) System.out.print(characters[i]);
        System.out.println();
    }
    
    private static int findNonEmptyRow(int[] values, int maxNumRows) {
        int row = maxNumRows + 1;
        boolean foundNonEmtpy  = false;
        while (!foundNonEmtpy && row > 0) {
            row--;
            for (int i = 0; i < values.length; i++) {
                if (values[i] >= row) {
                    foundNonEmtpy = true;
                    break;
                }
            }
        }
        return row;
    }

    private static TreeMap<Character, Double> calculateFrequencies(Map<Character, Long> charCount) {
        TreeMap<Character, Double> charFreq = new TreeMap<>();
        double total = 0;
        for (long count : charCount.values()) {
            total += count;
        }
        for (Entry<Character, Long> e : charCount.entrySet()) {
            charFreq.put(e.getKey(), e.getValue() / total);
        }
        return charFreq;
    }

    /**
     * Counts all characters (lowercased) in specified text.
     */
    private static Map<Character, Long> countCharacters(String text) {
        Map<Character, Long> charCount = new HashMap<>();
        Character key;
        Long longObj;
        char ch;
        for (int i = 0; i < text.length(); i++) {
            ch = text.charAt(i);
            if (!Character.isLetter(ch)) {
                continue;
            }
            ch = Character.toLowerCase(ch);
            key = Character.valueOf(ch);
            longObj = charCount.get(key);
            if (longObj == null) {
                charCount.put(key, Long.valueOf(1L));
            } else {
                charCount.put(key, longObj + 1);
            }
        }
        return charCount;
    }
}
