package ru.dendevjv.dsalgjavamg.ch03fundamental.p4doublylinked;

import java.util.Iterator;
import java.util.ListIterator;

import ru.dendevjv.dsalgjavamg.ch03fundamental.AbstractDoublyLinkedList;

public class DoublyLinkedList <E> extends AbstractDoublyLinkedList <E> {

    private Node<E> header;
    private Node<E> trailer;
  
    public DoublyLinkedList() {
        header = new Node<E>(null);
        trailer = new Node<E>(null);
        header.setNext(trailer);
        trailer.setPrev(header);
    }

    @Override
    public E first() {
        if (isEmpty()) return null;
        return header.getNext().getElement();
    }

    @Override
    public E last() {
        if (isEmpty()) return null;
        return trailer.getPrev().getElement();
    }

    @Override
    public void addFirst(E e) {
        addBetween(e, header, header.getNext());
    }

    @Override
    public void addLast(E e) {
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
        return remove(trailer.getPrev());
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
    
    public DoublyLinkedList<E> concatenate(DoublyLinkedList<E> b) {
        DoublyLinkedList<E> r = new DoublyLinkedList<>();
        Node<E> node = header;
        while (node.getNext() != null) {
            node = node.getNext();
            if (node.getElement() != null) {
                r.addBetween(node.getElement(), r.trailer.getPrev(), r.trailer);
            } else {
                break;
            }
        }
        node = b.header;
        while (node.getNext() != null) {
            node = node.getNext();
            if (node.getElement() != null) {
                r.addBetween(node.getElement(), r.trailer.getPrev(), r.trailer);
            } else {
                break;
            }
        }
        return r;
    }
}
