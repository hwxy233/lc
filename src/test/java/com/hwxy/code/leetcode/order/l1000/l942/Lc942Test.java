package com.hwxy.code.leetcode.order.l1000.l942;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import com.hwxy.code.utils.JsonUtil;

public class Lc942Test {

    @Test
    public void diStringMatch() {
        Lc942 lc942 = new Lc942();
        assertArrayEquals(JsonUtil.convertToT("[0,4,1,3,2]", int[].class),
                lc942.diStringMatch("IDID"));
        assertArrayEquals(JsonUtil.convertToT("[0,1,2,3]", int[].class),
                lc942.diStringMatch("III"));
        assertArrayEquals(JsonUtil.convertToT("[3,2,0,1]", int[].class),
                lc942.diStringMatch("DDI"));
    }
}
