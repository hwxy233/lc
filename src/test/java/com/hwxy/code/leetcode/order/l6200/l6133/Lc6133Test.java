package com.hwxy.code.leetcode.order.l6200.l6133;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.hwxy.code.utils.JsonUtil;

public class Lc6133Test {

    @Test
    public void maximumGroups() {
        Lc6133 lc6133 = new Lc6133();
        assertEquals(3, lc6133.maximumGroups(JsonUtil.convertToIntArray("[10,6,12,7,3,5]")));
        assertEquals(1, lc6133.maximumGroups(JsonUtil.convertToIntArray("[8,8]")));
        assertEquals(1, lc6133.maximumGroups(JsonUtil.convertToIntArray("[8]")));
    }
}
