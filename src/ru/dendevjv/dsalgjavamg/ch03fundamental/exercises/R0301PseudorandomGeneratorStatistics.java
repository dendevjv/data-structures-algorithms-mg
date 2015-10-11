package ru.dendevjv.dsalgjavamg.ch03fundamental.exercises;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class R0301PseudorandomGeneratorStatistics {
    private static class Statistics {
        Map<Integer, Integer> stats = new TreeMap<>();
        
        void add(int n) {
            Integer key = Integer.valueOf(n);
            Integer count = stats.get(key);
            if (count != null) {
                count = count + 1;
                stats.put(key, count);
            } else {
                stats.put(key, Integer.valueOf(1));
            }
        }
        
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            String nl = System.lineSeparator();
            for (Entry<Integer, Integer> e : stats.entrySet()) {
                sb.append(e.getKey());
                sb.append(" : ");
                sb.append(e.getValue());
                sb.append(nl);
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter seed: ");
        int seed = sc.nextInt();
        sc.close();
        
        Statistics statistics = new Statistics();
        R0301PseudorandomGenerator gen = new R0301PseudorandomGenerator(seed);
        int repeat = 1000;
        for (int i = 0; i < repeat; i++) {
            int r = gen.next();
            statistics.add(r);
        }

        System.out.println("Statistics:");
        System.out.println(statistics);
    }

}
