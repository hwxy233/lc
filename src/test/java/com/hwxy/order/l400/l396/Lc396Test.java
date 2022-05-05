package com.hwxy.order.l400.l396;

import com.hwxy.code.leetcode.order.l400.l396.Lc396;
import org.junit.Test;

import static org.junit.Assert.*;

public class Lc396Test {

    @Test
    public void maxRotateFunction() {
        Lc396 lc396 = new Lc396();
        assertEquals(26, lc396.maxRotateFunction(new int[] {4, 3, 2, 6}));
        assertEquals(0, lc396.maxRotateFunction(new int[] {100}));
    }
}
