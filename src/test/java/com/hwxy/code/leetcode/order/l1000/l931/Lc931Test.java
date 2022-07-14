package com.hwxy.code.leetcode.order.l1000.l931;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.hwxy.code.utils.JsonUtil;

public class Lc931Test {

    @Test
    public void minFallingPathSum() {
        Lc931 lc931 = new Lc931();
        assertEquals(13, lc931.minFallingPathSum(
                JsonUtil.convertToT("[[2,1,3],[6,5,4],[7,8,9]]", int[][].class)));
        assertEquals(-59, lc931.minFallingPathSum(
                JsonUtil.convertToT("[[-19,57],[-40,-5]]", int[][].class)));
    }
}
