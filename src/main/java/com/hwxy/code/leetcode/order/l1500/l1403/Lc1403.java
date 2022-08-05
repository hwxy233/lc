package com.hwxy.code.leetcode.order.l1500.l1403;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 1403. 非递增顺序的最小子序列
 * https://leetcode.cn/problems/minimum-subsequence-in-non-increasing-order/
 * 
 * @author hwxy
 * @date 2022/08/04
 **/
public class Lc1403 {
    public List<Integer> minSubsequence(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }
        List<Integer> ans = new LinkedList<>();
        Arrays.sort(nums);
        int sum = Arrays.stream(nums).sum();
        int numSum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];
            ans.add(num);
            numSum += num;
            sum -= num;
            if (numSum > sum) {
                break;
            }
        }
        return ans;
    }
}
