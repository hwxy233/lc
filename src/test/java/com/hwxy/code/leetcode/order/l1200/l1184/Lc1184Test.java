package com.hwxy.code.leetcode.order.l1200.l1184;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.hwxy.code.utils.JsonUtil;

public class Lc1184Test {

    @Test
    public void distanceBetweenBusStops() {
        Lc1184 lc1184 = new Lc1184();
        assertEquals(3,
                lc1184.distanceBetweenBusStops(JsonUtil.convertToIntArray("[1,2,3,4]"), 0, 2));
        assertEquals(4,
                lc1184.distanceBetweenBusStops(JsonUtil.convertToIntArray("[1,2,3,4]"), 0, 3));
    }
}
