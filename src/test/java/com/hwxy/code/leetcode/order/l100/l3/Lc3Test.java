package com.hwxy.code.leetcode.order.l100.l3;

import org.junit.Test;

import static org.junit.Assert.*;

public class Lc3Test {

    @Test
    public void lengthOfLongestSubstring() {
        Lc3 lc3 = new Lc3();
        assertEquals(3, lc3.lengthOfLongestSubstring("abcabcbb"));
        assertEquals(3, lc3.lengthOfLongestSubstring("pwwkew"));
        assertEquals(1, lc3.lengthOfLongestSubstring("bbbbb"));
    }
}
