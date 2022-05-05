package com.hwxy.code.leetcode.order.l100.l15;

import com.hwxy.code.utils.JsonUtil;
import org.junit.Test;

import static org.junit.Assert.*;

public class Lc15NeetCodeTest {

    @Test
    public void threeSum() {
        Lc15NeetCode lc15NeetCode = new Lc15NeetCode();
        System.out.println(
                lc15NeetCode.threeSum(JsonUtil.convertToT("[-2,0,0,2,2]", int[].class)));
        System.out.println(
                lc15NeetCode.threeSum(JsonUtil.convertToT("[0,0,0]", int[].class)));
        System.out.println(
                lc15NeetCode.threeSum(JsonUtil.convertToT("[-1,0,1,2,-1,-4]", int[].class)));
    }
}
