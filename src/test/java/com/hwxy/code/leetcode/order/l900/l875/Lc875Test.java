package com.hwxy.code.leetcode.order.l900.l875;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Lc875Test {

    @Test
    public void minEatingSpeed() {
        Lc875 lc875 = new Lc875();
        assertEquals(4, lc875.minEatingSpeed(new int[] {3, 6, 7, 11}, 8));
        assertEquals(30, lc875.minEatingSpeed(new int[] {30, 11, 23, 4, 20}, 5));
        assertEquals(23, lc875.minEatingSpeed(new int[] {30, 11, 23, 4, 20}, 6));
    }
}
