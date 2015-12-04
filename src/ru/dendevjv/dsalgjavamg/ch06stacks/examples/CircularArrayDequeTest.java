package ru.dendevjv.dsalgjavamg.ch06stacks.examples;

public class CircularArrayDequeTest extends DequeTest {
    
    @Override
    public void createDeque(int capacity) throws Exception {
        deque = new CircularArrayDeque<>(capacity);
    }

}
