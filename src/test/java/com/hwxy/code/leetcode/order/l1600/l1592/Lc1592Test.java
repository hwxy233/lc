package com.hwxy.code.leetcode.order.l1600.l1592;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Lc1592Test {

    @Test
    public void reorderSpaces() {
        Lc1592 lc1592 = new Lc1592();
        assertEquals("this   is   a   sentence", lc1592.reorderSpaces("  this   is  a sentence "));
    }
}
