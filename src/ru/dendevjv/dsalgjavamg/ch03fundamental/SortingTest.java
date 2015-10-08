package ru.dendevjv.dsalgjavamg.ch03fundamental;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class SortingTest {
    
    @Test
    public void testInsertionSort() {
        char[] a1 = {'e', 'c', 'g', 'b', 'f', 'a', 'd'};
        Sorting.insertionSort(a1);
        char[] a2 = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
        assertTrue(Arrays.equals(a1, a2));
    }
    
    @Test
    public void testInsertionSortReversed() {
        char[] a1 = {'g', 'f', 'e', 'd', 'c', 'b', 'a'};
        Sorting.insertionSort(a1);
        char[] a2 = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
        assertTrue(Arrays.equals(a1, a2));
    }

}
