/*
    R-6.10 
    Give a simple adapter that implements the stack ADT while using an instance of
    a deque for storage.
 */
package ru.dendevjv.dsalgjavamg.ch06stacks.exercises;

import ru.dendevjv.dsalgjavamg.ch06stacks.examples.Deque;
import ru.dendevjv.dsalgjavamg.ch06stacks.examples.DoublyLinkedListDeque;
import ru.dendevjv.dsalgjavamg.ch06stacks.examples.Stack;

public class R0610StackUsingDeque<E> implements Stack<E> {
    private Deque<E> deque = new DoublyLinkedListDeque<>();

    public static void main(String[] args) {
        Stack<Integer> st = new R0610StackUsingDeque<>(); 
        st.push(1);
        st.push(2);
        st.push(3);
        System.out.println(st);
        
        System.out.println("poped: " + st.pop());
        System.out.println(st);
        System.out.println("poped: " + st.pop());
        System.out.println(st);
        System.out.println("poped: " + st.pop());
        System.out.println(st);
    }
    
    @Override
    public String toString() {
        return deque.toString();
    }

    @Override
    public int size() {
        return deque.size();
    }

    @Override
    public boolean isEmpty() {
        return deque.isEmpty();
    }

    @Override
    public void push(E e) {
        deque.addFirst(e);
    }

    @Override
    public E top() {
        return deque.first();
    }

    @Override
    public E pop() {
        return deque.removeFirst();
    }

}
