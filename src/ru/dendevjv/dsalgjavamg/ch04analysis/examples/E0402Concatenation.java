package ru.dendevjv.dsalgjavamg.ch04analysis.examples;

public class E0402Concatenation {

    public static void main(String[] args) {
        int size = 100000;
        StopWatch sw = new StopWatch();
        
        sw.start();
        repeat1('j', size);
        System.out.println(sw.stop());
        
        sw.start();
        repeat2('j', size);
        System.out.println(sw.stop());
    }

    public static String repeat1(char c, int n) {
        String answer = "";
        for (int j = 0; j < n; j++) {
            answer += c;
        }
        return answer;
    }
    
    public static String repeat2(char c, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(c);
        }
        return sb.toString();
    }
}
