/*
    C-3.30 
    Given a circularly linked list L containing an even number of nodes, describe
    how to split L into two circularly linked lists of half the size.
 */
package ru.dendevjv.dsalgjavamg.ch03fundamental.exercises;

public class C0330Split {
    private static class CircularlyLinkedList {
        static class Node {
            private int data;
            private Node next;
            
            Node(int value) {
                data = value;
            }
            
            @Override
            public String toString() {
                return Integer.toString(data);
            }
        }
        
        private Node tail;
        private int size;
        
        CircularlyLinkedList() {
            size = 0;
        }
        
        @SuppressWarnings("unused")
        void addFirst(int value) {
            Node n = new Node(value);
            if (size > 0) {
                n.next = tail.next;
                tail.next = n;
            } else {
                n.next = n;
                tail = n;
            }
            size++;
        }
        
        void addLast(int value) {
            Node n = new Node(value);
            if (size > 0) {
                n.next = tail.next;
                tail.next = n;
            } else {
                n.next = n;
            }
            tail = n;
            size++;
        }
        
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            if (size > 0) {
                Node current = tail.next;
                sb.append(current.data);
                for (int i = 1; i < size; i++) {
                    current = current.next;
                    sb.append(", ");
                    sb.append(current.data);
                }
            }
            sb.append("]");
            return sb.toString();
        }
        
        /**
         * Splits the list into two lists of half the size.
         * @return arrays containing two lists
         */
        public CircularlyLinkedList[] split() {
            if (size < 2) {
                return null;
            }
            int size1 = size / 2;
            Node n = tail.next;
            CircularlyLinkedList list1 = new CircularlyLinkedList();
            for (int i = 0; i < size1; i++) {
                list1.addLast(n.data);
                n = n.next;
            }
            int size2 = size - size1;
            
            CircularlyLinkedList list2 = new CircularlyLinkedList();
            for (int i = 0; i < size2; i++) {
                list2.addLast(n.data);
                n = n.next;
            }
            return new CircularlyLinkedList[] {list1, list2};
        }
    }

    public static void main(String[] args) {
        CircularlyLinkedList list = new CircularlyLinkedList();
        list.addLast(5);
        list.addLast(4);
        list.addLast(3);
        list.addLast(2);
        list.addLast(1);
        System.out.println(list);
        
        CircularlyLinkedList[] arr = list.split();
        System.out.println(arr[0]);
        System.out.println(arr[1]);
    }

}
