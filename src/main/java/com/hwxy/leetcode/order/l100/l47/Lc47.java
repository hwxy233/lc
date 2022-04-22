package com.hwxy.leetcode.order.l100.l47;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Lc47 {
    public static void main(String[] args) {
        // System.out.println(new Lc47().permuteUnique(new int[] {1, 1, 2}));
        System.out.println(new Lc47().permuteUnique(new int[] {1, 2, 3}));
    }

    private final LinkedList<List<Integer>> result = new LinkedList<>();
    private final LinkedList<Integer> tmp = new LinkedList<>();
    private int[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return result;
        }
        used = new int[nums.length];
        Arrays.sort(nums);
        backtracking(nums);
        return result;
    }

    /**
     * 排列不需要index
     * 去重和40题一样
     * 
     * @param nums
     */
    private void backtracking(int[] nums) {
        if (tmp.size() == nums.length) {
            result.add(new LinkedList<>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 找到没用过的
            if (used[i] == 1) {
                continue;
            }
            // 去重
            if (i != 0 && (nums[i] == nums[i - 1]) && used[i - 1] == 0) {
                continue;
            }
            tmp.add(nums[i]);
            used[i] = 1;
            backtracking(nums);
            used[i] = 0;
            tmp.removeLast();
        }
    }
}
