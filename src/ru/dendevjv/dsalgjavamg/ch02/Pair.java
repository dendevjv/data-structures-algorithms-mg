package ru.dendevjv.dsalgjavamg.ch02;

public class Pair<A, B> {
    private A first;
    private B second;
    
    Pair(A a, B b) {
        first = a;
        second = b;
    }
    
    A getFirst() { return first; }
    
    B getSecond() { return second; }
    
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Pair<String, Double> bid = new Pair<>("ABC", 3.14);
        Pair<String, Double>[] holdings;
        holdings = new Pair[25];
        holdings[0] = bid;
    }

}
