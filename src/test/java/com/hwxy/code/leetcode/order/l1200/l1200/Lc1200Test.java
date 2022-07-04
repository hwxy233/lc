package com.hwxy.code.leetcode.order.l1200.l1200;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.hwxy.code.utils.JsonUtil;

public class Lc1200Test {

    @Test
    public void minimumAbsDifference() {
        Lc1200 lc1200 = new Lc1200();
        assertEquals(JsonUtil.convertToT("[[-14,-10],[19,23],[23,27]]"),
                lc1200.minimumAbsDifference(
                        JsonUtil.convertToT("[3,8,-10,23,19,-4,-14,27]", int[].class)));
    }
}
