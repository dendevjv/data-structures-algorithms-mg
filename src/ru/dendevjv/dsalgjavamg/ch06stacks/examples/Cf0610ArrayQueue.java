package ru.dendevjv.dsalgjavamg.ch06stacks.examples;

/**
 * Implementation of the {@link Queue} using a fixed-length array.
 *
 * @param <E>
 */
public class Cf0610ArrayQueue<E> implements Queue<E> {
    /**
     * Underlying array.
     */
    protected E[] data;
    /**
     * Index of the first element in the queue.
     */
    protected int first;
    /**
     * Current number of elements stored in the queue.
     */
    protected int size;
    
    @SuppressWarnings("unchecked")
    protected Cf0610ArrayQueue(int capacity) {
        data = (E[])new Object[capacity];
        first = 0;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(E e) {
        if (size == data.length) {
            throw new IllegalStateException("Queue is full");
        }
        data[(first + size) % data.length] = e;
        size++;
    }

    @Override
    public E first() {
        if (isEmpty()) {
            return null;
        }
        return data[first];
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            return null;
        }
        E e = data[first];
        data[first] = null; // dereference to help GC
        first = (first + 1) % data.length;
        size--;
        return e;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (size > 0) {
            int j = first;
            sb.append(data[j]);
            for (int i = 1; i < size; i++) {
                j = (j + 1) % data.length;
                sb.append(", ");
                sb.append(data[j]);
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        Queue<Integer> q = new Cf0610ArrayQueue<>(3);
        q.enqueue(1);
        q.enqueue(3);
        q.enqueue(5);
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        q.enqueue(7);
        q.enqueue(8);
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
    }

}
