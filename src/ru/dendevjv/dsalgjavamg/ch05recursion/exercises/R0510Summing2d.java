package ru.dendevjv.dsalgjavamg.ch05recursion.exercises;

public class R0510Summing2d {

    public static void main(String[] args) {
        int[][] a = {{1, 2, 3}, {4, 5, 6}, {7}};
        int sum = sum2d(a, 0, 0);
        System.out.println("sum = " + sum);
    }

    private static int sum2d(int[][] a, int startRow, int startCol) {
        int sum = 0;
        if (startRow < a.length) {
            if (startCol < a[startRow].length) {
                sum = a[startRow][startCol] + sum2d(a, startRow, startCol + 1);
            } else {
                sum = sum2d(a, startRow + 1, 0);
            }
        }
        return sum;
    }

}
