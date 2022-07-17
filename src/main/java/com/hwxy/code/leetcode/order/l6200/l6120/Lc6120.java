package com.hwxy.code.leetcode.order.l6200.l6120;

import java.util.HashMap;
import java.util.Map;

/**
 * 6120. 数组能形成多少数对
 * https://leetcode.cn/contest/weekly-contest-302/problems/maximum-number-of-pairs-in-array/
 * 
 * @author hwxy
 * @date 2022/07/17
 **/
public class Lc6120 {

    public int[] numberOfPairs(int[] nums) {
        if (nums == null) {
            return null;
        }
        int pair = 0;
        int left = nums.length;
        Map<Integer, Integer> numCnt = new HashMap<>();
        for (int num : nums) {
            numCnt.put(num, numCnt.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : numCnt.entrySet()) {
            pair += entry.getValue() / 2;
        }
        left -= pair * 2;
        int[] ans = new int[2];
        ans[0] = pair;
        ans[1] = left;
        return ans;
    }
}
