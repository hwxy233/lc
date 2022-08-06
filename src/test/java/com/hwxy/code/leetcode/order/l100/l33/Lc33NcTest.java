package com.hwxy.code.leetcode.order.l100.l33;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.hwxy.code.utils.JsonUtil;

public class Lc33NcTest {

    @Test
    public void search() {
        Lc33Nc lc33Nc = new Lc33Nc();
        assertEquals(4, lc33Nc.search(JsonUtil.convertToIntArray("[4,5,6,7,0,1,2]"), 0));
        assertEquals(-1, lc33Nc.search(JsonUtil.convertToIntArray("[4,5,6,7,0,1,2]"), 3));
        assertEquals(-1, lc33Nc.search(JsonUtil.convertToIntArray("[0,1,2]"), 3));
        assertEquals(-1, lc33Nc.search(JsonUtil.convertToIntArray("[2,1,0]"), 3));
        assertEquals(-1, lc33Nc.search(JsonUtil.convertToIntArray("[2]"), 3));
    }
}
