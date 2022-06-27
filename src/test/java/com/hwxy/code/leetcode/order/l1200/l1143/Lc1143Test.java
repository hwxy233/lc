package com.hwxy.code.leetcode.order.l1200.l1143;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Lc1143Test {

    @Test
    public void longestCommonSubsequence() {
        Lc1143 lc1143 = new Lc1143();
        assertEquals(3, lc1143.longestCommonSubsequence("abcde", "ace"));
        assertEquals(3, lc1143.longestCommonSubsequence("abc", "abc"));
        assertEquals(0, lc1143.longestCommonSubsequence("abc", "dsf"));
    }
}
