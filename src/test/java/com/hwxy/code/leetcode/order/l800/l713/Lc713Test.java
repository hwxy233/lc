package com.hwxy.code.leetcode.order.l800.l713;

import com.hwxy.code.utils.JsonUtil;
import org.junit.Test;

import static org.junit.Assert.*;

public class Lc713Test {

    @Test
    public void numSubarrayProductLessThanK() {
        Lc713 lc713 = new Lc713();
        assertEquals(8, lc713
                .numSubarrayProductLessThanK(JsonUtil.convertToT("[10,5,2,6]", int[].class), 100));
    }
}
