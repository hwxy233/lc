package com.hwxy.code.leetcode.order.l200.l120;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.hwxy.code.utils.JsonUtil;

public class Lc120Test {

    @Test
    public void minimumTotal() {
        Lc120 lc120 = new Lc120();
        assertEquals(11, lc120.minimumTotal(JsonUtil.convertToT("[[2],[3,4],[6,5,7],[4,1,8,3]]")));
    }
}
