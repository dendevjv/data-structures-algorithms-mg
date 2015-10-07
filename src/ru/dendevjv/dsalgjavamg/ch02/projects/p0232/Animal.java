package ru.dendevjv.dsalgjavamg.ch02.projects.p0232;

public class Animal {
    enum Gender { MALE, FEMALE }
    
    private boolean alive = true;
    private Gender gender;
    private double strength;
    private int x, y;
    
    Animal() {
        this(Math.random() > 0.5 ? Gender.MALE : Gender.FEMALE);
    }
    
    Animal(Gender gender) {
        this(gender, Math.random());
    }
    
    Animal(Gender gender, double strength) {
        alive = true;
        this.gender = gender;
        this.strength = strength;
    }
    
    boolean isNotSameGender(Animal other) {
        return gender != other.gender;
    }
    
    boolean isStrongerThan(Animal other) {
        return strength > other.strength;
    }

    boolean isAlive() {
        return alive;
    }

    void die() {
        alive = false;
    }

    void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

}
