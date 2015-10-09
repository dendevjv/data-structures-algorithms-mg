package ru.dendevjv.dsalgjavamg.ch03fundamental.p3circularly;

public class CircularlyLinkedList <E> {
    
    /**
     * Nested node class.
     */
    private static class Node <E> {
        private E element;
        private Node <E> next;
        
        private Node(E element) {
            this.element = element;
        }
        
        private E getElement() { return element; }
        
        private Node<E> getNext() { return next; }
        
        private void setNext(Node<E> node) { next = node; }
    }
    
    private Node <E> tail = null;
    private int size = 0;
    
    public CircularlyLinkedList() {}

    public int getSize() { return size; }
    
    public boolean isEmpty() { return size == 0; }
    
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
}
