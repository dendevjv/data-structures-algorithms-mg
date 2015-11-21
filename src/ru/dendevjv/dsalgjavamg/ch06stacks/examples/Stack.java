package ru.dendevjv.dsalgjavamg.ch06stacks.examples;

/**
 * A collection of objects that are inserted and removed according to the last-in
 * first-out principle.<br/>
 * Although similar in purpose, this interface differs from {@link java.util.Stack}.
 */
public interface Stack<E> {
    int size();

    boolean isEmpty();

    void push(E e);

    E top();

    E pop();
}
