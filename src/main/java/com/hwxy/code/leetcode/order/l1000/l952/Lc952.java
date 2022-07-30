package com.hwxy.code.leetcode.order.l1000.l952;

import java.util.Arrays;

/**
 * 952. 按公因数计算最大组件大小
 * https://leetcode.cn/problems/largest-component-size-by-common-factor/
 *
 * @author hwxy
 * @date 2022/07/30
 **/
public class Lc952 {
    public int largestComponentSize(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 找到最大数当做跟的最大值
        int m = Arrays.stream(nums).max().getAsInt();
        UnionFieldSet unionFieldSet = new UnionFieldSet(m + 1);
        // 找出所有数的因数构建并查集
        for (int num : nums) {
            // 因数求到根号就行
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    // 注意因数和除以因数的结果都要放到集合里
                    unionFieldSet.union(num, i);
                    unionFieldSet.union(num, num / i);
                }
            }
        }
        int[] counts = new int[m + 1];
        int ans = 0;
        // 对每个数找根,并更新根里集合的大小
        for (int num : nums) {
            int root = unionFieldSet.find(num);
            counts[root]++;
            ans = Math.max(ans, counts[root]);
        }
        return ans;
    }

    static class UnionFieldSet {
        final int[] parents;
        final int[] ranks;

        UnionFieldSet(int n) {
            parents = new int[n];
            // 初始的每个节点的根是自己
            for (int i = 0; i < n; i++) {
                parents[i] = i;
            }
            ranks = new int[n];
        }

        /**
         * 找一个节点的根
         * 
         * @param child
         * @return
         */
        int find(int child) {
            if (child != parents[child]) {
                // 直接把这个节点挂到根上
                parents[child] = find(parents[child]);
            }
            return parents[child];
        }

        /**
         * 合并一个集合到另一个
         * 
         * @param x
         * @param y
         */
        void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (ranks[px] > ranks[py]) {
                parents[py] = px;
            } else if (ranks[px] < ranks[py]) {
                parents[px] = py;
            } else {
                parents[py] = px;
                ranks[px]++;
            }
        }
    }
}
