package com.hwxy.code.leetcode.order.l100.l63;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.hwxy.code.utils.JsonUtil;

public class Lc63PpidpTest {

    @Test
    public void uniquePathsWithObstacles() {
        Lc63Ppidp lc63Ppidp = new Lc63Ppidp();
        assertEquals(2, lc63Ppidp.uniquePathsWithObstacles(
                JsonUtil.convertToT("[[0,0,0],[0,1,0],[0,0,0]]", int[][].class)));
        assertEquals(1, lc63Ppidp.uniquePathsWithObstacles(
                JsonUtil.convertToT("[[0,1],[0,0]]", int[][].class)));
    }
}
