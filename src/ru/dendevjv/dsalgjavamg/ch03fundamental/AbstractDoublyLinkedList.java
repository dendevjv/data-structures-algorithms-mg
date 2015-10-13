package ru.dendevjv.dsalgjavamg.ch03fundamental;

import java.util.Iterator;
import java.util.Objects;

public abstract class AbstractDoublyLinkedList <E> extends AbstractLinkedList <E>
        implements Iterable<E> {
    /**
     * Nested node class.
     */
    protected static class Node <E> {
        private E element;
        private Node <E> previous;
        private Node <E> next;
        
        public Node(E element) {
            this.element = element;
        }
        
        public Node(E element, Node<E> nextNode, Node<E> prevNode) {
            this.element = element;
            previous = prevNode;
            next = nextNode;
        }
        
        public E getElement() { return element; }
        
        public Node<E> getNext() { return next; }
        
        public Node<E> getPrev() { return previous; }
        
        public void setNext(Node<E> node) { next = node; }
        
        public void setPrev(Node<E> node) { previous = node; }
    }
    
    protected class DoubleyLinkedListIterator<T extends E> implements Iterator<E> {
        private Node<T> current;
        
        public DoubleyLinkedListIterator(Node<T> currentNode) {
            current = currentNode;
        }

        @Override
        public boolean hasNext() {
            return current != null && current.getNext() != null;
        }

        @Override
        public E next() {
            E element = current.getElement();
            current = current.getNext();
            return element;
        }

        @Override
        public void remove() {
            // does nothing
        }
        
    }
    
    public abstract E removeLast();
    
    @Override
    public abstract Iterator<E> iterator();
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        @SuppressWarnings("unchecked")
        AbstractDoublyLinkedList <E> other = (AbstractDoublyLinkedList <E>) obj;
        if (getSize() != other.getSize()) {
            return false;
        }
        Iterator<E> i1 = iterator();
        Iterator<E> i2 = other.iterator();
        for (int i = 0; i < size; i++) {
            if (!i1.hasNext() || !i2.hasNext()) {
                return false;
            }
            if (!Objects.equals(i1.next(), i2.next())) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        Iterator<E> it = iterator();
        if (it.hasNext()) {
            sb.append(it.next());
        }
        while (it.hasNext()) {
            sb.append(", ");
            sb.append(it.next());
        }
        sb.append(']');
        return sb.toString();
    }
}
