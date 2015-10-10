package ru.dendevjv.dsalgjavamg.ch03fundamental.p2singlylinked;

import java.util.Iterator;

import ru.dendevjv.dsalgjavamg.ch03fundamental.AbstractSynglyLinkedList;

public class SinglyLinkedList <E> extends AbstractSynglyLinkedList <E> {
    
    private Node <E> head = null;
    private Node <E> tail = null;
    
    public SinglyLinkedList() {}
    
    @Override
    public E first() {
        if (isEmpty()) {
            return null;
        }
        return head.getElement();
    }
    
    @Override
    public E last() {
        if (isEmpty()) {
            return null;
        }
        return tail.getElement();
    }
    
    @Override
    public void addFirst(E e) {
        Node<E> node = new Node<E>(e, head);
        head = node;
        if (size == 0) {
            tail = head;
        }
        size++;
    }
    
    @Override
    public void addLast(E e) {
        Node<E> node = new Node<E>(e);
        if (isEmpty()) {
            head = node;
        } else {
            tail.setNext(node);
        }
        tail = node;
        size++;
    }
    
    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        E answer = head.getElement();
        head = head.getNext();
        size--;
        if (size == 0) {
            tail = null;
        }
        return answer;
    }
    
    @Override
    public Iterator<E> iterator() {
        return createIterator(head);
    }
}
