package ru.dendevjv.dsalgjavamg.ch05recursion.examples;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class Cf0511PuzzleSolve {
    private static class QueueSet<T> extends LinkedHashSet<T> {
        private static final long serialVersionUID = 7965261432562813003L;

        public boolean offer(T element) {
            return super.add(element);
        }
        
        public T poll() {
            Iterator<T> it = iterator();
            if (it.hasNext()) {
                T first = it.next();
                it.remove();
                return first;
            } else {
                return null;
            }
        }
    }

    public static void main(String[] args) {
        QueueSet<Character> qs = new QueueSet<>();
        qs.offer('a');
        qs.offer('b');
        qs.offer('c');
        qs.offer('e');
        
        puzzleSolve(3, "", qs);
    }


    private static void puzzleSolve(int k, String s, QueueSet<Character> u) {
        for (int i = 0; i < u.size(); i++) {
            // Remove e from u
            Character element = u.poll();
            
            // Add e to the end of s
            s = s + element;
            
            if (k == 1) {
                // Test whether s is a configuration that solves the puzzle
                // if s solves the puzzle then add s to output
                System.out.println(s);
            } else {
                puzzleSolve(k - 1, s, u);
            }
            
            // Remove e from the end of s
            s = s.substring(0, s.length() - 1);
            
            // Add e back to U
            u.offer(element);
        }
    }
    
}
