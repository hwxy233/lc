package com.hwxy.code.leetcode.order.l100.l3;

import org.junit.Test;

import static org.junit.Assert.*;

public class Lc3NcTest {

    @Test
    public void lengthOfLongestSubstring() {
        Lc3Nc lc3Nc = new Lc3Nc();
        assertEquals(3, lc3Nc.lengthOfLongestSubstring("abcabcbb"));
        assertEquals(1, lc3Nc.lengthOfLongestSubstring("bbbb"));
        assertEquals(3, lc3Nc.lengthOfLongestSubstring("pwwkew"));
    }
}