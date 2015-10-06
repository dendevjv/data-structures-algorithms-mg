package ru.dendevjv.dsalgjavamg.ch02;

public class Portfolio<T> {
    private T[] data;
    
    @SuppressWarnings("unchecked")
    Portfolio(int capacity) {
        data = (T[]) new Object[capacity];
    }

    T get(int index) { return data[index]; }
    
    void set(int index, T element) { data[index] = element; }
}
