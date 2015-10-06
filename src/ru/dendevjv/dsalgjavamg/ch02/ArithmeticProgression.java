package ru.dendevjv.dsalgjavamg.ch02;

public class ArithmeticProgression extends Progression {
    protected long increment;
    
    /**
     * Constructs progression 0, 1, 2, ...
     */
    public ArithmeticProgression() {
        this(1, 0);
    }
    
    /**
     * Constructs progression 0, stepsize, 2*stepsize, ...
     * @param stepsize
     */
    public ArithmeticProgression(long stepsize) {
        this(stepsize, 0);
    }
    
    /**
     * Constructs arithmetic progression with specified start and increment.
     * @param stepsize increment value
     * @param start value of first element
     */
    public ArithmeticProgression(long stepsize, long start) {
        super(start);
        increment = stepsize;
    }
    
    @Override
    protected void advance() {
        current += increment;
    }
}
