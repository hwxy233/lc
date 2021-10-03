package com.hwxy.order.l500.l491;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 491复习
 *
 * @author hwxy
 * @date 2021/10/03
 **/
public class Lc491R {
    public static void main(String[] args) {
        Lc491R lc491R = new Lc491R();
        System.out.println(lc491R.findSubsequences(new int[] {4, 7, 6, 7}));
        // System.out.println(lc491R.findSubsequences(new int[] {4, 6, 7, 7}));
    }

    private LinkedList<List<Integer>> result = new LinkedList<>();

    private LinkedList<Integer> tmp = new LinkedList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        if (nums == null || nums.length == 0) {
            return result;
        }
        backtracking(nums, 0);
        return result;
    }

    private void backtracking(int[] nums, int index) {
        if (tmp.size() >= 2) {
            result.add(new LinkedList<>(tmp));
        }
        if (index == nums.length) {
            return;
        }
        // 同一个父节点下的公用一个(同父节点下的同层去重)
        Set<Integer> used = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if (tmp.isEmpty() || nums[i] >= tmp.getLast()) {
                if (used.contains(nums[i])) {
                    continue;
                } else {
                    tmp.add(nums[i]);
                }
            } else {
                continue;
            }
            used.add(nums[i]);
            backtracking(nums, i + 1);
            tmp.removeLast();
        }
    }
}
