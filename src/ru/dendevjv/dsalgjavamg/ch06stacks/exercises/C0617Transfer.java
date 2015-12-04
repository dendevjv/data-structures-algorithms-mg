/*
    C-6.17 
    Show how to use the transfer method, described in Exercise R-6.4, and two temporary stacks, 
    to replace the contents of a given stack S with those same elements,
    but in reversed order.
 */
package ru.dendevjv.dsalgjavamg.ch06stacks.exercises;

import ru.dendevjv.dsalgjavamg.ch06stacks.examples.ArrayStack;
import ru.dendevjv.dsalgjavamg.ch06stacks.examples.Stack;

public class C0617Transfer {

    public static void main(String[] args) {
        Stack<Integer> st = new ArrayStack<>(3);
        st.push(1);
        st.push(2);
        st.push(3);
        System.out.println(st);
        
        reverse(st);
        System.out.println(st);
    }

    private static void reverse(Stack<Integer> st) {
        Stack<Integer> a = new ArrayStack<>(st.size());
        Stack<Integer> b = new ArrayStack<>(st.size());
        while (!st.isEmpty()) {
            a.push(st.pop());
        }
        while (!a.isEmpty()) {
            b.push(a.pop());
        }
        while (!b.isEmpty()) {
            st.push(b.pop());
        }
    }

}
