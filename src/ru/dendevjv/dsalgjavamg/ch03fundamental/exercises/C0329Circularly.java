/*
    C-3.29 
    Suppose you are given two circularly linked lists, L and M. Describe an algorithm
    for telling if L and M store the same sequence of elements (but perhaps with
    different starting points).
 */
package ru.dendevjv.dsalgjavamg.ch03fundamental.exercises;

public class C0329Circularly {
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
        
        void add(int value) {
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
        
        public boolean storesSameSequence(CircularlyLinkedList other) {
            if (size == 0 || other.size == 0) return false;
            Node n1 = tail.next;
            Node n2 = other.tail.next;
            boolean foundStart = false;
            outer:
            for (int j = 0; !foundStart && j < size; j++) {
                for (int i = 0; !foundStart && i < other.size; i++) {
                    if (n1.data == n2.data) {
                        foundStart = true;
                        break outer;
                    }
                    n2 = n2.next;
                }
                n1 = n1.next;
            }
            int minSize = size < other.size ? size : other.size;
            if (foundStart) {
                for (int i = 0; i < minSize; i++) {
                    if (n1.data != n2.data) {
                        return false;
                    }
                    n1 = n1.next;
                    n2 = n2.next;
                }
                return true;
            }
            return false;
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
    }

    public static void main(String[] args) {
        testSequence(1, 7, 1, 7);
        testSequence(1, 7, 1, 9);
        testSequence(1, 9, 1, 7);
        testSequence(1, 7, 2, 6);
        testSequence(3, 5, 1, 7);
        testSequence(3, 6, 4, 5);
        testSequence(new int[] {1, 2, 3}, new int[] {2, 3, 1});
        testSequence(new int[] {1, 2, 3}, new int[] {2, 3, 4, 1});
        testSequence(new int[] {2, 3, 4}, new int[] {3, 4, 1, 2});
        
        testSequence(1, 4, 4, 7);
        testSequence(4, 7, 1, 4);
    }
    
    private static void testSequence(int[] values1, int[] values2) {
        CircularlyLinkedList list1 = new CircularlyLinkedList();
        for (int v : values1) {
            list1.add(v);
        }
        CircularlyLinkedList list2 = new CircularlyLinkedList();
        for (int v : values2) {
            list2.add(v);
        }
        test(list1, list2);
    }

    private static void testSequence(int from1, int to1, int from2, int to2) {
        CircularlyLinkedList list1 = new CircularlyLinkedList();
        addRange(list1, from1, to1);
        
        CircularlyLinkedList list2 = new CircularlyLinkedList();
        addRange(list2, from2, to2);
        
        test(list1, list2);
    }

    private static void test(CircularlyLinkedList list1,
            CircularlyLinkedList list2) {
        if (list1.storesSameSequence(list2)) {
            System.out.printf("Lists %s and %s contain same sequence%n", list1, list2);
        } else {
            System.out.printf("Lists %s and %s do NOT contain same sequence%n", list1, list2);
        }
    }

    private static void addRange(CircularlyLinkedList list, int from, int to) {
        for (int i = from; i < to; i++) {
            list.add(i);
        }
    }

}
