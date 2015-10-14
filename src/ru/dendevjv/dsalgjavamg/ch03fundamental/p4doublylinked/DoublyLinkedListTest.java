package ru.dendevjv.dsalgjavamg.ch03fundamental.p4doublylinked;

import static org.junit.Assert.*;

import java.util.ListIterator;

import org.junit.Before;
import org.junit.Test;

public class DoublyLinkedListTest {
    private DoublyLinkedList<Integer> list;

    @Before
    public void setUp() throws Exception {
        list = new DoublyLinkedList<>();
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
        list.addLast(2);
        list.addFirst(3);
        assertEquals(3, list.getSize());
        Integer a = list.first();
        assertEquals(Integer.valueOf(3), a);
    }

    @Test
    public void testAddLast() {
        list.addLast(1);
        list.addFirst(2);
        list.addLast(3);
        assertEquals(3, list.getSize());
        Integer a = list.last();
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
        assertFalse(it1.hasNext());
        
        ListIterator<Integer> it2 = list.listIterator();
        for (int i = 0; i < length; i++) {
            it2.next();
        }
        assertFalse(it2.hasNext());
        for (int i = length; i > 0; i--) {
            assertTrue(it2.hasPrevious());
            Integer intObj = it2.previous();
            assertEquals(Integer.valueOf(i), intObj);
        }
        assertFalse(it2.hasPrevious());
        
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
}
