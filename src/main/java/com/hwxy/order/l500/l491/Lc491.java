package com.hwxy.order.l500.l491;

import java.util.*;

/**
 * 干嘛的
 *
 * @author hwxy
 * @date 2021/08/15
 **/
public class Lc491 {

    public static void main(String[] args) {
        System.out.println(new Lc491().findSubsequences(new int[] {4, 6, 7, 7}));
    }

    private final LinkedList<List<Integer>> result = new LinkedList<>();
    private final LinkedList<Integer> tmp = new LinkedList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        if (Objects.isNull(nums) || nums.length < 2) {
            return result;
        }
        backtracking(nums, 0);
        return result;
    }

    private void backtracking(int[] nums, int index) {
        // 至少长度2
        if (tmp.size() >= 2) {
            result.add(new LinkedList<>(tmp));
        }
        if (index >= nums.length) {
            return;
        }
        // 本层去重 set或者用数组大小201, 数值范围[-100,100]
        int[] used = new int[201];
        Arrays.fill(used, 0);
        for (int i = index; i < nums.length; i++) {
            if (used[nums[i] + 100] == 1 || (tmp.size() != 0 && nums[i] < tmp.getLast())) {
                continue;
            }
            tmp.add(nums[i]);
            // used
            used[nums[i] + 100] = 1;
            backtracking(nums, i + 1);
            tmp.removeLast();
        }
    }
}
