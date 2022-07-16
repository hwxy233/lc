package com.hwxy.code.leetcode.order.l100.l76;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Lc76DongTest {

    @Test
    public void minWindow() {
        Lc76Dong lc76Dong = new Lc76Dong();
        assertEquals("BANC", lc76Dong.minWindow("ADOBECODEBANC", "ABC"));
        assertEquals("a", lc76Dong.minWindow("aa", "a"));
        assertEquals("", lc76Dong.minWindow("a", "aa"));
    }
}
