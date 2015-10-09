package ru.dendevjv.dsalgjavamg.ch03fundamental.p1tictactoe;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TicTacToeTest {
    private TicTacToe ttt;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        ttt = new TicTacToe();
    }

    @Test
    public void testPutMark() {
        ttt.putMark(0, 2);
        String s = ttt.toString();
        String expected =   " | |X\n" + 
                            "-----\n" + 
                            " | | \n" + 
                            "-----\n" + 
                            " | | ";
        assertEquals(expected, s);
        
        ttt.putMark(2, 0);
        s = ttt.toString();
        expected =  " | |X\n" + 
                    "-----\n" + 
                    " | | \n" + 
                    "-----\n" + 
                    "O| | ";
        assertEquals(expected, s);
    }

    @Test
    public void testIsWinX() {
        ttt.putMark(0, 0);
        ttt.putMark(1, 0);
        ttt.putMark(0, 1);
        ttt.putMark(1, 1);
        ttt.putMark(0, 2);
        ttt.putMark(2, 0);
        assertTrue(ttt.isWin(TicTacToe.X));
    }
    
    @Test
    public void testIsWinO() {
        ttt.putMark(0, 0);
        ttt.putMark(0, 2);
        ttt.putMark(0, 1);
        ttt.putMark(1, 1);
        ttt.putMark(2, 2);
        ttt.putMark(2, 0);
        assertTrue(ttt.isWin(TicTacToe.O));
    }

    @Test
    public void testWinner() {
        assertEquals(0, ttt.winner());
        ttt.putMark(0, 0);
        ttt.putMark(1, 0);
        ttt.putMark(0, 1);
        ttt.putMark(1, 1);
        ttt.putMark(2, 1);
        ttt.putMark(2, 0);
        assertEquals(0, ttt.winner());
    }

    @Test
    public void testToString() {
        String s = ttt.toString();
        String expected =   " | | \n" + 
                            "-----\n" + 
                            " | | \n" + 
                            "-----\n" + 
                            " | | ";
        assertEquals(expected, s);
    }

}
