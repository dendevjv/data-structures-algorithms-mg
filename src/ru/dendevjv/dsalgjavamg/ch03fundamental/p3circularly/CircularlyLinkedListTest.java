package ru.dendevjv.dsalgjavamg.ch03fundamental.p3circularly;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CircularlyLinkedListTest {
    private CircularlyLinkedList <Integer> list;

    @Before
    public void setUp() throws Exception {
        list = new CircularlyLinkedList<>();
    }
    
    @Test
    public void testRotate() {
        list.addFirst(1);
        list.addFirst(2);   // 2 1
        assertEquals(Integer.valueOf(2), list.first());
        
        list.rotate();      // 1 2
        assertEquals(Integer.valueOf(1), list.first());
        
        list.addFirst(3);   // 3 1 2
        assertEquals(Integer.valueOf(3), list.first());
        
        list.rotate();      // 1 2 3
        assertEquals(Integer.valueOf(1), list.first());
        list.rotate();      // 2 3 1
        assertEquals(Integer.valueOf(2), list.first());
        list.rotate();      // 3 1 2
        assertEquals(Integer.valueOf(3), list.first());
    }

    @Test
    public void testGetSize() {
        assertEquals(0, list.getSize());
        list.addFirst(1);
        assertEquals(1, list.getSize());
        list.addLast(2);
        assertEquals(2, list.getSize());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(list.isEmpty());
        list.addFirst(1);
        assertFalse(list.isEmpty());
        list.removeFirst();
        assertTrue(list.isEmpty());
    }
    
    @Test
    public void testFirst() {
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        Integer a = list.first();
        assertEquals(Integer.valueOf(3), a);
    }

    @Test
    public void testLast() {
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        Integer a = list.last();
        assertEquals(Integer.valueOf(3), a);
    }

    @Test
    public void testAddFirst() {
        list.addFirst(1);
        list.addFirst(3);   // 3 1
        assertEquals(2, list.getSize());
        Integer a = list.first();
        assertEquals(Integer.valueOf(3), a);
        a = list.last();
        assertEquals(Integer.valueOf(1), a);
    }

    @Test
    public void testAddLast() {
        list.addLast(1);
        list.addLast(3);    // 1 3
        assertEquals(2, list.getSize());
        Integer a = list.last();
        assertEquals(Integer.valueOf(3), a);
        a = list.first();
        assertEquals(Integer.valueOf(1), a);
    }

    @Test
    public void testRemoveFirst() {
        list.addFirst(1);    
        list.addLast(2);
        list.addFirst(3);
        list.addLast(4);    // 3 1 2 4
        assertEquals(4, list.getSize());
        assertEquals(Integer.valueOf(3), list.removeFirst());
        assertEquals(Integer.valueOf(1), list.removeFirst());
        assertEquals(Integer.valueOf(2), list.removeFirst());
        assertEquals(Integer.valueOf(4), list.removeFirst());
        assertEquals(0, list.getSize());
    }
    
    @Test
    public void testToString() {
        assertEquals("[]", list.toString());
        list.addLast(1);
        assertEquals("[1]", list.toString());
        list.addLast(2);
        assertEquals("[1, 2]", list.toString());
        list.addFirst(0);
        assertEquals("[0, 1, 2]", list.toString());
    }
}
