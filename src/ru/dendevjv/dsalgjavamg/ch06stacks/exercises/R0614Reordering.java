/*
    R-6.14 
    Repeat the previous problem using the deque D and an initially empty stack S.
 */
package ru.dendevjv.dsalgjavamg.ch06stacks.exercises;

import ru.dendevjv.dsalgjavamg.ch06stacks.examples.Cf0604LinkedStack;
import ru.dendevjv.dsalgjavamg.ch06stacks.examples.Deque;
import ru.dendevjv.dsalgjavamg.ch06stacks.examples.DoublyLinkedListDeque;
import ru.dendevjv.dsalgjavamg.ch06stacks.examples.Stack;

public class R0614Reordering {

    public static void main(String[] args) {
        Deque<Integer> d = new DoublyLinkedListDeque<>();
        for (int i = 1; i <= 8; i++) {
            d.addLast(i);
        }
        System.out.println("D: " + d);
        
        Stack<Integer> s = new Cf0604LinkedStack<>();
        
        d.addFirst(d.removeLast());
        d.addFirst(d.removeLast());
        d.addFirst(d.removeLast());
        d.addFirst(d.removeLast());
        
        s.push(d.removeLast()); // S: 4
        
        d.addLast(d.removeFirst());
        d.addLast(s.pop());
        d.addLast(d.removeFirst());
        d.addLast(d.removeFirst());
        d.addLast(d.removeFirst());
        
        System.out.println("D: " + d);
    }

}
