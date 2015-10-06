package ru.dendevjv.dsalgjavamg.ch02;

public class ObjectPair {
    private Object first;
    private Object second;
    
    public ObjectPair(Object a, Object b) {
        first = a;
        second = b;
    }
    
    public static void main(String[] args) {
        ObjectPair bid = new ObjectPair("ORCL", 32.07);
        System.out.println(bid.getSecond().getClass());
    }

    public Object getFirst() {
        return first;
    }

    public Object getSecond() {
        return second;
    }

}
