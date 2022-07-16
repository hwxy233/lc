package com.hwxy.code.leetcode.order.l500.l438;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.hwxy.code.utils.JsonUtil;

public class Lc438NcTest {

    @Test
    public void findAnagrams() {
        Lc438Nc lc438Nc = new Lc438Nc();
        assertEquals(JsonUtil.convertToT("[1]"), lc438Nc.findAnagrams("baa", "aa"));
    }
}
