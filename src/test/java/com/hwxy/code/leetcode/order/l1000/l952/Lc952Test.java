package com.hwxy.code.leetcode.order.l1000.l952;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.hwxy.code.utils.JsonUtil;

public class Lc952Test {

    @Test
    public void largestComponentSize() {
        Lc952 lc952 = new Lc952();
        assertEquals(4, lc952.largestComponentSize(JsonUtil.convertToIntArray("[4,6,15,35]")));
        assertEquals(2, lc952.largestComponentSize(JsonUtil.convertToIntArray("[20,50,9,63]")));
        assertEquals(8, lc952.largestComponentSize(JsonUtil.convertToIntArray("[2,3,6,7,4,12,21,39]")));
    }
}
