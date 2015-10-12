/*
    R-3.8 Describe a method for finding the middle node of a doubly linked list with header
    and trailer sentinels by “link hopping,” and without relying on explicit knowledge
    of the size of the list. In the case of an even number of nodes, report the node
    slightly left of center as the “middle.” What is the running time of this method?
 */
package ru.dendevjv.dsalgjavamg.ch03fundamental.exercises;

import java.util.Iterator;

import ru.dendevjv.dsalgjavamg.ch03fundamental.AbstractDoublyLinkedList;

public class R0308DoublyLinkedList<E> extends AbstractDoublyLinkedList <E> {

    private Node<E> header;
    private Node<E> trailer;
  
    R0308DoublyLinkedList() {
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
    
    public E getMiddle() {
        Node<E> leftNode = header;
        Node<E> rightNode = trailer;
        while (leftNode != rightNode) {
            rightNode = rightNode.getPrev();
            if (leftNode == rightNode) {
                break;
            }
            leftNode = leftNode.getNext();
        }
        return leftNode.getElement();
    }
    
    public static void main(String[] args) {
        R0308DoublyLinkedList<String> list = new R0308DoublyLinkedList<>();
        System.out.println(list);
        System.out.println("middle: " + list.getMiddle());
        list.addFirst("Four");
        list.addFirst("Three");
        list.addFirst("Two");
        System.out.println(list);
        System.out.println("middle: " + list.getMiddle());
        
        list.addFirst("One");
        System.out.println(list);
        System.out.println("middle: " + list.getMiddle());
    }
}

