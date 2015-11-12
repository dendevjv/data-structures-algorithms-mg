/*
    C-5.25 
    Describe a fast recursive algorithm for reversing a singly linked list L, so that the
    ordering of the nodes becomes opposite of what it was before.
 */
package ru.dendevjv.dsalgjavamg.ch05recursion.exercises;

public class C0525ReverseSinglyLinkedList {
    private static class LinkedList {
        private static class Node {
            private int data;
            private Node next;

            private Node(int value) {
                data = value;
            }

            public int getData() {
                return data;
            }

            public Node getNext() {
                return next;
            }

            public void setNext(Node next) {
                this.next = next;
            }
            
            @Override
            public String toString() {
                return Integer.toString(data);
            }
        }
        
        private Node head;
        
        void add(int value) {
            Node node = new Node(value);
            node.setNext(head);
            head = node;
        }
        
        void reverse() {
            if (head != null) {
                reverseRecursive(head, head.getNext());
            }
        }
        
        /**
         * Recursively reverses linked list starting from <code>prevNode</code>.
         * @param prevNode starting node 
         * @param nextNode node after <code>prevNode</code>
         * @return last node of the reversed part of the list
         */
        private Node reverseRecursive(Node prevNode, Node nextNode) {
            if (nextNode != null) {
                Node newPrevNode;
                if (nextNode.getNext() == null) {
                    newPrevNode = nextNode;
                    head = nextNode;
                } else {
                    newPrevNode = reverseRecursive(nextNode, nextNode.getNext());
                }
                newPrevNode.setNext(prevNode);
            }
            prevNode.setNext(null);
            return prevNode;
        }
        
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            if (head != null) {
                sb.append(head.getData());
            }
            Node current = head.getNext();
            while (current != null) {
                sb.append(", ");
                sb.append(current.getData());
                current = current.getNext();
            }
            sb.append(']');
            return sb.toString();
        }
    
        void addReverseAndPrint(int n) {
            add(n);
            reverse();
            System.out.println(toString());
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        for (int i = 1; i < 10; i++) {
            list.addReverseAndPrint(i);
        }
    }

}
