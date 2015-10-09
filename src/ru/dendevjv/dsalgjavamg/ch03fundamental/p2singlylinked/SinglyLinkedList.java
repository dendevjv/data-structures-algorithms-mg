package ru.dendevjv.dsalgjavamg.ch03fundamental.p2singlylinked;

public class SinglyLinkedList <E> {
    
    /**
     * Nested node class.
     */
    private static class Node <E> {
        private E element;
        private Node <E> next;
        
        Node(E element) {
            this.element = element;
        }
        
        Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
        
        private E getElement() { return element; }
        
        private Node<E> getNext() { return next; }
        
        private void setNext(Node<E> node) { next = node; }
    }
    
    private Node <E> head = null;
    private Node <E> tail = null;
    private int size = 0;
    
    SinglyLinkedList() {}
    
    public int getSize() { return size; }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public E first() {
        if (isEmpty()) {
            return null;
        }
        return head.getElement();
    }
    
    public E last() {
        if (isEmpty()) {
            return null;
        }
        return tail.getElement();
    }
    
    public void addFirst(E e) {
        Node<E> node = new Node<E>(e, head);
        head = node;
        if (size == 0) {
            tail = head;
        }
        size++;
    }
    
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
}
