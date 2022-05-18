package com.hwxy.code.leetcode.order.l700.l668;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Lc668Test {

    @Test
    public void findKthNumber() {
        Lc668 lc668 = new Lc668();
        assertEquals(3, lc668.findKthNumber(3, 3, 5));
        assertEquals(6, lc668.findKthNumber(2, 3, 6));
    }
}
