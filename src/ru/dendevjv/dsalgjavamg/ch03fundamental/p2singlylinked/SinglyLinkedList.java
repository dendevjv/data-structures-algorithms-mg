package ru.dendevjv.dsalgjavamg.ch03fundamental.p2singlylinked;

import java.util.Iterator;

import ru.dendevjv.dsalgjavamg.ch03fundamental.AbstractSynglyLinkedList;

public class SinglyLinkedList <E> extends AbstractSynglyLinkedList <E> 
        implements Cloneable {
    
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
    
    /**
     * Creates a list containing all elements of the this list followed by all elements
     * of the second list.
     * @param b second list
     * @return resulting list
     */
    public SinglyLinkedList<E> concatenate(SinglyLinkedList<E> b) {
        SinglyLinkedList<E> r = new SinglyLinkedList<>();
        Iterator<E> it1 = iterator();
        while (it1.hasNext()) {
            r.addLast(it1.next());
        }
        Iterator<E> it2 = b.iterator();
        while (it2.hasNext()) {
            r.addLast(it2.next());
        }
        return r;
    }
    
    @Override
    public Iterator<E> iterator() {
        return createIterator(head);
    }
    
    /**
     * Makes shallow copy of the list.
     */
    @SuppressWarnings("unchecked")
    @Override
    public Object clone() {
        SinglyLinkedList <E> other = null;
        try {
            other = (SinglyLinkedList <E>) super.clone();
            if (getSize() > 0) {
                Node<E> next1, next2, node1 = head;
                Node<E> node2 = new Node<>(node1.getElement());
                other.head = node2;
                while (node1.getNext() != null) {
                    next1 = node1.getNext();
                    next2 = new Node<>(next1.getElement());
                    node2.setNext(next2);
                    
                    node1 = next1;
                    node2 = next2;
                }
                other.tail = node2;
            }
        } catch (CloneNotSupportedException e) {
        }
        return other;
    }
}
