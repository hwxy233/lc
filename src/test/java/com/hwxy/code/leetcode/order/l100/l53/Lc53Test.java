package com.hwxy.code.leetcode.order.l100.l53;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.hwxy.code.utils.JsonUtil;

public class Lc53Test {

    @Test
    public void maxSubArray() {
        Lc53 lc53 = new Lc53();
        assertEquals(6, lc53.maxSubArray(JsonUtil.convertToIntArray("[-2,1,-3,4,-1,2,1,-5,4]")));
        assertEquals(23, lc53.maxSubArray(JsonUtil.convertToIntArray("[5,4,-1,7,8]")));
        assertEquals(1, lc53.maxSubArray(JsonUtil.convertToIntArray("[1]")));
    }
}
