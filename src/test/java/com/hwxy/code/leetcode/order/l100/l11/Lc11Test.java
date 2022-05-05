package com.hwxy.code.leetcode.order.l100.l11;

import com.hwxy.code.utils.JsonUtil;
import org.junit.Test;
import static org.junit.Assert.*;

public class Lc11Test {

    @Test
    public void maxArea() {
        Lc11 lc11 = new Lc11();
        assertEquals(49, lc11.maxArea(JsonUtil.convertToT("[1,8,6,2,5,4,8,3,7]", int[].class)));
    }
}
