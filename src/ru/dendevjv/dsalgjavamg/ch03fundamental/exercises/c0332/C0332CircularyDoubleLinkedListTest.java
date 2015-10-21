package ru.dendevjv.dsalgjavamg.ch03fundamental.exercises.c0332;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.ListIterator;

import org.junit.Before;
import org.junit.Test;

public class C0332CircularyDoubleLinkedListTest {
    private C0332CircularyDoubleLinkedList<Integer> list;

    @Before
    public void setUp() throws Exception {
        list = new C0332CircularyDoubleLinkedList<>();
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
        Integer a = list.first();
        assertEquals(Integer.valueOf(1), a);
        
        list.addLast(2);
        a = list.first();
        assertEquals(Integer.valueOf(1), a);
        
        list.addFirst(3);
        assertEquals(3, list.getSize());
        a = list.first();
        assertEquals(Integer.valueOf(3), a);
    }

    @Test
    public void testAddLast() {
        list.addLast(1);
        Integer a = list.last();
        assertEquals(Integer.valueOf(1), a);
        
        list.addFirst(2);
        a = list.last();
        assertEquals(Integer.valueOf(1), a);
        
        list.addLast(3);
        assertEquals(3, list.getSize());
        a = list.last();
        assertEquals(Integer.valueOf(3), a);
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
    public void testRemoveLast() {
        list.addFirst(1);    
        list.addLast(2);
        list.addFirst(3);
        list.addLast(4);    // 3 1 2 4
        assertEquals(4, list.getSize());
        assertEquals(Integer.valueOf(4), list.removeLast());
        assertEquals(Integer.valueOf(2), list.removeLast());
        assertEquals(Integer.valueOf(1), list.removeLast());
        assertEquals(Integer.valueOf(3), list.removeLast());
        assertEquals(0, list.getSize());
    }

    @Test
    public void testIterator() {
        int length = 3;
        for (int i = 1; i <= length; i++) {
            list.addLast(i);
        }
        Iterator<Integer> it1 = list.iterator();
        for (int i = 1; i <= length; i++) {
            assertTrue(it1.hasNext());
            Integer intObj = it1.next();
            assertEquals(Integer.valueOf(i), intObj);
        }
    }
    
    @Test
    public void testToString() {
        assertEquals("[]", list.toString());
        
        list.addFirst(1);
        assertEquals("[1]", list.toString());
        
        list.addLast(2);
        assertEquals("[1, 2]", list.toString());
        
        list.addLast(3);
        assertEquals("[1, 2, 3]", list.toString());
    }
    
    @Test
    public void testListIterator() {
        int length = 4;
        for (int i = 1; i <= length; i++) {
            list.addLast(i);
        }
        
        ListIterator<Integer> it1 = list.listIterator();
        for (int i = 1; i <= length; i++) {
            assertTrue(it1.hasNext());
            Integer intObj = it1.next();
            assertEquals(Integer.valueOf(i), intObj);
        }
        
        ListIterator<Integer> it2 = list.listIterator();
        for (int i = 0; i < length; i++) {
            it2.next();
        }
        for (int i = length; i > 0; i--) {
            assertTrue(it2.hasPrevious());
            Integer intObj = it2.previous();
            assertEquals(Integer.valueOf(i), intObj);
        }
        
        assertEquals("[1, 2, 3, 4]", list.toString());
        ListIterator<Integer> it3 = list.listIterator();
        it3.next();
        it3.remove();
        assertEquals("[2, 3, 4]", list.toString());
        it3.next();
        it3.next();
        it3.next();
        it3.remove();
        assertEquals("[2, 3]", list.toString());
        it3.previous();
        it3.previous();
        it3.next();
        it3.remove();
        assertEquals("[3]", list.toString());
        it3.next();
        it3.remove();
        assertEquals("[]", list.toString());
        assertTrue(list.isEmpty());
    }

    @Test
    public void testRotate() {
        int length = 4;
        for (int i = 1; i <= length; i++) {
            list.addLast(i);
        }
        assertEquals("[1, 2, 3, 4]", list.toString());
        
        list.rotate();
        assertEquals("[2, 3, 4, 1]", list.toString());
    }

    @Test
    public void testRotateBackward() {
        int length = 4;
        for (int i = 1; i <= length; i++) {
            list.addLast(i);
        }
        assertEquals("[1, 2, 3, 4]", list.toString());
        
        list.rotateBackward();
        assertEquals("[4, 1, 2, 3]", list.toString());
    }

}
