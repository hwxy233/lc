package com.hwxy.leetcode.order.l100.l1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 干嘛的
 *
 * @author hwxy
 * @date 2022/05/03
 **/
public class Lc1NeetCode {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }
        Map<Integer, List<Integer>> numIndexCounter = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numIndexCounter.computeIfAbsent(nums[i], num -> new ArrayList<>()).add(i);
        }
        int[] res = new int[2];
        for (Map.Entry<Integer, List<Integer>> entry : numIndexCounter.entrySet()) {
            int less = target - entry.getKey();
            if ((less == entry.getKey() && entry.getValue().size() > 1)) {
                res[0] = entry.getValue().get(0);
                res[1] = entry.getValue().get(1);
                break;
            }
            if (numIndexCounter.get(less) != null) {
                res[0] = entry.getValue().get(0);
                res[1] = numIndexCounter.get(less).get(0);
                break;
            }
        }
        return res;
    }
}
