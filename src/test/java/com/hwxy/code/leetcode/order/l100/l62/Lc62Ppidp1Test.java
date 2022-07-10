package com.hwxy.code.leetcode.order.l100.l62;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.hwxy.code.utils.JsonUtil;

public class Lc62Ppidp1Test {

    @Test
    public void uniquePathsWithObstacles() {
        Lc62Ppidp1 lc62Ppidp1 = new Lc62Ppidp1();
        assertEquals(0,
                lc62Ppidp1.uniquePathsWithObstacles(
                        JsonUtil.convertToT("[[0,0],[1,1],[0,0]]", int[][].class)));
    }
}
