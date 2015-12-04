/* Code Fragment 6.4: Implementation of a Stack using a SinglyLinkedList as storage. */
package ru.dendevjv.dsalgjavamg.ch06stacks.examples;

import ru.dendevjv.dsalgjavamg.ch03fundamental.p2singlylinked.SinglyLinkedList;

/**
 * Implementation of a {@link Stack} using a SinglyLinkeList as storage.
 */
public class Cf0604LinkedStack<E> implements Stack<E> {
    private SinglyLinkedList<E> list = new SinglyLinkedList<>();

    @Override
    public int size() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(E element) {
        list.addFirst(element);
    }

    @Override
    public E top() {
        return list.first();
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
