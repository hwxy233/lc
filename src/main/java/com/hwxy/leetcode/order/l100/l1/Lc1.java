package com.hwxy.leetcode.order.l100.l1;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 * https://leetcode-cn.com/problems/two-sum/
 *
 * @author hwxy
 * @date 2022/01/31
 **/
public class Lc1 {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null) {
            return nums;
        }
        Map<Integer, Integer> valueIndex = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            valueIndex.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            // 剩余的value
            int lessValue = target - nums[i];
            // 是否存在剩余value的index,不能取重复自己
            Integer index = valueIndex.get(lessValue);
            if (index != null && index != i) {
                return new int[] {i, index};
            }
        }
        return null;
    }
}
