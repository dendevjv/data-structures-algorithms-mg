package ru.dendevjv.dsalgjavamg.ch02.exercises;

public abstract class C0225GenericProgression <T> {
    
    private T current;
    
    /**
     * Constructs a progression with specified start.
     * @param start value for first element of progression
     */
    public C0225GenericProgression(T start) {
        current = start;
    }
    
    /**
     * Returns the next value of the progression, 
     * implicitly advancing the value each time.
     * @return next value
     */
    public T nextValue() {
        T answer = current;
        advance();
        return answer;
    }
    
    /**
     * Advances the current value to the next value of the progression.
     */
    protected abstract void advance();
    
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

    public T getCurrent() {
        return current;
    }

    public void setCurrent(T current) {
        this.current = current;
    }

}
