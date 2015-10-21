package ru.dendevjv.dsalgjavamg.ch03fundamental.exercises.c0331onesentinel;

import java.util.Iterator;
import java.util.ListIterator;

import ru.dendevjv.dsalgjavamg.ch03fundamental.AbstractDoublyLinkedList;

public class C0331DoublyLinkedList <E> extends AbstractDoublyLinkedList <E> {

    private Node<E> sentinel;
  
    public C0331DoublyLinkedList() {
        sentinel = new Node<E>(null);
        sentinel.setNext(sentinel);
        sentinel.setPrev(sentinel);
    }

    @Override
    public E first() {
        if (isEmpty()) return null;
        return sentinel.getNext().getElement();
    }

    @Override
    public E last() {
        if (isEmpty()) return null;
        return sentinel.getPrev().getElement();
    }

    @Override
    public void addFirst(E e) {
        addBetween(e, sentinel, sentinel.getNext());
    }

    @Override
    public void addLast(E e) {
        addBetween(e, sentinel.getPrev(), sentinel);
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) return null;
        return remove(sentinel.getNext());
    }
 
    @Override
    public E removeLast() {
        if (isEmpty()) return null;
        return remove(sentinel.getPrev());
    }
    
    private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
        Node<E> node = new Node<>(e, successor, predecessor);
        successor.setPrev(node);
        predecessor.setNext(node);
        size++;
    }
    
    private E remove(Node<E> node) {
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return node.getElement();
    }

    @Override
    public Iterator<E> iterator() {
        return new DoubleyLinkedListIterator<E>(sentinel.getNext());
    }

    @Override
    public ListIterator<E> listIterator() {
        return new DoubleyLinkedListListIterator<E>(sentinel.getNext());
    }
    
    public C0331DoublyLinkedList<E> concatenate(C0331DoublyLinkedList<E> b) {
        C0331DoublyLinkedList<E> r = new C0331DoublyLinkedList<>();
        Node<E> node = sentinel;
        while (node.getNext() != null) {
            node = node.getNext();
            if (node.getElement() != null) {
                r.addBetween(node.getElement(), r.sentinel.getPrev(), r.sentinel);
            } else {
                break;
            }
        }
        node = b.sentinel;
        while (node.getNext() != null) {
            node = node.getNext();
            if (node.getElement() != null) {
                r.addBetween(node.getElement(), r.sentinel.getPrev(), r.sentinel);
            } else {
                break;
            }
        }
        return r;
    }
}
