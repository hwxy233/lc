package com.hwxy.code.leetcode.order.l800.l735;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import com.hwxy.code.utils.JsonUtil;

public class Lc735Test {

    @Test
    public void asteroidCollision() {
        Lc735 lc735 = new Lc735();
        assertArrayEquals(JsonUtil.convertToT("[5,10]", int[].class),
                lc735.asteroidCollision(JsonUtil.convertToT("[5,10,-5]", int[].class)));
        assertArrayEquals(JsonUtil.convertToT("[]", int[].class),
                lc735.asteroidCollision(JsonUtil.convertToT("[5,-5]", int[].class)));
        assertArrayEquals(JsonUtil.convertToT("[10]", int[].class),
                lc735.asteroidCollision(JsonUtil.convertToT("[10,2,-5]", int[].class)));
    }
}
