package ru.dendevjv.dsalgjavamg.ch06stacks.examples;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Base class for testing implementations of {@link Deque} interface.
 * 
 * @author dendevjv
 */
public abstract class DequeTest {
    protected static final int CAPACITY = 2;
    
    protected Deque<Integer> deque;

    /**
     * Creating tested object <code>deque</code>. 
     * This method must be implemented in every test class. 
     * @param capacity capacity of deque if implementation data structure has fixed capacity,
     *      otherwise it is not used
     * @throws Exception
     */
    public abstract void createDeque(int capacity) throws Exception;
    
    @Before
    public void setUp() throws Exception {
        createDeque(CAPACITY);
    }

    @Test
    public void testSize() {
        assertEquals(0, deque.size());
        deque.addFirst(1);
        assertEquals(1, deque.size());
        deque.addLast(2);
        assertEquals(2, deque.size());
        deque.removeFirst();
        assertEquals(1, deque.size());
        deque.removeLast();
        assertEquals(0, deque.size());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(deque.isEmpty());
        
        deque.addFirst(1);
        assertFalse(deque.isEmpty());
        
        deque.removeLast();
        assertTrue(deque.isEmpty());
        
        deque.addLast(2);
        assertFalse(deque.isEmpty());
        
        deque.removeFirst();
        assertTrue(deque.isEmpty());
    }

    @Test
    public void testFirst() {
        deque.addFirst(1);
        assertEquals(Integer.valueOf(1), deque.first());
        
        deque.addFirst(2);
        assertEquals(Integer.valueOf(2), deque.first());
    }

    @Test
    public void testLast() {
        deque.addLast(1);
        assertEquals(Integer.valueOf(1), deque.last());
        
        deque.addLast(2);
        assertEquals(Integer.valueOf(2), deque.last());
    }

    @Test
    public void testAddFirst() {
        deque.addFirst(2);      // 2
        deque.addFirst(1);      // 1, 2
        assertEquals(Integer.valueOf(1), deque.first());
        
        deque.removeLast();     // 1
        deque.addFirst(0);      // 0, 1
        assertEquals(Integer.valueOf(0), deque.first());
        
        deque.removeLast();     // 0
        deque.addFirst(-1);
        assertEquals(Integer.valueOf(-1), deque.first());
    }

    @Test
    public void testAddLast() {
        deque.addLast(1);
        assertEquals(Integer.valueOf(1), deque.last());
        
        deque.addLast(2);
        assertEquals(Integer.valueOf(2), deque.last());
    }

    @Test
    public void testRemoveFirst() {
        deque.addLast(1);
        deque.addLast(2);           // 1, 2
        int a;
        a = deque.removeFirst();    // 2
        assertEquals(1, a);
        
        deque.addLast(3);           // 2, 3
        a = deque.removeFirst();    // 3 
        assertEquals(2, a);

        deque.addLast(4);           // 3, 4
        a = deque.removeFirst();    // 4
        assertEquals(3, a);
        
        a = deque.removeFirst();    // 
        assertEquals(4, a);
    }

    @Test
    public void testRemoveLast() {
        deque.addFirst(1);  // 1
        deque.addFirst(2);  // 2, 1
        int e;
        e = deque.removeLast(); // 2
        assertEquals(1, e);
        
        deque.addFirst(3);      // 3, 2
        e = deque.removeLast(); // 3
        assertEquals(2, e);
        
        deque.addFirst(4);      // 4, 3
        e = deque.removeLast(); // 4
        assertEquals(3, e);
        
        e = deque.removeLast(); 
        assertEquals(4, e);     
    }

    @Test
    public void testToString() {
        assertEquals("[]", deque.toString());
        
        deque.addLast(1);
        assertEquals("[1]", deque.toString());
        
        deque.addLast(2);
        assertEquals("[1, 2]", deque.toString());
        
        deque.removeLast();
        deque.addFirst(0);
        assertEquals("[0, 1]", deque.toString());
    }

}
