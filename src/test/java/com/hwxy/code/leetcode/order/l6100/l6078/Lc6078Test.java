package com.hwxy.code.leetcode.order.l6100.l6078;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Lc6078Test {

    @Test
    public void rearrangeCharacters() {
        Lc6078 lc6078 = new Lc6078();
        assertEquals(1, lc6078.rearrangeCharacters("abcba", "abc"));
        assertEquals(1, lc6078.rearrangeCharacters("abbaccaddaeea", "aaaaa"));
        assertEquals(2, lc6078.rearrangeCharacters("ilovecodingonleetcode", "code"));
    }
}
