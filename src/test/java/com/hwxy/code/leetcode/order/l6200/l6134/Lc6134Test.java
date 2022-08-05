package com.hwxy.code.leetcode.order.l6200.l6134;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.hwxy.code.utils.JsonUtil;

public class Lc6134Test {

    @Test
    public void closestMeetingNode() {
        Lc6134 lc6134 = new Lc6134();
        assertEquals(2, lc6134.closestMeetingNode(JsonUtil.convertToIntArray("[2,2,3,-1]"), 0, 1));
        assertEquals(2, lc6134.closestMeetingNode(JsonUtil.convertToIntArray("[1,2,-1]"), 0, 2));
        assertEquals(0, lc6134.closestMeetingNode(JsonUtil.convertToIntArray("[1,2,0]"), 0, 2));
    }
}
