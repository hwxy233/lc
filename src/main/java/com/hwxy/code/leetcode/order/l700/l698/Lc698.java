package com.hwxy.code.leetcode.order.l700.l698;

import java.util.Arrays;

/**
 * 698. 划分为k个相等的子集
 * https://leetcode.cn/problems/partition-to-k-equal-sum-subsets/
 *
 * @author hwxy
 * @date 2022/09/20
 **/
public class Lc698 {
    private int cnt;
    private int sum;
    private boolean[] vis;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return false;
        }
        // 一定要排序,如果是正序就逆着找,倒序就正着找,有点贪心的感觉
        Arrays.sort(nums);
        sum = Arrays.stream(nums).sum();
        if (sum % k != 0) {
            return false;
        }
        sum /= k;
        cnt = k;
        vis = new boolean[nums.length];
        return backtracking(nums, nums.length - 1, 0, 0);
    }

    private boolean backtracking(int[] nums, int index, int curSum, int curCnt) {
        if (curCnt == cnt) {
            return true;
        }
        // 找下一组
        if (curSum == sum) {
            return backtracking(nums, nums.length - 1, 0, curCnt + 1);
        }
        for (int i = index; i >= 0; i--) {
            // 剪枝
            if (vis[i] || curSum + nums[i] > sum) {
                continue;
            }
            vis[i] = true;
            if (backtracking(nums, i - 1, curSum + nums[i], curCnt)) {
                return true;
            }
            vis[i] = false;
            // 说明第一组就无法找到
            if (curSum == 0) {
                return false;
            }
        }
        return false;
    }
}
