package com.hwxy.code.leetcode.order.l800.l730;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Lc730Test {

    @Test
    public void countPalindromicSubsequences() {
        Lc730 lc730 = new Lc730();
        assertEquals(6, lc730.countPalindromicSubsequences("bccb"));
        assertEquals(104860361, lc730.countPalindromicSubsequences(
                "abcdabcdabcdabcdabcdabcdabcdabcddcbadcbadcbadcbadcbadcbadcbadcba"));
    }
}
