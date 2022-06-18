package com.hwxy.code.leetcode.order.l600.l532;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Lc532Test {

    @Test
    public void findPairs() {
        Lc532 lc532 = new Lc532();
        assertEquals(2, lc532.findPairs(new int[] {3, 1, 4, 1, 5}, 2));
        assertEquals(4, lc532.findPairs(new int[] {1, 2, 3, 4, 5}, 1));
        assertEquals(1, lc532.findPairs(new int[] {1, 3, 1, 5, 4}, 0));
    }
}
