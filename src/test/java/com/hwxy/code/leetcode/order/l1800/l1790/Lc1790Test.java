package com.hwxy.code.leetcode.order.l1800.l1790;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Lc1790Test {

    @Test
    public void areAlmostEqual() {
        Lc1790 lc1790 = new Lc1790();
        assertTrue(lc1790.areAlmostEqual("bank", "kanb"));
        assertFalse(lc1790.areAlmostEqual("attack", "defend"));
        assertTrue(lc1790.areAlmostEqual("kelb", "kelb"));
        assertFalse(lc1790.areAlmostEqual("banb", "kank"));
        assertFalse(lc1790.areAlmostEqual("aa", "ac"));
    }
}