package com.hwxy.order.l100.l78;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 干嘛的
 *
 * @author hwxy
 * @date 2022/02/04
 **/
public class Lc78R1 {
    private List<List<Integer>> res = new LinkedList<>();

    private LinkedList<Integer> curRes = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return res;
        }
        backtracking(nums, 0);
        res.add(Collections.emptyList());
        return res;
    }

    private void backtracking(int[] nums, int startIndex) {
        if (!curRes.isEmpty()) {
            res.add(new LinkedList<>(curRes));
        }
        for (int i = startIndex; i < nums.length; i++) {
            curRes.add(nums[i]);
            backtracking(nums, i + 1);
            curRes.removeLast();
        }
    }
}
