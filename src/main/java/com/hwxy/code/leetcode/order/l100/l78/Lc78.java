package com.hwxy.code.leetcode.order.l100.l78;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * 78. 子集
 * https://leetcode.cn/problems/subsets/
 * 
 * @author hwxy
 * @date 2021/08/08
 **/
public class Lc78 {

    public static void main(String[] args) {
        Lc78 lc78 = new Lc78();
        System.out.println(lc78.subsets(new int[] {1, 2, 3}));
    }

    private LinkedList<List<Integer>> result = new LinkedList<>();

    private LinkedList<Integer> tmp = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        if (Objects.isNull(nums) || nums.length == 0) {
            return result;
        }
        backtracking(nums, 0);
        return result;
    }

    private void backtracking(int[] nums, int index) {
        result.add(new LinkedList<>(tmp));
        if (index >= nums.length) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            tmp.add(nums[i]);
            backtracking(nums, i + 1);
            tmp.removeLast();
        }
    }
}
