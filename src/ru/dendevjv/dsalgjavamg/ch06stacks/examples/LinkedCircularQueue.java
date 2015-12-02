package ru.dendevjv.dsalgjavamg.ch06stacks.examples;

import ru.dendevjv.dsalgjavamg.ch03fundamental.p3circularly.CircularlyLinkedList;

public class LinkedCircularQueue<E> implements CircularQueue<E> {
    private CircularlyLinkedList<E> list = new CircularlyLinkedList<>();

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
        if (list.isEmpty()) {
            return null;
        }
        return list.first();
    }

    @Override
    public E dequeue() {
        if (list.isEmpty()) {
            return null;
        }
        return list.removeFirst();
    }

    @Override
    public void rotate() {
        if (!list.isEmpty()) {
            list.rotate();
        }
    }
    
    @Override
    public String toString() {
        return list.toString();
    }

    public static void main(String[] args) {
        LinkedCircularQueue<Integer> q = new LinkedCircularQueue<>();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        System.out.println(q);
        q.rotate();
        System.out.println(q);
        q.rotate();
        System.out.println(q);
        q.rotate();
        System.out.println(q);
        System.out.println(q.dequeue());
        System.out.println(q);
        q.enqueue(4);
        System.out.println(q);
        
    }    

}
