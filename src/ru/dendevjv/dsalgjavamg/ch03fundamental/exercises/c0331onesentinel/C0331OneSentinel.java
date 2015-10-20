/*
    C-3.31 
    Our implementation of a doubly linked list relies on two sentinel nodes, header
    and trailer, but a single sentinel node that guards both ends of the list should
    suffice. Reimplement the DoublyLinkedList class using only one sentinel node.
 */
package ru.dendevjv.dsalgjavamg.ch03fundamental.exercises.c0331onesentinel;

public class C0331OneSentinel {

    public static void main(String[] args) {
        C0331DoublyLinkedList<Integer> list = new C0331DoublyLinkedList<>();
        list.addLast(1);
        System.out.println(list);
        list.addLast(2);
        System.out.println(list);
        list.addLast(3);
        System.out.println(list);
    }

}
