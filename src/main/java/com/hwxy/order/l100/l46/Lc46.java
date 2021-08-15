package com.hwxy.order.l100.l46;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 干嘛的
 *
 * @author hwxy
 * @date 2021/07/17
 **/
public class Lc46 {
    public static void main(String[] args) {
        System.out.println(new Lc46().permute(new int[] {1, 2, 3}));
    }

    private final LinkedList<List<Integer>> result = new LinkedList<>();
    private final LinkedList<Integer> tmp = new LinkedList<>();
    private int[] used;

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return result;
        }
        used = new int[nums.length];
        // Arrays.fill(used, 0);
        backtracking(nums);
        return result;
    }

    private void backtracking(int[] nums) {
        if (tmp.size() == nums.length) {
            result.add(new LinkedList<>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 不要卸载for里面，这回直接结束
            if (used[i] == 1) {
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
