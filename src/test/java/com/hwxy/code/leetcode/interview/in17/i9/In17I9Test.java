package com.hwxy.code.leetcode.interview.in17.i9;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class In17I9Test {

    @Test
    public void getKthMagicNumber() {
        In17I9 in17I9 = new In17I9();
        assertEquals(9, in17I9.getKthMagicNumber(5));
        assertEquals(1937102445, in17I9.getKthMagicNumber(643));
    }
}