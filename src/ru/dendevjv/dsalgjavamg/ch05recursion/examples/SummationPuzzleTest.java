package ru.dendevjv.dsalgjavamg.ch05recursion.examples;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SummationPuzzleTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testSolvePuzzle1() {
        String p = "a + b = c";
        String e = "1 + 2 = 3";
        String a = SummationPuzzle.solvePuzzle(p);
        assertEquals(e, a);
    }
    
    @Test
    public void testSolvePuzzle2() {
        String p = "ab + cd = de";
        String e = "02 + 89 = 91";
        String a = SummationPuzzle.solvePuzzle(p);
        assertEquals(e, a);
    }
    
    @Test
    public void testSolvePuzzle3() {
        String p = "ab + efc = fgd";
        String e = "12 + 893 = 905";
        String a = SummationPuzzle.solvePuzzle(p);
        assertEquals(e, a);
    }
    
    @Test
    public void testSolvePuzzle4() {
        String p = "aba + bcc = cde";
        String e = "121 + 233 = 354";
        String a = SummationPuzzle.solvePuzzle(p);
        assertEquals(e, a);
    }
    
    @Test
    public void testSolvePuzzle5() {
        String p = "aba + baba = bbcb";
        String e = "121 + 2121 = 2242";
        String a = SummationPuzzle.solvePuzzle(p);
        assertEquals(e, a);
    }

}
