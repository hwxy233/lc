package com.hwxy.code.leetcode.order.l400.l378;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.hwxy.code.utils.JsonUtil;

public class Lc378Test {

    @Test
    public void kthSmallest() {
        Lc378 lc378 = new Lc378();
        assertEquals(13, lc378.kthSmallest(
                JsonUtil.convertToT("[[1,5,9],[10,11,13],[12,13,15]]", int[][].class), 8));
    }
}
