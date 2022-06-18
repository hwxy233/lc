package com.hwxy.code.leetcode.order.l600.l532;

import java.util.HashMap;
import java.util.Map;

/**
 * 532. 数组中的 k-diff 数对
 * https://leetcode.cn/problems/k-diff-pairs-in-an-array/
 * 
 * @author hwxy
 * @date 2022/06/16
 **/
public class Lc532 {
    public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length < 2 || k < 0) {
            return 0;
        }
        Map<Integer, Integer> numsCnt = new HashMap<>();
        for (int num : nums) {
            numsCnt.put(num, numsCnt.getOrDefault(num, 0) + 1);
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : numsCnt.entrySet()) {
            if (k == 0) {
                if (entry.getValue() > 1) {
                    ans++;
                }
            } else {
                if (numsCnt.containsKey(entry.getKey() + k)) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
