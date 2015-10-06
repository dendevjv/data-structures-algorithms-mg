package ru.dendevjv.dsalgjavamg.ch02;

public class Demo {
    private static class Place {
        void print() {
            System.out.println("Buy it.");
        }
    }
    
    private static class Region extends Place {
        void print() {
            System.out.println("Box it.");
        }
    }
    
    private static class State extends Region {
        void print() {
            System.out.println("Ship it.");
        }
    }
    
    private static class Maryland extends State {
        void print() {
            System.out.println("Read it.");
        }
    }

    public static void main(String[] args) {
        Region east = new State();
        State md = new Maryland();
        Object obj = new Place();
        Place usa = new Region();
        md.print();     // Read it.
        east.print();   // Ship it.
        ((Place) obj).print();  // Buy it.
        obj = md;
        ((Maryland) obj).print();   // Read it.
        obj = usa;
        ((Place) obj).print();  // Box it.
        usa = md;
        ((Place) usa).print();  // Read it.
    }

}
