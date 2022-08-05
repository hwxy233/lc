package com.hwxy.code.leetcode.order.l6200.l6132;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.hwxy.code.utils.JsonUtil;

public class Lc6132Test {

    @Test
    public void minimumOperations() {
        Lc6132 lc6132 = new Lc6132();
//        assertEquals(3, lc6132.minimumOperations(JsonUtil.convertToIntArray("[1,5,0,3,5]")));
//        assertEquals(0, lc6132.minimumOperations(JsonUtil.convertToIntArray("[0]")));
        assertEquals(1, lc6132.minimumOperations(JsonUtil.convertToIntArray("[1]")));
    }
}
