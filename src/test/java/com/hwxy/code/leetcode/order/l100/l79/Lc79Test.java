package com.hwxy.code.leetcode.order.l100.l79;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Lc79Test {

    @Test
    public void exist() {
        Lc79 lc79 = new Lc79();
        assertFalse(lc79.exist(new char[][] {{'A', 'B'}, {'S', 'F'}}, "AF"));
        assertTrue(lc79.exist(new char[][] {{'A', 'B'}, {'S', 'F'}}, "SF"));
    }
}
