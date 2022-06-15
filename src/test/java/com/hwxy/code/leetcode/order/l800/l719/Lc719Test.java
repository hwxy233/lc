package com.hwxy.code.leetcode.order.l800.l719;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Lc719Test {

    @Test
    public void smallestDistancePair() {
        Lc719 lc719 = new Lc719();
        // assertEquals(0, lc719.smallestDistancePair(new int[] {1, 3, 1}, 1));
        // assertEquals(0, lc719.smallestDistancePair(new int[] {1, 1, 1}, 2));
        // assertEquals(5, lc719.smallestDistancePair(new int[] {1, 6, 1}, 3));
        assertEquals(9, lc719.smallestDistancePair(new int[] {1, 5, 9, 18}, 4));
        assertEquals(2, lc719.smallestDistancePair(new int[] {9, 10, 7, 10, 6, 1, 5, 4, 9, 8},
                18));
    }
}
