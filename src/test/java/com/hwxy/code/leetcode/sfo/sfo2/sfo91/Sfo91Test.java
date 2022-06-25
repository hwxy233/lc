package com.hwxy.code.leetcode.sfo.sfo2.sfo91;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.hwxy.code.utils.JsonUtil;

public class Sfo91Test {

    @Test
    public void minCost() {
        Sfo91 sfo91 = new Sfo91();
        assertEquals(10, sfo91
                .minCost(JsonUtil.convertToT("[[17,2,17],[16,16,5],[14,3,19]]", int[][].class)));
        assertEquals(2, sfo91
                .minCost(JsonUtil.convertToT("[[7,6,2]]", int[][].class)));
    }
}
