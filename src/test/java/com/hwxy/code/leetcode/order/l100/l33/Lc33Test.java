package com.hwxy.code.leetcode.order.l100.l33;

import com.hwxy.code.utils.JsonUtil;
import org.junit.Test;

import static org.junit.Assert.*;

public class Lc33Test {

    @Test
    public void search() {
        Lc33 lc33 = new Lc33();
        assertEquals(4, lc33.search(JsonUtil.convertToT("[4,5,6,7,0,1,2]", int[].class), 0));
        assertEquals(-1, lc33.search(JsonUtil.convertToT("[4,5,6,7,0,1,2]", int[].class), 3));
        assertEquals(-1, lc33.search(JsonUtil.convertToT("[1]", int[].class), 0));
    }
}
