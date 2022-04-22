package com.hwxy.leetcode.order.l100.l90;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 干嘛的
 *
 * @author hwxy
 * @date 2021/08/08
 **/
public class Lc90 {
    public static void main(String[] args) {
        System.out.println(new Lc90().subsetsWithDup(new int[] {1, 2, 2}));
    }

    private final LinkedList<List<Integer>> result = new LinkedList<>();
    private final LinkedList<Integer> tmp = new LinkedList<>();
    private int[] used;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null || nums.length == 0) {
            return result;
        }
        used = new int[nums.length];
        // 排序
        Arrays.sort(nums);
        backtracking(nums, 0);
        return result;
    }

    /**
     * 子集是开头进行add
     * 并且需要去重,去重的方法和40题一样,也是树层之间去重l
     * 
     * @param nums
     * @param index
     */
    private void backtracking(int[] nums, int index) {
        result.add(new LinkedList<>(tmp));
        if (index >= nums.length) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            // (nums[i] == nums[i - 1]) && used[i - 1] == 0 说明是相同的值在另一个树枝的同一层出现了
            if (i != 0 && (nums[i] == nums[i - 1]) && used[i - 1] == 0) {
                continue;
            }
            used[i] = 1;
            tmp.add(nums[i]);
            backtracking(nums, i + 1);
            tmp.removeLast();
            used[i] = 0;
        }
    }
}
