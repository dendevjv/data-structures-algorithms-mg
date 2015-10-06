package ru.dendevjv.dsalgjavamg.ch02;

public interface Transportable {
    /** Returns the weight in grams. */
    int weight();
    
    /** Returns whether the object is hazardous. */
    boolean isHazardous();
}
