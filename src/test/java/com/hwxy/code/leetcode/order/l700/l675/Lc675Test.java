package com.hwxy.code.leetcode.order.l700.l675;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.hwxy.code.utils.JsonUtil;

public class Lc675Test {

    @Test
    public void cutOffTree() {
        Lc675 lc675 = new Lc675();
        assertEquals(6, lc675.cutOffTree(JsonUtil.convertToT("[[1,2,3],[0,0,4],[7,6,5]]",
                new TypeReference<>() {})));
    }
}
