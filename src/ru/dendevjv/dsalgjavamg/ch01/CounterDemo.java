package ru.dendevjv.dsalgjavamg.ch01;

public class CounterDemo {

    public static void main(String[] args) {
        Counter c;
        c = new Counter();
        c.increment();
        c.increment(3);
        int temp = c.getCount();
        System.out.println(temp);   // 4
        
        c.reset();
        Counter d = new Counter(5);
        d.increment();
        System.out.println(d.getCount()); // 6
        
        Counter e = d;
        temp = e.getCount();
        System.out.println(temp); // 6
        
        e.increment(2);
        System.out.println(e.getCount()); // 8
    }

}
