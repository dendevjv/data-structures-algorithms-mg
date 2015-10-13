package ru.dendevjv.dsalgjavamg.ch03fundamental.exercises;

public class C0317 {

    public static void main(String[] args) {
        test(2, new int[] {3, 5, 7, 11, 7, 17});
        test(0, new int[] {3, 5, 3, 11, 8, 17});
        test(4, new int[] {3, 5, 7, 11, 17, 17});
        test(-1, new int[] {3, 5, 7, 11, 9, 17});
        test(-1, new int[] {});
    }

    private static void test(int expected, int[] a) {
        int p = findRepeated(a);
        if (p == expected) {
            if (p >= 0) {
                System.out.printf("OK: found %d at %d%n", a[p], p);
            } else {
                System.out.println("OK: negative test - nothing found");
            }
        } else {
            System.out.println("failed: could not find a repeated value");
        }
    }

    private static int findRepeated(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] == a[j]) {
                    return i;
                }
            }
        }
        return -1;
    }

}
