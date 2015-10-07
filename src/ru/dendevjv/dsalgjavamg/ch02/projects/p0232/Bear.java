package ru.dendevjv.dsalgjavamg.ch02.projects.p0232;

public class Bear extends Animal {
    Bear() {
        super();
    }
    
    Bear(Gender gender) {
        super(gender);
    }
    
    Bear(Gender gender, double strength) {
        super(gender, strength);
    }
    
    @Override
    public String toString() {
        return "Bear";
    }
}
