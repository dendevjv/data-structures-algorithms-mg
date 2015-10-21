/*
    C-3.32 
    Implement a circular version of a doubly linked list, without any sentinels, that
    supports all the public behaviors of the original as well as two new update methods, 
    rotate() and rotateBackward().
 */
package ru.dendevjv.dsalgjavamg.ch03fundamental.exercises.c0332;

import java.util.Iterator;
import java.util.ListIterator;

import ru.dendevjv.dsalgjavamg.ch03fundamental.AbstractDoublyLinkedList;

public class C0332CircularyDoubleLinkedList <E> extends AbstractDoublyLinkedList <E>  {
    protected class CircularyDoubleyLinkedListListIterator<T extends E> implements ListIterator<E> {
        private Node<T> current;
        
        public CircularyDoubleyLinkedListListIterator(Node<T> firstNode) {
            current = firstNode;
        }

        @Override
        public boolean hasNext() {
            return current != null && current.getElement() != null;
        }

        @Override
        public E next() {
            E element = current.getElement();
            current = current.getNext();
            return element;
        }

        @Override
        public boolean hasPrevious() {
            Node<T> prev = current.getPrev();
            return prev != null && prev.getElement() != null;
        }

        @Override
        public E previous() {
            Node<T> prev = current.getPrev();
            E element = prev.getElement();
            current = prev;
            return element;
        }

        @Override
        public int nextIndex() {
            throw new UnsupportedOperationException("This method is not implemented yet");
        }

        @Override
        public int previousIndex() {
            throw new UnsupportedOperationException("This method is not implemented yet");
        }

        @Override
        public void remove() {
            @SuppressWarnings("unchecked")
            Node<E> nodeToRemove = (Node<E>) current.getPrev();
            C0332CircularyDoubleLinkedList.this.remove(nodeToRemove);
        }

        @Override
        public void set(E e) {
            @SuppressWarnings("unchecked")
            Node<E> prev = (Node<E>) current.getPrev();
            prev.setElement(e);
        }

        @Override
        public void add(E e) {
            throw new UnsupportedOperationException("This method is not implemented yet");
        }
        
    }
    
    private Node<E> cursor;
    
    public C0332CircularyDoubleLinkedList() {
        cursor = null;
        size = 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new DoubleyLinkedListIterator<E>(cursor);
    }

    @Override
    public ListIterator<E> listIterator() {
        return new CircularyDoubleyLinkedListListIterator<E>(cursor);
    }

    @Override
    public E first() {
        if (isEmpty()) return null;
        return cursor.getElement();
    }

    @Override
    public E last() {
        if (isEmpty()) return null;
        return cursor.getPrev().getElement();
    }

    @Override
    public void addFirst(E e) {
        Node<E> node;
        if (isEmpty()) {
            node = new Node<>(e);
            node.setNext(node);
            node.setPrev(node);
            size++;
        } else {
            node = addBetween(e, cursor.getPrev(), cursor);
        }
        cursor = node;
    }

    @Override
    public void addLast(E e) {
        Node<E> node;
        if (isEmpty()) {
            node = new Node<>(e);
            node.setNext(node);
            node.setPrev(node);
            size++;
            cursor = node;
        } else {
            node = addBetween(e, cursor.getPrev(), cursor);
        }
    }

    @Override
    public E removeFirst() {
        E element = remove(cursor);
        return element;
    }

    @Override
    public E removeLast() {
        return remove(cursor.getPrev());
    }

    public void rotate() {
        if (!isEmpty()) {
            cursor = cursor.getNext();
        }
    }
    
    public void rotateBackward() {
        if (!isEmpty()) {
            cursor = cursor.getPrev();
        }
    }
    
    private Node<E> addBetween(E e, Node<E> predecessor, Node<E> successor) {
        Node<E> node = new Node<>(e, successor, predecessor);
        successor.setPrev(node);
        predecessor.setNext(node);
        size++;
        return node;
    }
    
    private E remove(Node<E> node) {
        Node<E> newCursor = null;
        if (node == cursor) {
            newCursor = cursor.getNext();
        }
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        if (newCursor != null) {
            if (size > 0) {
                cursor = newCursor;
            } else {
                cursor = null;
            }
        }
        return node.getElement();
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        Iterator<E> it = iterator();
        if (it.hasNext()) {
            sb.append(it.next());
        }
        for (int i = 1; i < size && it.hasNext(); i++) {
            sb.append(", ");
            sb.append(it.next());
        }
        sb.append(']');
        return sb.toString();
    }
}
