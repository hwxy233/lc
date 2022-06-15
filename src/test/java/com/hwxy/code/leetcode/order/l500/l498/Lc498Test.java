package com.hwxy.code.leetcode.order.l500.l498;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import com.hwxy.code.utils.JsonUtil;

public class Lc498Test {

    @Test
    public void findDiagonalOrder() {
        Lc498 lc498 = new Lc498();
        assertArrayEquals(JsonUtil.convertToT("[1,2,4,7,5,3,6,8,9]", int[].class),
                lc498.findDiagonalOrder(
                        JsonUtil.convertToT("[[1,2,3],[4,5,6],[7,8,9]]", int[][].class)));
        assertArrayEquals(JsonUtil.convertToT("[1,2,3,4]", int[].class),
                lc498.findDiagonalOrder(
                        JsonUtil.convertToT("[[1,2],[3,4]]", int[][].class)));
        assertArrayEquals(JsonUtil.convertToT("[2,5,8,0,4,-1]", int[].class),
                lc498.findDiagonalOrder(
                        JsonUtil.convertToT("[[2,5],[8,4],[0,-1]]", int[][].class)));
    }
}
