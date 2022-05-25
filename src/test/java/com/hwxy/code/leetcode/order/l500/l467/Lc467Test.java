package com.hwxy.code.leetcode.order.l500.l467;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Lc467Test {

    @Test
    public void findSubstringInWraproundString() {
        Lc467 lc467 = new Lc467();
        assertEquals(6, lc467.findSubstringInWraproundString("zab"));
        assertEquals(2, lc467.findSubstringInWraproundString("cac"));
        assertEquals(1, lc467.findSubstringInWraproundString("a"));
    }
}
