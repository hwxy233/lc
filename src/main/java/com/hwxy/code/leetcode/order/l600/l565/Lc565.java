package com.hwxy.code.leetcode.order.l600.l565;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 565. 数组嵌套
 * https://leetcode.cn/problems/array-nesting/
 * 
 * @author hwxy
 * @date 2022/07/17
 **/
public class Lc565 {


    public int arrayNesting(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int[] visited = new int[nums.length];
        int ans = 0;
        // 相当于判断环
        for (int num : nums) {
            int cnt = 0;
            while (visited[num] != 1) {
                visited[num] = 1;
                num = nums[num];
                cnt++;
            }
            ans = Math.max(ans, cnt);
        }
        return ans;
    }


    public int arrayNesting1(int[] nums) {
        if (nums == null) {
            return 0;
        }
        Map<Integer, Set<Integer>> indexSet = new HashMap<>();
        int ans = 0;
        for (int num : nums) {
            Set<Integer> set = indexSet.get(num);
            if (set == null) {
                set = new HashSet<>();
                dfs(num, nums, set, indexSet);
            }
            ans = Math.max(ans, indexSet.get(num).size());
        }
        return ans;
    }

    /**
     * dfs
     * 
     * @param num
     * @param nums
     * @param set
     * @param indexSet
     */
    private void dfs(int num, int[] nums, Set<Integer> set, Map<Integer, Set<Integer>> indexSet) {
        indexSet.computeIfAbsent(num, key -> set);
        if (!set.add(num)) {
            return;
        }
        dfs(nums[num], nums, set, indexSet);
    }

}
