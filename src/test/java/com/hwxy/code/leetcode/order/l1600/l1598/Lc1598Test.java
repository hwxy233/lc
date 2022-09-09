package com.hwxy.code.leetcode.order.l1600.l1598;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Lc1598Test {

    @Test
    public void minOperations() {
        Lc1598 lc1598 = new Lc1598();
        assertEquals(2, lc1598.minOperations(new String[] {"d1/", "d2/", "../", "d21/", "./"}));
        assertEquals(
                3, lc1598.minOperations(new String[] {"d1/", "d2/", "./", "d3/", "../", "d31/"}));
        assertEquals(0, lc1598.minOperations(new String[] {"d1/", "../", "../", "../"}));
    }
}
