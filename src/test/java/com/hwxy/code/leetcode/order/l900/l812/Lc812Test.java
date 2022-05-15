package com.hwxy.code.leetcode.order.l900.l812;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.hwxy.code.utils.JsonUtil;

public class Lc812Test {

    @Test
    public void largestTriangleArea() {
        Lc812 lc812 = new Lc812();
        assertEquals(2, lc812.largestTriangleArea(
                JsonUtil.convertToT("[[0,0],[0,1],[1,0],[0,2],[2,0]]", int[][].class)), 0D);
    }
}
