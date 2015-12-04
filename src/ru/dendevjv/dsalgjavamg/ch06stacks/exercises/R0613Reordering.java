/*
    R-6.13 
    Suppose you have a deque D containing the numbers (1, 2, 3, 4, 5, 6, 7, 8), in this
    order. Suppose further that you have an initially empty queue Q. Give a code
    fragment that uses only D and Q (and no other variables) and results in D storing
    the elements in the order (1, 2, 3, 5, 4, 6, 7, 8).
 */
package ru.dendevjv.dsalgjavamg.ch06stacks.exercises;

import ru.dendevjv.dsalgjavamg.ch06stacks.examples.Deque;
import ru.dendevjv.dsalgjavamg.ch06stacks.examples.DoublyLinkedListDeque;

public class R0613Reordering {

    public static void main(String[] args) {
        Deque<Integer> d = new DoublyLinkedListDeque<>();
        for (int i = 1; i <= 8; i++) {
            d.addLast(i);
        }
        System.out.println("D: " + d);
        
        Deque<Integer> q = new DoublyLinkedListDeque<>();
        
        q.addFirst(d.removeLast());
        q.addFirst(d.removeLast());
        q.addFirst(d.removeLast()); 
        q.addFirst(d.removeLast()); // Q: 5 6 7 8
        q.addLast(d.removeLast());  // Q: 5 6 7 8 4
        
        d.addLast(q.removeFirst()); // Q: 6 7 8 4
        d.addLast(q.removeLast());  // Q: 6 7 8
        d.addLast(q.removeFirst());
        d.addLast(q.removeFirst());
        d.addLast(q.removeFirst());

        System.out.println("D: " + d);  // D: 1 2 3 5 4 6 7 8
    }

}
