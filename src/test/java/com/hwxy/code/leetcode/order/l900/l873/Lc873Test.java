package com.hwxy.code.leetcode.order.l900.l873;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.hwxy.code.utils.JsonUtil;

public class Lc873Test {

    @Test
    public void lenLongestFibSubseq() {
        Lc873 lc873 = new Lc873();
        assertEquals(5,
                lc873.lenLongestFibSubseq(JsonUtil.convertToT("[1,2,3,4,5,6,7,8]", int[].class)));
        assertEquals(3,
                lc873.lenLongestFibSubseq(
                        JsonUtil.convertToT("[1,3,7,11,12,14,18]", int[].class)));
    }
}
