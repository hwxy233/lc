package com.hwxy.leetcode.order.l900.l868;

import com.hwxy.code.leetcode.order.l900.l868.Lc868;
import org.junit.Test;

import static org.junit.Assert.*;

public class Lc868Test {

    @Test
    public void binaryGap() {
        Lc868 lc868 = new Lc868();
        assertEquals(2, lc868.binaryGap(22));
        assertEquals(0, lc868.binaryGap(8));
        assertEquals(2, lc868.binaryGap(5));
    }
}
