package com.hwxy.code.leetcode.order.l6200.l6125;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.hwxy.code.utils.JsonUtil;

public class Lc6125Test {

    @Test
    public void equalPairs() {
        Lc6125 lc6125 = new Lc6125();
        assertEquals(1,
                lc6125.equalPairs(JsonUtil.convertTo2DIntArray("[[3,2,1],[1,7,6],[2,7,7]]")));
        assertEquals(3,
                lc6125.equalPairs(JsonUtil.convertTo2DIntArray("[[3,1,2,2],[1,4,4,5],[2,4,2,2],[2,4,2,2]]")));
    }
}
