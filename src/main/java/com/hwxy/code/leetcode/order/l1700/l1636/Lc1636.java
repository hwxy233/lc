package com.hwxy.code.leetcode.order.l1700.l1636;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 1636. 按照频率将数组升序排序
 * https://leetcode.cn/problems/sort-array-by-increasing-frequency/
 *
 * @author hwxy
 * @date 2022/09/19
 */
public class Lc1636 {
    public int[] frequencySort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        List<Integer> numsList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Map<Integer, Integer> numCnt = new HashMap<>();
        for (int num : numsList) {
            numCnt.put(num, numCnt.getOrDefault(num, 0) + 1);
        }
        numsList.sort((o1, o2) -> {
            int c1 = numCnt.get(o1);
            int c2 = numCnt.get(o2);
            if (c1 == c2) {
                return Integer.compare(o2, o1);
            }
            return Integer.compare(c1, c2);
        });

        return numsList.stream().mapToInt(i -> i).toArray();
    }
}
