package ru.dendevjv.dsalgjavamg.ch03fundamental.exercises.p0343duckgoose;

public class Person {
    private int id;
    
    Person(int id) {
        this.id = id;
    }
    
    @Override
    public String toString() {
        return Integer.toString(id);
    }
}
