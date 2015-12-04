/*
    R-6.4 
    Implement a method with signature transfer(S, T) that transfers all elements
    from stack S onto stack T, so that the element that starts at the top of S is the first
    to be inserted onto T, and the element at the bottom of S ends up at the top of T.
 */
package ru.dendevjv.dsalgjavamg.ch06stacks.exercises;

import ru.dendevjv.dsalgjavamg.ch06stacks.examples.ArrayStack;
import ru.dendevjv.dsalgjavamg.ch06stacks.examples.Stack;

public class R0604Transfer {
    private static void transfer(Stack<Integer> source, Stack<Integer> dest) {
        while (!source.isEmpty()) {
            dest.push(source.pop());
        }
    }

    public static void main(String[] args) {
        int capacity = 3;
        Stack<Integer> s = new ArrayStack<>(capacity);
        s.push(1);
        s.push(2);
        s.push(3);
        Stack<Integer> d = new ArrayStack<>(capacity);
        transfer(s, d);
        System.out.println(d.toString());
    }

}
