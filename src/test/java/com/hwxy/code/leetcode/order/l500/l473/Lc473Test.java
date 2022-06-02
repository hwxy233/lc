package com.hwxy.code.leetcode.order.l500.l473;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Lc473Test {

    @Test
    public void makesquare() {
        Lc473 lc473 = new Lc473();
        assertTrue(lc473.makesquare(new int[] {5, 5, 5, 5, 4, 4, 4, 4, 3, 3, 3, 3}));
        assertTrue(lc473.makesquare(new int[] {4, 1, 1, 1, 1, 3, 1, 2, 1, 1}));
        assertFalse(lc473.makesquare(new int[] {4, 1, 1, 1, 1, 3, 1, 2, 1, 1, 1}));
        assertTrue(lc473.makesquare(new int[] {1, 1, 2, 2, 2}));
        assertFalse(lc473.makesquare(new int[] {3, 3, 3, 3, 4}));
    }
}
