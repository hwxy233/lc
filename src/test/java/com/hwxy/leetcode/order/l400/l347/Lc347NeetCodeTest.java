package com.hwxy.leetcode.order.l400.l347;

import com.hwxy.code.leetcode.order.l400.l347.Lc347NeetCode;
import com.hwxy.utils.JsonUtil;
import org.junit.Test;

import static org.junit.Assert.*;

public class Lc347NeetCodeTest {

    @Test
    public void topKFrequent() {
        Lc347NeetCode lc347NeetCode = new Lc347NeetCode();
        assertArrayEquals(JsonUtil.convertToT("[1,2]", int[].class),
                lc347NeetCode.topKFrequent(JsonUtil.convertToT("[1,1,1,2,2,3]", int[].class), 2));
    }
}
