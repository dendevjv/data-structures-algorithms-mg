package ru.dendevjv.dsalgjavamg.ch03fundamental.p2singlylinked;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SinglyLinkedListTest {
    private SinglyLinkedList<Integer> list;

    @Before
    public void setUp() throws Exception {
        list = new SinglyLinkedList<>();
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
        
        assertNull(list.last());
        
        list.addLast(5);
        assertEquals(Integer.valueOf(5), list.first());
    }

    @Test
    public void testEquals() {
        SinglyLinkedList<Integer> list2 = new SinglyLinkedList<>();
        for (int i = 0; i < 3; i++) {
            list.addFirst(i);   
            list2.addFirst(i);  
        }
        assertEquals(list, list2);
        assertEquals(list2, list);
        
        assertFalse(list.equals(null));
        assertTrue(list.equals(list));
        
        list2.removeFirst();    
        assertFalse(list.equals(list2));
        
        list.removeFirst();     
        assertTrue(list.equals(list2));
        
        list.addLast(44);
        list2.addLast(33);
        assertEquals(list.getSize(), list2.getSize());
        assertFalse(list.equals(list2));
    }
    
    @Test
    public void testClone() {
        class Data {
            private String message;
            Data(String msg) {
                message = msg;
            }
            @Override
            public String toString() {
                return "\"" + message + "\"";
            }
        }
        
        SinglyLinkedList<Data> list1 = new SinglyLinkedList<>();
        for (int i = 0; i < 3; i++) {
            list1.addFirst(new Data("Data" + i));   
        }
        
        @SuppressWarnings("unchecked")
        SinglyLinkedList<Data> list2 = (SinglyLinkedList<Data>)list1.clone();
        assertEquals(list1, list2);
        assertEquals(list1.first(), list2.first());
        assertEquals(list1.last(), list2.last());
    }
}
