package com.hwxy.leetcode.order.l300.l217;

import com.hwxy.utils.JsonUtil;
import org.junit.Test;

import static org.junit.Assert.*;

public class Lc217Test {

    @Test
    public void containsDuplicate() {
        Lc217 lc217 = new Lc217();
        assertTrue(lc217.containsDuplicate(JsonUtil.convertToT("[1,2,3,1]", int[].class)));
        assertFalse(lc217.containsDuplicate(JsonUtil.convertToT("[1,2,3,4]", int[].class)));
        assertTrue(
                lc217.containsDuplicate(JsonUtil.convertToT("[1,1,1,3,3,4,3,2,4,2]", int[].class)));
    }
}
