package com.hwxy.code.leetcode.order.l1300.l1289;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.hwxy.code.utils.JsonUtil;

public class Lc1289Test {

    @Test
    public void minFallingPathSum() {
        Lc1289 lc1289 = new Lc1289();
        assertEquals(13, lc1289.minFallingPathSum(
                JsonUtil.convertToT("[[1,2,3],[4,5,6],[7,8,9]]", int[][].class)));
        assertEquals(-192, lc1289.minFallingPathSum(
                JsonUtil.convertToT(
                        "[[-73,61,43,-48,-36],[3,30,27,57,10],[96,-76,84,59,-15],[5,-49,76,31,-7],[97,91,61,-46,67]]",
                        int[][].class)));
    }
}
