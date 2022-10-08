package com.hwxy.code.leetcode.order.l900.l870;

import com.hwxy.code.utils.JsonUtil;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class Lc870Test {

    @Test
    public void advantageCount() {
        Lc870 lc870 = new Lc870();
        assertArrayEquals(
                JsonUtil.convertToIntArray("[2,11,7,15]"),
                lc870.advantageCount(
                        JsonUtil.convertToIntArray("[2,7,11,15]"), JsonUtil.convertToIntArray("[1,10,4,11]")));
        assertArrayEquals(
                JsonUtil.convertToIntArray("[24,32,8,12]"),
                lc870.advantageCount(
                        JsonUtil.convertToIntArray("[12,24,8,32]"), JsonUtil.convertToIntArray("[13,25,32,11]")));
    }
}