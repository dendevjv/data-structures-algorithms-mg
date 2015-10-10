package ru.dendevjv.dsalgjavamg.ch03fundamental.p3circularly;

import java.util.Iterator;

import ru.dendevjv.dsalgjavamg.ch03fundamental.AbstractSynglyLinkedList;

public class CircularlyLinkedList <E> extends AbstractSynglyLinkedList <E> {
    
    private Node <E> tail = null;
    
    public CircularlyLinkedList() {}

    public E first() {
        if (isEmpty()) {
            return null;
        }
        return tail.getNext().getElement();
    }
    
    public E last() {
        if (isEmpty()) {
            return null;
        }
        return tail.getElement();
    }
    
    /**
     * Rotates the first element to the back of the list.
     */
    public void rotate() {
        if (tail != null) {
            tail = tail.getNext();
        }
    }
    
    public void addFirst(E e) {
        Node<E> node = new Node<>(e);
        if (isEmpty()) {
            tail = node;
        } else {
            node.setNext(tail.getNext());
        }
        tail.setNext(node);
        size++;
    }
    
    public void addLast(E e) {
        Node<E> node = new Node<>(e);
        if (isEmpty()) {
            tail = node;
            tail.setNext(node);
        } else {
            node.setNext(tail.getNext());
            tail.setNext(node);
            tail = node;
        }
        size++;
    }
    
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Node<E> first = tail.getNext();
        E answer = first.getElement();
        tail.setNext(first.getNext());
        size--;
        return answer;
    }

    @Override
    public Iterator<E> iterator() {
        return createIterator(tail.getNext());
    }
}
