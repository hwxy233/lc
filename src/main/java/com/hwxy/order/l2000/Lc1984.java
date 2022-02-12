package com.hwxy.order.l2000;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 1984. 学生分数的最小差值
 * https://leetcode-cn.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores/
 * 
 * @author hwxy
 * @date 2022/02/12
 **/
public class Lc1984 {
    public static void main(String[] args) {
        System.out.println(new Lc1984().minimumDifference(new int[] {9, 4, 1, 7}, 2));
    }


    private int min = Integer.MAX_VALUE;
    private LinkedList<Integer> curRes;

    public int minimumDifference(int[] nums, int k) {
        if (nums == null || nums.length <= 1 || k <= 0) {
            return 0;
        }
        // return f1(nums, k);
        return f2(nums, k);
    }

    private int f2(int[] nums, int k) {
        Arrays.sort(nums);
        // 滑动窗口, 游标 < 数量(算数量是+1的)
        for (int i = 0; i < nums.length - k + 1; i++) {
            min = Math.min(min, (nums[i + k - 1]) - nums[i]);
        }
        return min;
    }

    private int f1(int[] nums, int k) {
        Arrays.sort(nums);
        curRes = new LinkedList<>();
        backtracking(nums, k, 0);
        return min;
    }

    private void backtracking(int[] nums, int k, int index) {
        if (curRes.size() == k) {
            min = Math.min(min, curRes.getLast() - curRes.getFirst());
            return;
        }
        // 稍微剪一下,还需要数量 <= 剩余数量(i从0开始就不+1)
        for (int i = index; k - curRes.size() <= nums.length - i; i++) {
            curRes.add(nums[i]);
            backtracking(nums, k, i + 1);
            curRes.removeLast();
        }
    }
}
