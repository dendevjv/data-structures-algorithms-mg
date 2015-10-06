package ru.dendevjv.dsalgjavamg.ch02.exercises;

import ru.dendevjv.dsalgjavamg.ch02.Progression;

public class C0223FibonacciProgression extends Progression {
    private long next;
    
    public C0223FibonacciProgression() {
        super(0);
        next = 1;
    }
    
    public C0223FibonacciProgression(int start, int next) {
        super(start);
        this.next = next;
    }
    
    @Override
    protected void advance() {
        next = current + next;
        current = next - current;
    }
    
    public static void main(String[] args) {
        C0223FibonacciProgression pr = new C0223FibonacciProgression();
        pr.printProgression(10);
    }

}
