package com.hwxy.code.leetcode.order.l6100.l6064;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.hwxy.code.utils.JsonUtil;

public class Lc6064Test {

    @Test
    public void maxConsecutive() {
        Lc6064 lc6064 = new Lc6064();
        assertEquals(3, lc6064.maxConsecutive(2, 9, JsonUtil.convertToT("[4,6]", int[].class)));
        assertEquals(0, lc6064.maxConsecutive(6, 8, JsonUtil.convertToT("[7,6,8]", int[].class)));
        assertEquals(12,
                lc6064.maxConsecutive(28, 50, JsonUtil.convertToT("[35,48]", int[].class)));
    }
}
