package com.hwxy.code.leetcode.order.l400.l324;

import java.util.Arrays;

import org.junit.Test;

import com.hwxy.code.utils.JsonUtil;

public class Lc324Test {

    @Test
    public void wiggleSort() {
        Lc324 lc324 = new Lc324();
        int[] nums = JsonUtil.convertToT("[1,1,5,1,1,6,4]", int[].class);
        lc324.wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
        nums = JsonUtil.convertToT("[1,3,2,2,3,1]", int[].class);
        lc324.wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
