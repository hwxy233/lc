package com.hwxy.leetcode.order.l100.l15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 15. 三数之和
 * https://leetcode-cn.com/problems/3sum/
 *
 * @author hwxy
 * @date 2022/01/31
 **/
public class Lc15 {
    public static void main(String[] args) {
        System.out.println(new Lc15().threeSum(new int[] {0, 0, 0, 0}));
    }


    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null) {
            return Collections.emptyList();
        }
        // 先排序
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            // 第一个就>0不可能凑成了
            if (nums[0] > 0) {
                return res;
            }

            // 相邻相同去重,注意是对i并且向左
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // left在i+1处开始
            int left = i + 1;
            // right在末尾
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                // 找到了
                if (sum == 0) {
                    List<Integer> curRes = new ArrayList<>(3);
                    curRes.add(nums[i]);
                    curRes.add(nums[left]);
                    curRes.add(nums[right]);
                    res.add(curRes);
                    // 去重
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (right > left && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum > 0) {
                    // 大了
                    right--;
                } else {
                    // 小了
                    left++;
                }
            }
        }
        return res;
    }
}
