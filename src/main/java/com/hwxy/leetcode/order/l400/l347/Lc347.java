package com.hwxy.leetcode.order.l400.l347;

import java.util.*;

/**
 * 347. 前 K 个高频元素
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 *
 * @author hwxy
 * @date 2022/02/01
 **/
public class Lc347 {
    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(new Lc347().topKFrequent(new int[] {1, 1, 1, 2, 2, 3}, 2)));
    }


    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0) return nums;
        Map<Integer, Integer> occurrences = new HashMap<>();
        // 统计次数
        for (int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }

        // 次数小到大排序
        PriorityQueue<Map.Entry<Integer, Integer>> queue =
                new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            int count = entry.getValue();
            // 这时候比较下队首的次数
            if (queue.size() >= k) {
                if (count > queue.peek().getValue()) {
                    queue.poll();
                    queue.add(entry);
                }
            } else {
                queue.add(entry);
            }
        }
        int[] ret = new int[k];
        for (int i = 0; i < k; ++i) {
            ret[i] = queue.poll().getKey();
        }
        return ret;
    }
}
