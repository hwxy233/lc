package com.hwxy.code.leetcode.order.l100.l73;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.hwxy.code.leetcode.order.l100.l76.Lc76R1;

public class Lc76R1Test {

    @Test
    public void minWindow() {
        Lc76R1 lc76R1 = new Lc76R1();
        assertEquals("BANC", lc76R1.minWindow("ADOBECODEBANC", "ABC"));
        assertEquals("a", lc76R1.minWindow("a", "a"));
        assertEquals("", lc76R1.minWindow("a", "aa"));
        assertEquals("cwae", lc76R1.minWindow("cabwefgewcwaefgcf", "cae"));
    }
}
