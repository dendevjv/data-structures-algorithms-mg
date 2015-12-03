package ru.dendevjv.dsalgjavamg.ch06stacks.examples;

public class CircularArrayDeque <E> implements Deque<E> {
    private E[] data;
    private int size;
    /**
     * Index of the first element of the queue.
     */
    private int first;
    
    @SuppressWarnings("unchecked")
    CircularArrayDeque(int capacity) {
        data = (E[]) new Object[capacity];
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
    public E first() {
        if (isEmpty()) {
            return null;
        }
        return data[first];
    }

    @Override
    public E last() {
        if (isEmpty()) {
            return null;
        }
        int last = (first + size - 1) % data.length;
        return data[last];
    }

    @Override
    public void addFirst(E e) {
        checkCapacity();
        first = (first == 0) ? data.length - 1: first - 1;
        data[first] = e;
        size++;
    }

    @Override
    public void addLast(E e) {
        checkCapacity();
        data[(first + size) % data.length] = e;
        size++;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        E e = data[first];
        data[first] = null;
        first = (first + 1) % data.length;
        size--;
        return e;
    }

    @Override
    public E removeLast() {
        if (isEmpty()) {
            return null;
        }
        int last = (first + size - 1) % data.length;
        E e = data[last];
        data[last] = null;
        size--;
        return e;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (size > 0) {
            sb.append(data[first]);
            if (size > 1) {
                int j = first;
                for (int i = 1; i < size; i++) {
                    sb.append(", ");
                    j = (j + 1) % data.length;
                    sb.append(data[j]);
                }
            }
        }
        sb.append("]");
        return sb.toString();
    }
    
    private void checkCapacity() {
        if (size == data.length) {
            throw new RuntimeException("Deque is full");
        }
    }
}
