package com.hwxy.code.leetcode.order.l500.l462;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class Lc462Test {

    @Test
    public void minMoves2() {
        Lc462 lc462 = new Lc462();
        assertEquals(2, lc462.minMoves2(new int[] {1, 2, 3}));
        assertEquals(16, lc462.minMoves2(new int[] {1, 10, 2, 9}));
    }
}
