package ru.dendevjv.dsalgjavamg.ch03fundamental.exercises.c0331onesentinel;

import java.util.Iterator;
import java.util.ListIterator;

import ru.dendevjv.dsalgjavamg.ch03fundamental.AbstractDoublyLinkedList;

public class C0331DoublyLinkedList <E> extends AbstractDoublyLinkedList <E> {

    private Node<E> header;
  
    public C0331DoublyLinkedList() {
        header = new Node<E>(null);
        header.setNext(header);
        header.setPrev(header);
    }

    @Override
    public E first() {
        if (isEmpty()) return null;
        return header.getNext().getElement();
    }

    @Override
    public E last() {
        if (isEmpty()) return null;
        return header.getPrev().getPrev().getElement();
    }

    @Override
    public void addFirst(E e) {
        addBetween(e, header, header.getNext());
    }

    @Override
    public void addLast(E e) {
        Node<E> trailer = header.getPrev();
        addBetween(e, trailer.getPrev(), trailer);
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) return null;
        return remove(header.getNext());
    }
 
    @Override
    public E removeLast() {
        if (isEmpty()) return null;
        return remove(header.getPrev().getPrev());
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
        return new DoubleyLinkedListIterator<E>(header.getNext());
    }

    @Override
    public ListIterator<E> listIterator() {
        return new DoubleyLinkedListListIterator<E>(header.getNext());
    }
    
    public C0331DoublyLinkedList<E> concatenate(C0331DoublyLinkedList<E> b) {
        C0331DoublyLinkedList<E> r = new C0331DoublyLinkedList<>();
        Node<E> node = header;
        while (node.getNext() != null) {
            node = node.getNext();
            if (node.getElement() != null) {
                r.addBetween(node.getElement(), r.header.getPrev().getPrev(), r.header.getPrev());
            } else {
                break;
            }
        }
        node = b.header;
        while (node.getNext() != null) {
            node = node.getNext();
            if (node.getElement() != null) {
                r.addBetween(node.getElement(), r.header.getPrev().getPrev(), r.header.getPrev());
            } else {
                break;
            }
        }
        return r;
    }
}
