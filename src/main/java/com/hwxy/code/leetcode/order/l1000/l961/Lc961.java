package com.hwxy.code.leetcode.order.l1000.l961;

import java.util.HashSet;
import java.util.Set;

/**
 * 961. 在长度 2N 的数组中找出重复 N 次的元素
 * https://leetcode.cn/problems/n-repeated-element-in-size-2n-array/
 * 
 * @author hwxy
 * @date 2022/05/21
 **/
public class Lc961 {
    /**
     * 只要重复了一次就是答案
     * 
     * @param nums
     * @return
     */
    public int repeatedNTimes(int[] nums) {
        if (nums == null || nums.length < 1) {
            throw new IllegalArgumentException();
        }
        Set<Integer> exists = new HashSet<>();
        for (int num : nums) {
            if (!exists.add(num)) {
                return num;
            }
        }
        throw new IllegalArgumentException();
    }
}
