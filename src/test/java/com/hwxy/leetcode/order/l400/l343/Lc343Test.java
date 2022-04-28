package com.hwxy.leetcode.order.l400.l343;

import org.junit.Test;

import static org.junit.Assert.*;

public class Lc343Test {

    @Test
    public void integerBreak() {
        Lc343 lc343 = new Lc343();
        assertEquals(1, lc343.integerBreak(2));
        assertEquals(36, lc343.integerBreak(10));
    }
}
