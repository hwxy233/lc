package com.hwxy.code.leetcode.order.l1300.l1217;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.hwxy.code.utils.JsonUtil;

public class Lc1217Test {

    @Test
    public void minCostToMoveChips() {
        Lc1217 lc1217 = new Lc1217();
        assertEquals(2, lc1217.minCostToMoveChips(JsonUtil.convertToT("[2,2,2,3,3]", int[].class)));
    }
}
