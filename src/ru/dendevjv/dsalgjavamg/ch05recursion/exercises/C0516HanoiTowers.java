/*
    C-5.16 
    In the Towers of Hanoi puzzle, we are given a platform with three pegs, a, b, and
    c, sticking out of it. On peg a is a stack of n disks, each larger than the next, so
    that the smallest is on the top and the largest is on the bottom. The puzzle is to
    move all the disks from peg a to peg c, moving one disk at a time, so that we
    never place a larger disk on top of a smaller one. Describe a recursive algorithm 
    for solving the Towers of Hanoi puzzle for arbitrary n. 
 */
package ru.dendevjv.dsalgjavamg.ch05recursion.exercises;

import ru.dendevjv.dsalgjavamg.utils.Array;

public class C0516HanoiTowers {
    private static class Tower {
        private String id;
        private int[] disks;
        private int size;
        private int capacity;

        Tower(String id, int capacity) {
            this.id = id;
            this.capacity = capacity;
            disks = new int[capacity];
            size = 0;
        }

        void fill() {
            for (int i = capacity; i > 0; i--) {
                add(i);
            }
        }

        void add(int disk) {
            disks[size++] = disk;
        }

        int remove() {
            return disks[--size];
        }

        void move(Tower to) {
            int disk = remove();
            System.out.println(id + " -> " + disk + " -> " + to.id);
            to.add(disk);
        }

        @Override
        public String toString() {
            return String.format("%s : %s", id, Array.toString(disks, size));
        }
    }

    public static void main(String[] args) {
        int capacity = 3;
        Tower a = new Tower("A", capacity);
        a.fill();
        Tower b = new Tower("B", capacity);
        Tower c = new Tower("C", capacity);
        System.out.println(a);
        System.out.println(c);

        move(capacity, a, b, c);
        System.out.println(a);
        System.out.println(c);
    }

    private static void move(int numDisks, Tower from, Tower temp, Tower to) {
        if (numDisks == 1) {
            from.move(to);
        } else {
            move(numDisks - 1, from, to, temp);
            from.move(to);
            move(numDisks - 1, temp, from, to);
        }
    }
}
