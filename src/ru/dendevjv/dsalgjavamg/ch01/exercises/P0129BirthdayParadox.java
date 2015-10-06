package ru.dendevjv.dsalgjavamg.ch01.exercises;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.Scanner;

public class P0129BirthdayParadox {
    private static Random rnd = new Random();
    private static Scanner sc = new Scanner(System.in);
    
    private static class RandomPerson {
        Date birthday;
        
        RandomPerson() {
            birthday = new Date(rnd.nextLong());
        }
        
        boolean hasSameBirthday(RandomPerson other) {
            Calendar cal1 = new GregorianCalendar();
            cal1.setTime(birthday);
            Calendar cal2 = new GregorianCalendar();
            cal2.setTime(other.birthday);
            return cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH)
                    && cal1.get(Calendar.DAY_OF_MONTH) == cal2.get(Calendar.DAY_OF_MONTH);
        }
    }
    
    private static class Group {
        RandomPerson[] people;
        
        Group(int size) {
            people = new RandomPerson[size];
            for (int i = 0; i < people.length; i++) {
                people[i] = new RandomPerson();
            }
        }
        
        boolean twoPeopleHaveSameBirthday() {
            for (int i = 0; i < people.length - 1; i++) {
                for (int j = i + 1; j < people.length; j++) {
                    if (people[i].hasSameBirthday(people[j])) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.print("Enter size of the group: ");
        int size = sc.nextInt();
        int numTests = 100;
        int sameBirthdayCount = 0;
        for (int i = 0; i < numTests; i++) {
            Group group = new Group(size);
            if (group.twoPeopleHaveSameBirthday()) {
                sameBirthdayCount++;
            }
        }
        double rate = (double) sameBirthdayCount / numTests;
        System.out.printf("Rate = %.1f%%%n", rate * 100);
    }

}
