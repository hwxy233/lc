package com.hwxy.order.l100.l18;

import java.util.*;

/**
 * 18. 四数之和
 * https://leetcode-cn.com/problems/4sum/
 *
 * @author hwxy
 * @date 2022/01/31
 **/
public class Lc18 {
    public static void main(String[] args) {
        System.out.println(new Lc18().fourSum(new int[] {1, 0, -1, 0, -2, 2}, 0));
    }

    /**
     * 双指针
     * n数之和就是n-1层循环
     * 
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null) {
            return Collections.emptyList();
        }
        // 先排序
        Arrays.sort(nums);
        // 双指针,三层循环
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            // 不能这样做,不如target=-18,num[0]=-16,num[1]=-2,num[3]=0,num[4]=0
            // if (nums[i] > target) {
            // continue;
            // }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                // 不能这样做,不如target=-18,num[0]=-16,num[1]=-2,num[3]=0,num[4]=0
                // if (abSum > target) {
                // continue;
                // }
                // 注意 > i+1
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j]
                            + nums[left] + nums[right];
                    if (sum > target) {
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        List<Integer> curRes = new ArrayList<>(4);
                        curRes.add(nums[i]);
                        curRes.add(nums[j]);
                        curRes.add(nums[left]);
                        curRes.add(nums[right]);
                        res.add(curRes);
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (right > left && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    }
                }
            }
        }
        return res;
    }
}
