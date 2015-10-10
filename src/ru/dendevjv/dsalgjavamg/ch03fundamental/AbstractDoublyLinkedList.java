package ru.dendevjv.dsalgjavamg.ch03fundamental;


public abstract class AbstractDoublyLinkedList <E> extends AbstractLinkedList <E> {
    /**
     * Nested node class.
     */
    protected static class Node <E> {
        private E element;
        private Node <E> previous;
        private Node <E> next;
        
        public Node(E element) {
            this.element = element;
        }
        
        public Node(E element, Node<E> nextNode, Node<E> prevNode) {
            this.element = element;
            previous = prevNode;
            next = nextNode;
        }
        
        public E getElement() { return element; }
        
        public Node<E> getNext() { return next; }
        
        public Node<E> getPrev() { return previous; }
        
        public void setNext(Node<E> node) { next = node; }
        
        public void setPrev(Node<E> node) { previous = node; }
    }
    
    public abstract E removeLast();
}
