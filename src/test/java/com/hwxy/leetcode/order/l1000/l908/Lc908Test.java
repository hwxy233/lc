package com.hwxy.leetcode.order.l1000.l908;

import com.hwxy.code.leetcode.order.l1000.l908.Lc908;
import com.hwxy.code.utils.JsonUtil;
import org.junit.Test;

import static org.junit.Assert.*;

public class Lc908Test {

    @Test
    public void smallestRangeI() {
        Lc908 lc908 = new Lc908();
        assertEquals(6, lc908.smallestRangeI(JsonUtil.convertToT("[0,10]", int[].class), 2));
        assertEquals(0, lc908.smallestRangeI(JsonUtil.convertToT("[1,3,6]", int[].class), 3));
        assertEquals(0, lc908.smallestRangeI(JsonUtil.convertToT("[4,7,4]", int[].class), 4));
        assertEquals(1, lc908.smallestRangeI(JsonUtil.convertToT("[3,1,10]", int[].class), 4));
    }
}
