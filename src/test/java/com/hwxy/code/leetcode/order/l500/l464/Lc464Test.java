package com.hwxy.code.leetcode.order.l500.l464;

import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class Lc464Test {

    @Test
    public void canIWin() {
        Lc464 lc464 = new Lc464();
        // assertTrue(lc464.canIWin(9, 22));
        // assertTrue(lc464.canIWin(10, 0));
        // assertTrue(lc464.canIWin(10, 1));
        assertFalse(lc464.canIWin(10, 11));
        assertFalse(lc464.canIWin(10, 40));
    }
}
