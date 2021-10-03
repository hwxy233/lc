package com.hwxy.order.l100.l90;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 90复习
 *
 * @author hwxy
 * @date 2021/10/03
 **/
public class Lc90R {

    public static void main(String[] args) {
        Lc90R lc90R = new Lc90R();
        System.out.println(lc90R.subWithDup(new int[] {1, 2, 2}));
    }

    private LinkedList<List<Integer>> result = new LinkedList<>();

    private LinkedList<Integer> tmp = new LinkedList<>();

    private boolean[] used;

    public List<List<Integer>> subWithDup(int[] nums) {
        if (nums == null || nums.length == 0) {
            return result;
        }
        used = new boolean[nums.length];
        // 去重都要排序
        Arrays.sort(nums);
        backtracking(nums, 0);
        return result;
    }

    private void backtracking(int[] nums, int index) {
        result.add(new LinkedList<>(tmp));
        if (index == nums.length) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            tmp.add(nums[i]);
            used[i] = true;
            backtracking(nums, i + 1);
            used[i] = false;
            tmp.removeLast();
        }
    }

}
