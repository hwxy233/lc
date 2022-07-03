package com.hwxy.code.leetcode.order.l600.l556;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Lc556Test {

    @Test
    public void nextGreaterElement() {
        Lc556 lc556 = new Lc556();
        assertEquals(21, lc556.nextGreaterElement(12));
        assertEquals(-1, lc556.nextGreaterElement(21));
    }
}
