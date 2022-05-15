package com.hwxy.code.leetcode.interview.i100.i5;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class In5Test {

    @Test
    public void oneEditAway() {
        In5 in5 = new In5();
        assertFalse(in5.oneEditAway("teacher", "bleacher"));
        assertTrue(in5.oneEditAway("a", "b"));
        assertFalse(in5.oneEditAway("ab", "bc"));
        assertTrue(in5.oneEditAway("pale", "ple"));
        assertFalse(in5.oneEditAway("pales", "pal"));
    }
}
