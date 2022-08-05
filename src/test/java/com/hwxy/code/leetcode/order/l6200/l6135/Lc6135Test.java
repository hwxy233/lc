package com.hwxy.code.leetcode.order.l6200.l6135;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.hwxy.code.utils.JsonUtil;

public class Lc6135Test {

    @Test
    public void longestCycle() {
        Lc6135 lc6135 = new Lc6135();
        assertEquals(3, lc6135.longestCycle(JsonUtil.convertToIntArray("[3,3,4,2,3]")));
        assertEquals(-1, lc6135.longestCycle(JsonUtil.convertToIntArray("[2,-1,3,1]")));
    }
}
