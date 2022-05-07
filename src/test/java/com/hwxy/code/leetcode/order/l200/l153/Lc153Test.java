package com.hwxy.code.leetcode.order.l200.l153;

import com.hwxy.code.utils.JsonUtil;
import org.junit.Test;

import static org.junit.Assert.*;

public class Lc153Test {

    @Test
    public void findMin() {
        Lc153 lc153 = new Lc153();
        assertEquals(1, lc153.findMin(JsonUtil.convertToT("[2,1]", int[].class)));
        assertEquals(0, lc153.findMin(JsonUtil.convertToT("[4,5,6,7,0,1,2]", int[].class)));
        assertEquals(1, lc153.findMin(JsonUtil.convertToT("[3,4,5,1,2]", int[].class)));
        assertEquals(11, lc153.findMin(JsonUtil.convertToT("[11,13,15,17]", int[].class)));
    }
}
