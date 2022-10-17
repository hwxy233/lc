package com.hwxy.code.leetcode.order.l1000.l904;

import com.hwxy.code.utils.JsonUtil;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Lc904Test {

    @Test
    public void totalFruit() {
        Lc904 lc904 = new Lc904();
        assertEquals(3, lc904.totalFruit(JsonUtil.convertToIntArray("[1,2,1]")));
        assertEquals(3, lc904.totalFruit(JsonUtil.convertToIntArray("[0,1,2,2]")));
        assertEquals(4, lc904.totalFruit(JsonUtil.convertToIntArray("[1,2,3,2,2]")));
        assertEquals(5, lc904.totalFruit(JsonUtil.convertToIntArray("[3,3,3,1,2,1,1,2,3,3,4]")));
        assertEquals(5, lc904.totalFruit(JsonUtil.convertToIntArray("[1,0,1,4,1,4,1,2,3]")));
    }
}