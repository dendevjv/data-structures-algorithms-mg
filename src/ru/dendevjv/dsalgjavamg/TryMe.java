package ru.dendevjv.dsalgjavamg;

import java.util.LinkedList;
import java.util.List;

class Empty { }

class Extended extends Empty {  }

public class TryMe {
    public static void doStuff1(List<Empty> list) {
        // some code
    }

    @SuppressWarnings("rawtypes")
    public static void doStuff2(List list) {
        // some code
    }

    public static void doStuff3(List<? extends Empty> list) {
        // some code
    }

    @SuppressWarnings("unused")
    public static void main(String args[]) {
        List<Empty> list1 = new LinkedList<Empty>();
        List<Extended> list2 = new LinkedList<Extended>();

        // more code here
    }
}
