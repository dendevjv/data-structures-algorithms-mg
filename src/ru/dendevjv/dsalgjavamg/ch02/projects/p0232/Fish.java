package ru.dendevjv.dsalgjavamg.ch02.projects.p0232;

public class Fish extends Animal {
    Fish() {
        super();
    }
    
    Fish(Gender gender) {
        super(gender);
    }
    
    Fish(Gender gender, double strength) {
        super(gender, strength);
    }
    
    @Override
    public String toString() {
        return "Fish";
    }
}
