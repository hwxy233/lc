package com.hwxy.code.leetcode.order.l600.l567;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Lc567Test {

    @Test
    public void checkInclusion() {
        Lc567 lc567 = new Lc567();
        assertTrue(lc567.checkInclusion("ab", "eidbaooo"));
        assertFalse(lc567.checkInclusion("ab", "eidboaoo"));
    }
}
