package ru.dendevjv.dsalgjavamg.ch04analysis.examples;

public class E0405Disjointness {

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        int[] b = {4, 5};
        int[] c = {6};
        
        boolean r = disjoint(a, b, c);
        System.out.println(r);
        
        int[] d = {1, 6};
        int[] e = {1, 2};
        r = disjoint(a, d, e);
        System.out.println(r);
    }

    /** Returns true if there is no element common to all three arrays. */
    private static boolean disjoint(int[] groupA, int[] groupB, int[] groupC) {
        for (int a : groupA) {
            for (int b : groupB) {
                for (int c : groupC) {
                    if (a == b && b == c) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    /** Returns true if there is no element common to all three arrays. */
    @SuppressWarnings("unused")
    private static boolean disjoint2(int[] groupA, int[] groupB, int[] groupC) {
        for (int a : groupA) {
            for (int b : groupB) {
                if (a == b) {
                    for (int c : groupC) {
                        if (b == c) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

}
