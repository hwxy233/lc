package com.hwxy.code.leetcode.order.l2300.l2226;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Lc2226Test {

    @Test
    public void maximumCandies() {
        Lc2226 lc2226 = new Lc2226();
        assertEquals(5, lc2226.maximumCandies(new int[] {5, 8, 6}, 3));
        assertEquals(0, lc2226.maximumCandies(new int[] {2, 5}, 11));
    }
}
