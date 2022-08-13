package com.hwxy.code.leetcode.order.l700.l636;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import com.hwxy.code.utils.JsonUtil;

public class Lc636Test {

    @Test
    public void exclusiveTime() {
        Lc636 lc636 = new Lc636();
        assertArrayEquals(JsonUtil.convertToIntArray("[8]"),
                lc636.exclusiveTime(1, JsonUtil.convertToT(
                        "[\"0:start:0\",\"0:start:2\",\"0:end:5\",\"0:start:6\",\"0:end:6\",\"0:end:7\"]")));
        assertArrayEquals(JsonUtil.convertToIntArray("[8,1]"),
                lc636.exclusiveTime(2, JsonUtil.convertToT(
                        "[\"0:start:0\",\"0:start:2\",\"0:end:5\",\"1:start:7\",\"1:end:7\",\"0:end:8\"]")));
    }
}
