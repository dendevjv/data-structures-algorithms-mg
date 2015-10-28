package ru.dendevjv.dsalgjavamg.ch04analysis.examples;

public class StopWatch {
    private long startingTime;
    
    public void start() {
        startingTime = System.currentTimeMillis();
    }
    
    public long stop() {
        return System.currentTimeMillis() - startingTime;
    }
    
    public static long measure(Runnable runner) {
        long start = System.currentTimeMillis();
        runner.run();
        return System.currentTimeMillis() - start;
    }
}
