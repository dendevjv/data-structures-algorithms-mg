package ru.dendevjv.dsalgjavamg.ch02.exercises;

import ru.dendevjv.dsalgjavamg.ch02.Progression;

public class C0224DiffProgression extends Progression {
    private static final int DEFAULT_SECOND = 200;
    private static final int DEFAULT_FIRST = 2;
    
    private long next;
    
    /**
     * Creates progression with default values 2 and 200.
     */
    C0224DiffProgression() {
        this(DEFAULT_FIRST, DEFAULT_SECOND);
    }
    
    C0224DiffProgression(long first, long second) {
        super(first);
        next = second;
    }
    
    @Override
    protected void advance() {
        long nextValue = Math.abs(next - current);
        current = next;
        next = nextValue;
    }

    public static void main(String[] args) {
        C0224DiffProgression pr1 = new C0224DiffProgression();
        pr1.printProgression(20);
        C0224DiffProgression pr2 = new C0224DiffProgression(2, 2);
        pr2.printProgression(20);
    }

}
