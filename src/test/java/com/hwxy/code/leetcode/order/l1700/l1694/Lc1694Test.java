package com.hwxy.code.leetcode.order.l1700.l1694;

import org.junit.Test;

import static org.junit.Assert.*;

public class Lc1694Test {

    @Test
    public void reformatNumber() {
        Lc1694 lc1694 = new Lc1694();
        assertEquals("123-456", lc1694.reformatNumber("1-23-45 6"));
        assertEquals("123-45-67", lc1694.reformatNumber("123 4-567"));
        assertEquals("123-45-67", lc1694.reformatNumber("123 4-567"));
        assertEquals("123-456-78", lc1694.reformatNumber("123 4-5678"));
        assertEquals("12", lc1694.reformatNumber("12"));
    }
}