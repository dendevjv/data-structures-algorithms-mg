package ru.dendevjv.dsalgjavamg.ch03fundamental.exercises.c0319;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ru.dendevjv.dsalgjavamg.ch03fundamental.GameEntry;

public class C0319ScoreboardTest {
    private C0319Scoreboard board;

    @Before
    public void initialize() {
        board = new C0319Scoreboard();
    }
    
    @Test
    public void testGetTop() {
        GameEntry entry, top;
        
        entry = board.getTop();
        assertEquals(null, entry);
        
        entry = new GameEntry("Abby", 100);
        board.add(entry);
        top = board.getTop();
        assertEquals(entry, top);
        
        GameEntry entry2 = new GameEntry("Bob", 200);
        board.add(entry2);
        top = board.getTop();
        assertEquals(entry, top);
    }
    
    @Test
    public void testAdd() {
        GameEntry  e100 = new GameEntry("Abby", 100);
        board.add(e100);
        String expected = "[(Abby, 100)]";
        String actual = board.toString();
        assertEquals(expected, actual);
        
        GameEntry e200 = new GameEntry("Bob", 200);
        board.add(e200);
        expected = "[(Abby, 100), (Bob, 200)]";
        actual = board.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testRemove() {
        GameEntry  e100 = new GameEntry("Abby", 100);
        board.add(e100);
        GameEntry e200 = new GameEntry("Bob", 200);
        board.add(e200);
        GameEntry e050 = new GameEntry("Alice", 50);
        board.add(e050);
        GameEntry e150 = new GameEntry("Karen", 150);
        board.add(e150);
        
        GameEntry e3 = board.remove(3);
        assertEquals(e150, e3);
        assertEquals("[(Abby, 100), (Bob, 200), (Alice, 50)]", board.toString());
        
        GameEntry e0 = board.remove(0);
        assertEquals(e100, e0);
        assertEquals("[(Bob, 200), (Alice, 50)]", board.toString());
        
        GameEntry e1 = board.remove(1);
        assertEquals(e050, e1);
        assertEquals("[(Bob, 200)]", board.toString());
        
        e0 = board.remove(0);
        assertEquals(e200, e0);
        assertEquals("[]", board.toString());
    }

}
