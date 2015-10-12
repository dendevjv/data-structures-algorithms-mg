/*
    R-3.12 
    Implement a rotate() method in the SinglyLinkedList class, which has semantics
    equal to addLast(removeFirst()), yet without creating any new node.
 */
package ru.dendevjv.dsalgjavamg.ch03fundamental.exercises;

import java.util.Iterator;

import ru.dendevjv.dsalgjavamg.ch03fundamental.AbstractSynglyLinkedList;

public class R0312SynglyLinkedList<E> extends AbstractSynglyLinkedList<E> implements Cloneable {

    private Node<E> head = null;
    private Node<E> tail = null;

    public R0312SynglyLinkedList() {
    }

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

    /**
     * Makes shallow copy of the list.
     */
    @SuppressWarnings("unchecked")
    @Override
    public Object clone() {
        R0312SynglyLinkedList<E> other = null;
        try {
            other = (R0312SynglyLinkedList<E>) super.clone();
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
    
    public void rotate() {
        Node<E> node = head;
        head = node.getNext();
        node.setNext(null);
        tail.setNext(node);
        tail = node;
    }
    
    public static void main(String[] args) {
        R0312SynglyLinkedList<String> list = new R0312SynglyLinkedList<>();
        list.addLast("one");
        list.addLast("two");
        list.addLast("three");
        
        System.out.println(list);
        
        list.rotate();
        System.out.println(list);
    }
}
