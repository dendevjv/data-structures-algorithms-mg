/*
    C-5.26 
    Give a recursive definition of a singly linked list class that does not use any Node
    class.
 */
package ru.dendevjv.dsalgjavamg.ch05recursion.exercises;

public class C0526SimpleLinkedList {
    private static class List {
        private int firstValue;
        private List tail;
        
        List(int value) {
            this.firstValue = value;
        }
        
        private List makeAddition(int value) {
            List t = new List(value);
            t.tail = this;
            return t;
        }
        
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            sb.append(firstValue);
            List t = tail;
            while (t != null) {
                sb.append(", ");
                sb.append(t.firstValue);
                t = t.tail;
            }
            sb.append(']');
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        List a1 = new List(1);
        List a2 = a1.makeAddition(2);
        List a3 = a2.makeAddition(3);
        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);
    }

}
