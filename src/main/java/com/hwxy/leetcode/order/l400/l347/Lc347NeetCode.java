package com.hwxy.leetcode.order.l400.l347;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * 347. 前 K 个高频元素
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 * 
 * @author hwxy
 * @date 2022/05/03
 **/
public class Lc347NeetCode {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        Map<Integer, Integer> numCounter = new HashMap<>();
        for (int num : nums) {
            numCounter.put(num, numCounter.getOrDefault(num, 0) + 1);
        }
        return numCounter.entrySet().stream()
                .sorted((o1, o2) -> -Integer.compare(o1.getValue(), o2
                        .getValue()))
                .mapToInt(Map.Entry::getKey)
                .limit(k)
                .toArray();
    }
}
