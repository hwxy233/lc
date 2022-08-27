package com.hwxy.code.leetcode.order.l1500.l1422;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Lc1422Test {

    @Test
    public void maxScore() {
        Lc1422 lc1422 = new Lc1422();
        assertEquals(5, lc1422.maxScore("011101"));
        assertEquals(5, lc1422.maxScore("00111"));
        assertEquals(3, lc1422.maxScore("1111"));
    }
}
