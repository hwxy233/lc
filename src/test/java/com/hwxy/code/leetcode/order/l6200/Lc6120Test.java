package com.hwxy.code.leetcode.order.l6200;

import java.util.Arrays;

import com.hwxy.code.leetcode.order.l6200.l6120.Lc6120;
import org.junit.Test;

import com.hwxy.code.utils.JsonUtil;

public class Lc6120Test {

    @Test
    public void numberOfPairs() {
        Lc6120 lc6120 = new Lc6120();
        System.out.println(Arrays.toString(
                lc6120.numberOfPairs(JsonUtil.convertToT("[1,3,2,1,3,2,2]", int[].class))));
        System.out.println(Arrays.toString(
                lc6120.numberOfPairs(JsonUtil.convertToT("[1,1]", int[].class))));
        System.out.println(Arrays.toString(
                lc6120.numberOfPairs(JsonUtil.convertToT("[10]", int[].class))));
    }
}
