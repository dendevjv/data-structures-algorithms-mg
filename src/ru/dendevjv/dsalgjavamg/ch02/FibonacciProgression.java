package ru.dendevjv.dsalgjavamg.ch02;

public class FibonacciProgression extends Progression {
    private long next;
    
    public FibonacciProgression() {
        super(0);
        next = 1;
    }
    
    public FibonacciProgression(int start, int next) {
        super(start);
        this.next = next;
    }
    
    @Override
    protected void advance() {
        long newNext = current + next;
        current = next;
        next = newNext;
    }
}
