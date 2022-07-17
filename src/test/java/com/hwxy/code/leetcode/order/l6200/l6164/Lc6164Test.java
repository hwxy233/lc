package com.hwxy.code.leetcode.order.l6200.l6164;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.hwxy.code.utils.JsonUtil;

public class Lc6164Test {

    @Test
    public void maximumSum() {
        Lc6164 lc6164 = new Lc6164();
        assertEquals(54, lc6164.maximumSum(JsonUtil.convertToT("[18,43,36,13,7]", int[].class)));
        assertEquals(86, lc6164.maximumSum(JsonUtil.convertToT("[18,43,43,13,7]", int[].class)));
        assertEquals(-1, lc6164.maximumSum(JsonUtil.convertToT("[10,12,19,14]", int[].class)));
    }
}
