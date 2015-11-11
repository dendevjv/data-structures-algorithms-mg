package ru.dendevjv.dsalgjavamg.utils;

public class StopWatch {
    private long startTime;
    private String title;
    
    public void start(String title) {
        this.title = title;
        System.out.println("Starting " + title);
        startTime = System.currentTimeMillis();
    }
    
    public void stop() {
        long elapsed = System.currentTimeMillis() - startTime;
        System.out.println(title + " : " + elapsed + " milliseconds");
    }

    public static void main(String[] args) {
        StopWatch sw = new StopWatch();
        sw.start("Testing");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        sw.stop();
    }

}
