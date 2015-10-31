package ru.dendevjv.dsalgjavamg.ch05recursion.examples;

public class Cf0506LinearSum {

    public static void main(String[] args) {
        int[] a = {4, 3, 6, 2, 8};
        int sum = linearSum(a, a.length);
        System.out.println("sum = " + sum);
    }

    private static int linearSum(int[] data, int upToIndex) {
        if (upToIndex == 0) {
            return 0;
        } else {
            int last = upToIndex - 1;
            return linearSum(data, last) + data[last];
        }
    }

}
