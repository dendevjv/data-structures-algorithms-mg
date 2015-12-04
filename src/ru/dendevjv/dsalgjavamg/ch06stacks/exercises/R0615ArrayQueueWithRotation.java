/*
    R-6.15 
    Augment the ArrayQueue implementation with a new rotate() method having
    semantics identical to the combination, enqueue(dequeue()). But, your implementation should be more efficient than making two separate calls (for example,
    because there is no need to modify the size).
 */
package ru.dendevjv.dsalgjavamg.ch06stacks.exercises;

import ru.dendevjv.dsalgjavamg.ch06stacks.examples.Cf0610ArrayQueue;

public class R0615ArrayQueueWithRotation<E> extends Cf0610ArrayQueue<E> {

    protected R0615ArrayQueueWithRotation(int capacity) {
        super(capacity);
    }
    
    public void rotate() {
        E e = data[first];
        data[first] = null;
        int afterLast = (first + size) % data.length;
        first = (first + 1) % data.length;
        data[afterLast] = e;
    }

    public static void main(String[] args) {
        R0615ArrayQueueWithRotation<Integer> q = new R0615ArrayQueueWithRotation<>(3);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        System.out.println(q);
        
        q.rotate();
        System.out.println(q);
        
        q.rotate();
        System.out.println(q);
        
        q.rotate();
        System.out.println(q);
    }

}
