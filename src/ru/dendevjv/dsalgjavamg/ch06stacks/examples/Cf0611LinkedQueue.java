package ru.dendevjv.dsalgjavamg.ch06stacks.examples;

import ru.dendevjv.dsalgjavamg.ch03fundamental.p2singlylinked.SinglyLinkedList;

/**
 * Implementation of a {@link Queue} using a linked list.
 *
 * @param <E>
 */
public class Cf0611LinkedQueue <E> implements Queue<E> {
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
    public void enqueue(E e) {
        list.addLast(e);
    }

    @Override
    public E first() {
        return list.first();
    }

    @Override
    public E dequeue() {
        return list.removeFirst();
    }

    public static void main(String[] args) {
        Queue<Integer> q = new Cf0611LinkedQueue<>();
        q.enqueue(1);
        q.enqueue(3);
        q.enqueue(5);
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        q.enqueue(7);
        q.enqueue(8);
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
    }
}
