package com.hwxy.code.leetcode.order.l500.l436;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import com.hwxy.code.utils.JsonUtil;

public class Lc436Test {

    @Test
    public void findRightInterval() {
        Lc436 lc436 = new Lc436();
        assertArrayEquals(new int[] {-1, 0, 1},
                lc436.findRightInterval(JsonUtil.convertToT("[[3,4],[2,3],[1,2]]", int[][].class)));
        assertArrayEquals(new int[] {-1, 2, -1},
                lc436.findRightInterval(JsonUtil.convertToT("[[1,4],[2,3],[3,4]]", int[][].class)));
        assertArrayEquals(new int[] {-1, 0, 1},
                lc436.findRightInterval(JsonUtil.convertToT("[[4,5],[2,3],[1,2]]", int[][].class)));
    }
}
