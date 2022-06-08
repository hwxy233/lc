package com.hwxy.code.leetcode.order.l1100.l1037;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.hwxy.code.utils.JsonUtil;

public class Lc1037Test {

    @Test
    public void isBoomerang() {
        Lc1037 lc1037 = new Lc1037();
        assertTrue(lc1037.isBoomerang(JsonUtil.convertToT("[[1,1],[2,3],[3,2]]", int[][].class)));
        assertFalse(lc1037.isBoomerang(JsonUtil.convertToT("[[1,1],[2,2],[3,3]]", int[][].class)));
    }
}
