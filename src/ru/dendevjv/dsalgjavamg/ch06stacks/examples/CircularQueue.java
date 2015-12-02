package ru.dendevjv.dsalgjavamg.ch06stacks.examples;

/**
 * Extension of {@link Queue} interface with rotating capabilities.
 *
 * @param <E>
 */
public interface CircularQueue<E> extends Queue<E> {
    /**
     * Rotates the front element of the queue to the back of the queue.<br />
     * This does nothing if the queue is empty.
     */
    void rotate();
}
