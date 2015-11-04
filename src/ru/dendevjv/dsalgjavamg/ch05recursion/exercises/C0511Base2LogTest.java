package ru.dendevjv.dsalgjavamg.ch05recursion.exercises;

import static org.junit.Assert.*;

import static ru.dendevjv.dsalgjavamg.ch05recursion.exercises.C0511Base2Log.base2log;

import org.junit.Test;

public class C0511Base2LogTest {

    @Test
    public void testBase2log() {
        assertEquals(0, base2log(1.0));
        assertEquals(1, base2log(2.0));
        assertEquals(1, base2log(3.0));
        assertEquals(2, base2log(4.0));
        assertEquals(2, base2log(5.0));
        assertEquals(2, base2log(6.0));
        assertEquals(2, base2log(7.0));
        assertEquals(3, base2log(8.0));
    }

}
