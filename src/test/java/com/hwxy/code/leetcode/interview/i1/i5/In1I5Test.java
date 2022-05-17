package com.hwxy.code.leetcode.interview.i1.i5;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class In1I5Test {

    @Test
    public void oneEditAway() {
        In1I5 in1I5 = new In1I5();
        assertFalse(in1I5.oneEditAway("teacher", "bleacher"));
        assertTrue(in1I5.oneEditAway("a", "b"));
        assertFalse(in1I5.oneEditAway("ab", "bc"));
        assertTrue(in1I5.oneEditAway("pale", "ple"));
        assertFalse(in1I5.oneEditAway("pales", "pal"));
    }
}
