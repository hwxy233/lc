package com.hwxy.code.leetcode.order.l1400.l1331;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1331. 数组序号转换
 * https://leetcode.cn/problems/rank-transform-of-an-array/
 *
 * @author hwxy
 * @date 2022/07/28
 **/
public class Lc1331 {
    public int[] arrayRankTransform(int[] arr) {
        if (arr == null || arr.length == 0) {
            return arr;
        }
        int[] sorted = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sorted);
        Map<Integer, Integer> valueIndex = new HashMap<>();
        for (int i = 0; i < sorted.length; i++) {
            if (valueIndex.containsKey(sorted[i])) {
                continue;
            }
            valueIndex.put(sorted[i], valueIndex.size() + 1);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = valueIndex.get(arr[i]);
        }
        return arr;
    }
}
