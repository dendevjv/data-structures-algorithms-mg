package ru.dendevjv.dsalgjavamg.ch02;

/**
 * Interface for objects that can be sold.
 */
public interface Sellable {
    String description();
    
    /** Returns the list price in cents. */
    int listPrice();
    
    /** Returns the lowest price in cents we will accept. */
    int lowestPrice();
}
