package ru.dendevjv.dsalgjavamg.ch03fundamental.exercises.p0343duckgoose;

import java.util.ListIterator;
import java.util.Random;
import java.util.Scanner;

import ru.dendevjv.dsalgjavamg.ch03fundamental.exercises.c0332.C0332CircularyDoubleLinkedList;

public class P0343Simulation {

    public static void main(String[] args) {
        Random rnd = new Random();
        int numPlayers = 5;
        C0332CircularyDoubleLinkedList<Person> list = new C0332CircularyDoubleLinkedList<>();
        Person it = new Person(0);
        for (int i = 1; i <= numPlayers; i++) {
            Person p = new Person(i);
            list.addLast(p);
        }
        System.out.println(list);
        
        Scanner sc = new Scanner(System.in);
        ListIterator<Person> iterator = list.listIterator();
        boolean playing = true;
        while (playing) {
            int numSteps = rnd.nextInt(numPlayers * 2);
            Person current = null;
            for (int i = 0; i < numSteps; i++) {
                current = iterator.next();
            }
            if (rnd.nextDouble() < 0.5) {
                // switch
                iterator.set(it);
                it = current;
            }
            System.out.print(list);
            System.out.print("  > ");
            String cmd = sc.nextLine();
            if ("exit".equals(cmd)) {
                playing = false;
            }
        }
        sc.close();
    }

}
