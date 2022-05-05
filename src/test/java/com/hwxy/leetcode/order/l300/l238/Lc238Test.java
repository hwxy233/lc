package com.hwxy.leetcode.order.l300.l238;

import com.hwxy.code.leetcode.order.l300.l238.Lc238;
import com.hwxy.code.utils.JsonUtil;
import org.junit.Test;

import static org.junit.Assert.*;

public class Lc238Test {

    @Test
    public void productExceptSelf() {
        Lc238 lc238 = new Lc238();
        assertArrayEquals(JsonUtil.convertToT("[24,12,8,6]", int[].class),
                lc238.productExceptSelf(JsonUtil.convertToT("[1,2,3,4]", int[].class)));
    }
}
