package com.hwxy.code.leetcode.order.l1700.l1624;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Lc1624Test {

    @Test
    public void maxLengthBetweenEqualCharacters() {
        Lc1624 lc1624 = new Lc1624();
        assertEquals(0, lc1624.maxLengthBetweenEqualCharacters("aa"));
        assertEquals(2, lc1624.maxLengthBetweenEqualCharacters("abca"));
        assertEquals(-1, lc1624.maxLengthBetweenEqualCharacters("cbzxy"));
        assertEquals(4, lc1624.maxLengthBetweenEqualCharacters("cabbac"));
    }
}
