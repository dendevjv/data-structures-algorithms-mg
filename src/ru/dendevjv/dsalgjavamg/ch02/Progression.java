package ru.dendevjv.dsalgjavamg.ch02;

/**
 * Generates a simple progression. By default: 0, 1, 2, ...
 */
public class Progression {
    protected long current;
    
    /**
     * Constructs a progression starting at zero.
     */
    public Progression() {
        this(0);
    }
    
    /**
     * Constructs a progression with specified start.
     * @param start value for first element of progression
     */
    public Progression(long start) {
        current = start;
    }
    
    /**
     * Returns the next value of the progression, 
     * implicitly advancing the value each time.
     * @return next value
     */
    public long nextValue() {
        long answer = current;
        advance();
        return answer;
    }
    
    /**
     * Advances the current value to the next value of the progression.
     */
    protected void advance() {
        current++;
    }
    
    /**
     * Prints the next n values of the progression, separated by spaces.
     * @param n number of values to print
     */
    public void printProgression(int n) {
        System.out.print(nextValue());
        for (int j = 1; j < n; j++) {
            System.out.print(" " + nextValue());
        }
        System.out.println();
    }
}
