package com.hwxy.code.leetcode.order.l1700.l1668;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Lc1668Test {

    @Test
    public void maxRepeating() {
        Lc1668 lc1668 = new Lc1668();
        assertEquals(5, lc1668.maxRepeating("aaabaaaabaaabaaaabaaaabaaaabaaaaba", "aaaba"));
    }
}