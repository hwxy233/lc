package com.hwxy.leetcode.order.l100.l1;

import com.hwxy.code.leetcode.order.l100.l1.Lc1NeetCode;
import com.hwxy.utils.JsonUtil;
import org.junit.Test;

import static org.junit.Assert.*;

public class Lc1NeetCodeTest {

    @Test
    public void twoSum() {
        Lc1NeetCode lc1NeetCode = new Lc1NeetCode();
        assertArrayEquals(JsonUtil.convertToT("[0,1]", int[].class),
                lc1NeetCode.twoSum(JsonUtil.convertToT("[2,7,11,15]", int[].class), 9));
        assertArrayEquals(JsonUtil.convertToT("[1,2]", int[].class),
                lc1NeetCode.twoSum(JsonUtil.convertToT("[3,2,4]", int[].class), 6));
        assertArrayEquals(JsonUtil.convertToT("[0,1]", int[].class),
                lc1NeetCode.twoSum(JsonUtil.convertToT("[3,3]", int[].class), 6));
    }
}
