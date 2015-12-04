package ru.dendevjv.dsalgjavamg.ch06stacks.examples;

import ru.dendevjv.dsalgjavamg.ch03fundamental.p4doublylinked.DoublyLinkedList;

public class DoublyLinkedListDeque <E> implements Deque<E> {
    private DoublyLinkedList<E> list = new DoublyLinkedList<>();

    @Override
    public int size() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public E first() {
        return list.first();
    }

    @Override
    public E last() {
        return list.last();
    }

    @Override
    public void addFirst(E e) {
        list.addFirst(e);
    }

    @Override
    public void addLast(E e) {
        list.addLast(e);
    }

    @Override
    public E removeFirst() {
        return list.removeFirst();
    }

    @Override
    public E removeLast() {
        return list.removeLast();
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
