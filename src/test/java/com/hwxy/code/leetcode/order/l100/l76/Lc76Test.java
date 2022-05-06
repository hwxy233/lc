package com.hwxy.code.leetcode.order.l100.l76;

import org.junit.Test;

import static org.junit.Assert.*;

public class Lc76Test {

    @Test
    public void minWindow() {
        Lc76 lc76 = new Lc76();
        assertEquals("BANC", lc76.minWindow("ADOBECODEBANC", "ABC"));
        assertEquals("a", lc76.minWindow("a", "a"));
        assertEquals("", lc76.minWindow("a", "aa"));
    }
}
