package ru.dendevjv.dsalgjavamg.ch03fundamental.exercises;

public class C0328ReverseList {
    private static class SinglyLinkedList {
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
        
        private Node headerSentinel;
        private int size;
        
        SinglyLinkedList() {
            headerSentinel = new Node(-1);
            size = 0;
        }
        
        int getSize() { return size; }
        
        void add(int value) {
            Node node = new Node(value);
            node.next = headerSentinel.next;
            headerSentinel.next = node;
            size++;
        }
        
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(getSize());
            sb.append(": [");
            Node n = headerSentinel.next;
            while (n != null) {
                sb.append(n.data);
                sb.append(' ');
                n = n.next;
            }
            sb.append("]");
            return sb.toString();
        }
        
        @SuppressWarnings("unused")
        void swapNodes(Node n1, Node n2) {
            Node n = headerSentinel, prev = null, prev1 = null, prev2 = null;
            while (n != null) {
                prev = n;
                n = n.next;
                if (n == n1) {
                    prev1 = prev;
                } else if (n == n2) {
                    prev2 = prev;
                }
            }
            if (prev1 != null && prev2 != null) {
                Node n1next = n1.next;
                if (n2.next == n1) {
                    n1.next = n2;
                } else {
                    n1.next = n2.next;
                    prev1.next = n2;
                }
                
                if (n1next == n2) {
                    n2.next = n1;
                } else {
                    n2.next = n1next;
                    prev2.next = n1;
                }
            }
        }
        
        @SuppressWarnings("unused")
        Node find(int value) {
            Node n = headerSentinel.next;
            while (n != null) {
                if (n.data == value) {
                    return n;
                }
                n = n.next;
            }
            return null;
        }
        
        void reverse() {
            Node tmpHeader = new Node(-1);
            Node futureCurrentNext = null;
            Node savedCurrentNext;
            Node current = headerSentinel.next;
            while (current != null) {
                // Add as first element
                tmpHeader.next = current;
                savedCurrentNext = current.next;
                current.next = futureCurrentNext;
                
                // Save as next for future iteration
                futureCurrentNext = current;
                
                // Go to next element
                current = savedCurrentNext;
            }
            headerSentinel.next = tmpHeader.next;
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(list);
        
        list.reverse();
        System.out.println(list);
    }

}
