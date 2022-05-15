package com.hwxy.code.leetcode.order.l6100.l6065;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.hwxy.code.utils.JsonUtil;

public class Lc6065Test {

    @Test
    public void largestCombination() {
        Lc6065 lc6065 = new Lc6065();
        assertEquals(4, lc6065
                .largestCombination(JsonUtil.convertToT("[16,17,71,62,12,24,14]", int[].class)));
        assertEquals(2, lc6065
                .largestCombination(JsonUtil.convertToT("[8,8]", int[].class)));

        System.out.println(lc6065.largestCombination(
                JsonUtil.convertToT("[16,16,48,71,62,12,24,14,17,18,19,20,10000]", int[].class)));
    }
}
