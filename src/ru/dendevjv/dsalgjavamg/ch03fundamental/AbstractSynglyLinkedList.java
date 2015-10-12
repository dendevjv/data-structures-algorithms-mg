package ru.dendevjv.dsalgjavamg.ch03fundamental;

import java.util.Iterator;

public abstract class AbstractSynglyLinkedList <E> extends  AbstractLinkedList <E> implements Iterable<E> {
    /**
     * Nested node class.
     */
    protected static class Node <E> {
        private E element;
        private Node <E> next;
        
        public Node(E element) {
            this.element = element;
        }
        
        public Node(E element, Node<E> node) {
            this.element = element;
            next = node;
        }
        
        public E getElement() { return element; }
        
        public Node<E> getNext() { return next; }
        
        public void setNext(Node<E> node) { next = node; }
    }
    
    private class SynglyLinkedListIterator<T extends E> implements Iterator<E> {
        private Node<T> current;
        
        SynglyLinkedListIterator(Node<T> currentNode) {
            current = currentNode;
        }

        @Override
        public boolean hasNext() {
            return current != null;
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
    
    protected Iterator<E> createIterator(Node<E> firstNode) {
        return new SynglyLinkedListIterator<E>(firstNode);
    }
    
    @Override
    public abstract Iterator<E> iterator();
    
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

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        @SuppressWarnings("unchecked")
        AbstractSynglyLinkedList <E> other = (AbstractSynglyLinkedList <E>)obj;
        if (getSize() != other.getSize()) return false;
        
        Iterator<E> it1 = iterator();
        Iterator<E> it2 = other.iterator();
        int length = getSize();
        E e1, e2;
        for (int i = 0; i < length; i++) {
            e1 = it1.next();
            e2 = it2.next();
            if (e1 != null) {
                if (!e1.equals(e2)) {
                    return false;
                }
            } else {
                if (e2 != null) {
                    return false;
                }
            }
        }
        return true;
    }
    
}
