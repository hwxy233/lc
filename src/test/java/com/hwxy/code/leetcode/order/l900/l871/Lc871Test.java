package com.hwxy.code.leetcode.order.l900.l871;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.hwxy.code.utils.JsonUtil;

public class Lc871Test {

    @Test
    public void minRefuelStops() {
        Lc871 lc871 = new Lc871();
        assertEquals(2, lc871.minRefuelStops(100, 10,
                JsonUtil.convertToT("[[10,60],[20,30],[30,30],[60,40]]", int[][].class)));
        assertEquals(-1, lc871.minRefuelStops(100, 1,
                JsonUtil.convertToT("[[10,100]]", int[][].class)));
        assertEquals(0, lc871.minRefuelStops(1, 1, null));
    }
}
