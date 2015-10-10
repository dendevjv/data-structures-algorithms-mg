package ru.dendevjv.dsalgjavamg.ch03fundamental;

public abstract class AbstractLinkedList <E> {
    protected int size;
    
    public AbstractLinkedList() {
        size = 0;
    }
    
    public int getSize() { return size; }
    
    public boolean isEmpty() { return size == 0; }
    
    public abstract E first();
    
    public abstract E last();
    
    public abstract void addFirst(E e);
    
    public abstract void addLast(E e);
    
    public abstract E removeFirst();
}
