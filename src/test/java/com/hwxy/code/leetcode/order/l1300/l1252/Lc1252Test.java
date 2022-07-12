package com.hwxy.code.leetcode.order.l1300.l1252;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.hwxy.code.utils.JsonUtil;

public class Lc1252Test {

    @Test
    public void oddCells() {
        Lc1252 lc1252 = new Lc1252();
        assertEquals(6, lc1252.oddCells(2, 3, JsonUtil.convertToT("[[0,1],[1,1]]", int[][].class)));
        assertEquals(0, lc1252.oddCells(2, 2, JsonUtil.convertToT("[[1,1],[0,0]]", int[][].class)));
    }
}
