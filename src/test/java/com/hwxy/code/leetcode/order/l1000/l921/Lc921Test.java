package com.hwxy.code.leetcode.order.l1000.l921;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Lc921Test {

    @Test
    public void minAddToMakeValid() {
        Lc921 lc921 = new Lc921();
        assertEquals(1, lc921.minAddToMakeValid("())"));
        assertEquals(3, lc921.minAddToMakeValid("((("));
    }
}