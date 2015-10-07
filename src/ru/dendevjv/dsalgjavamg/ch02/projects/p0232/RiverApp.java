/*
    P-2.32.
    Write a simulator as in the previous project, but add a boolean gender field and
    a floating-point strength field to each Animal object. Now, if two animals of
    the same type try to collide, then they only create a new instance of that type of
    animal if they are of different genders. Otherwise, if two animals of the same
    type and gender try to collide, then only the one of larger strength survives.
 */
package ru.dendevjv.dsalgjavamg.ch02.projects.p0232;

import java.util.Scanner;

public class RiverApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        River river = new River(8, 0.2);

        river.display();
        while (true) {
            String cmd = sc.nextLine();
            if ("exit".equals(cmd)) {
                break;
            }
            river.tick();
        }
        sc.close();
    }
}
