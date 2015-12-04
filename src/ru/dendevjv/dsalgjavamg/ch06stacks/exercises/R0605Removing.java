/*
    R-6.5 
    Give a recursive method for removing all the elements from a stack.
 */
package ru.dendevjv.dsalgjavamg.ch06stacks.exercises;

import ru.dendevjv.dsalgjavamg.ch06stacks.examples.Cf0604LinkedStack;
import ru.dendevjv.dsalgjavamg.ch06stacks.examples.Stack;

public class R0605Removing {

    public static void main(String[] args) {
        Stack<Integer> s = new Cf0604LinkedStack<>();
        s.push(1);
        s.push(2);
        System.out.println(s);
        s.push(3);
        System.out.println(s);
        
        remove(s);
        System.out.println(s);
    }

    private static void remove(Stack<Integer> s) {
        if (!s.isEmpty()) {
            System.out.println("removed: " + s.pop());
            remove(s);
        }
    }

}
