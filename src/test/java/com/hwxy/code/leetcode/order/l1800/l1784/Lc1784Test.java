package com.hwxy.code.leetcode.order.l1800.l1784;

import org.junit.Test;

import static org.junit.Assert.*;

public class Lc1784Test {

    @Test
    public void checkOnesSegment() {
        Lc1784 lc1784 = new Lc1784();
        assertTrue(lc1784.checkOnesSegment("110"));
        assertFalse(lc1784.checkOnesSegment("110011"));
    }
}