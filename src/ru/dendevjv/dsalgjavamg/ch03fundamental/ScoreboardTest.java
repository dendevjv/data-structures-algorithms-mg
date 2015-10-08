package ru.dendevjv.dsalgjavamg.ch03fundamental;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ScoreboardTest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }
    
    @Test
    public void testGetTop() {
        Scoreboard board = new Scoreboard(3);
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
        assertEquals(entry2, top);
        
        GameEntry entry3 = new GameEntry("Alice", 50);
        board.add(entry3);
        top = board.getTop();
        assertEquals(entry2, top);
        
        GameEntry entry4 = new GameEntry("Karen", 350);
        board.add(entry4);
        top = board.getTop();
        assertEquals(entry4, top);
    }

    @Test
    public void testAdd() {
        Scoreboard board = new Scoreboard(3);
        
        GameEntry  e100 = new GameEntry("Abby", 100);
        board.add(e100);
        assertEquals(e100, board.get(0));
        
        GameEntry e200 = new GameEntry("Bob", 200);
        board.add(e200);
        assertEquals(e200, board.get(0));
        assertEquals(e100, board.get(1));
        
        GameEntry e050 = new GameEntry("Alice", 50);
        board.add(e050);
        assertEquals(e200, board.get(0));
        assertEquals(e100, board.get(1));
        assertEquals(e050, board.get(2));
        
        GameEntry e150 = new GameEntry("Karen", 150);
        board.add(e150);
        assertEquals(e200, board.get(0));
        assertEquals(e150, board.get(1));
        assertEquals(e100, board.get(2));
    }
    
    @Test
    public void testRemove() {
        Scoreboard board = new Scoreboard(4);
        
        GameEntry e200 = new GameEntry("Bob", 200);
        board.add(e200);
        GameEntry e150 = new GameEntry("Karen", 150);
        board.add(e150);
        GameEntry  e100 = new GameEntry("Abby", 100);
        board.add(e100);
        GameEntry  e050 = new GameEntry("John", 50);
        board.add(e050);
        assertEquals(4, board.getSize());
        
        GameEntry removed;
        removed = board.remove(1);
        assertEquals(e200, board.get(0));
        assertEquals(e100, board.get(1));
        assertEquals(e050, board.get(2));
        assertEquals(3, board.getSize());
        assertEquals(e150, removed);
        
        removed = board.remove(2);
        assertEquals(e200, board.get(0));
        assertEquals(e100, board.get(1));
        assertEquals(2, board.getSize());
        assertEquals(e050, removed);
        
        removed = board.remove(0);
        assertEquals(e100, board.get(0));
        assertEquals(1, board.getSize());
        assertEquals(e200, removed);
        
        removed = board.remove(0);
        assertEquals(0, board.getSize());
        assertEquals(e100, removed);
    }

}
