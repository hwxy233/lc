package com.hwxy.code.leetcode.order.l1700.l1652;

import com.hwxy.code.utils.JsonUtil;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class Lc1652Test {

    @Test
    public void decrypt() {
        Lc1652 lc1652 = new Lc1652();
        assertArrayEquals(
                JsonUtil.convertToIntArray("[12,10,16,13]"),
                lc1652.decrypt(JsonUtil.convertToIntArray("[5,7,1,4]"), 3));
        assertArrayEquals(
                JsonUtil.convertToIntArray("[12,5,6,13]"), lc1652.decrypt(JsonUtil.convertToIntArray("[2,4,9,3]"), -2));
        assertArrayEquals(
                JsonUtil.convertToIntArray("[0,0,0,0]"), lc1652.decrypt(JsonUtil.convertToIntArray("[2,4,9,3]"), 0));
    }
}