package com.hwxy.code.leetcode.order.l1800.l1800;

import com.hwxy.code.utils.JsonUtil;
import org.junit.Test;

import static org.junit.Assert.*;

public class Lc1800Test {

    @Test
    public void maxAscendingSum() {
        Lc1800 lc1800 = new Lc1800();
        assertEquals(65, lc1800.maxAscendingSum(JsonUtil.convertToIntArray("[10,20,30,5,10,50]")));
        assertEquals(150, lc1800.maxAscendingSum(JsonUtil.convertToIntArray("[10,20,30,40,50]")));
        assertEquals(150, lc1800.maxAscendingSum(JsonUtil.convertToIntArray("[10,20,30,40,50]")));
        assertEquals(33, lc1800.maxAscendingSum(JsonUtil.convertToIntArray("[12,17,15,13,10,11,12]")));
        assertEquals(100, lc1800.maxAscendingSum(JsonUtil.convertToIntArray("[100,10,1]")));
        assertEquals(101, lc1800.maxAscendingSum(JsonUtil.convertToIntArray("[10,1,100]")));
    }
}