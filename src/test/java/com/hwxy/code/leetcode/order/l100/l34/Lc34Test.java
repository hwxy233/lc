package com.hwxy.code.leetcode.order.l100.l34;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class Lc34Test {

    @Test
    public void searchRange() {
        Lc34 lc34 = new Lc34();
        assertArrayEquals(new int[] {3, 4}, lc34.searchRange(new int[] {5, 7, 7, 8, 8, 10}, 8));
        assertArrayEquals(new int[] {-1, -1}, lc34.searchRange(new int[] {5, 7, 7, 8, 8, 10}, 6));
        assertArrayEquals(new int[] {0, 1}, lc34.searchRange(new int[] {3, 3}, 3));
        assertArrayEquals(new int[] {-1, -1}, lc34.searchRange(new int[] {3, 3}, 2));
    }
}
