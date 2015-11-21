/* Code fragment 6.2: Array based implementation of the Stack interface */
package ru.dendevjv.dsalgjavamg.ch06stacks.examples;

import ru.dendevjv.dsalgjavamg.utils.Array;

/**
 * Array based implementation of the {@link Stack} interface.
 */
public class ArrayStack<E> implements Stack<E> {
    /**
     * Default array capacity.
     */
    public static final int CAPACITY = 1000;

    /**
     * Generic array used for storage.
     */
    private E[] data;

    /**
     * Index of the top element in the stack.
     */
    private int topIndex = -1;

    /**
     * Constructs stack with default capacity.
     */
    public ArrayStack() {
        this(CAPACITY);
    }

    /**
     * Constructs stack with given capacity.
     */
    @SuppressWarnings("unchecked")
    public ArrayStack(int capacity) {
        data = (E[]) new Object[capacity];
    }

    @Override
    public int size() {
        return topIndex + 1;
    }

    @Override
    public boolean isEmpty() {
        return topIndex == -1;
    }

    @Override
    public void push(E e) {
        if (size() == data.length) {
            throw new IllegalStateException("Stack is full");
        }
        data[++topIndex] = e;
    }

    @Override
    public E top() {
        if (isEmpty()) {
            return null;
        }
        return data[topIndex];
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        E answer = data[topIndex];
        data[topIndex] = null; // dereference to help garbage collection
        topIndex--;
        return answer;
    }
    
    @Override
    public String toString() {
        return Array.toString(data, size());
    }

}
