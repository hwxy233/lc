package com.hwxy.code.leetcode.order.l200.l121;

import com.hwxy.code.utils.JsonUtil;
import org.junit.Test;

import static org.junit.Assert.*;

public class Lc121Test {

    @Test
    public void maxProfit() {
        Lc121 lc121 = new Lc121();
        assertEquals(5, lc121.maxProfit(JsonUtil.convertToT("[7,1,5,3,6,4]", int[].class)));
        assertEquals(5, lc121.maxProfit(JsonUtil.convertToT("[7,1,1,5,3,6,4]", int[].class)));
        assertEquals(0, lc121.maxProfit(JsonUtil.convertToT("[7,6,4,3,1]", int[].class)));
    }
}
