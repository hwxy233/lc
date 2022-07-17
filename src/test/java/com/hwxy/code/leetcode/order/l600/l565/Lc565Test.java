package com.hwxy.code.leetcode.order.l600.l565;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.hwxy.code.utils.JsonUtil;

public class Lc565Test {

    @Test
    public void arrayNesting() {
        Lc565 lc565 = new Lc565();
        assertEquals(4, lc565.arrayNesting(JsonUtil.convertToT("[5,4,0,3,1,6,2]", int[].class)));
    }
}
