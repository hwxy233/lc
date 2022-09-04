package com.hwxy.code.leetcode.order.l700.l646;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 646. 最长数对链
 *
 * <p>https://leetcode.cn/problems/maximum-length-of-pair-chain/
 *
 * @author hwxy
 * @date 2022/09/04
 */
public class Lc646 {
    public int findLongestChain(int[][] pairs) {
        if (pairs == null || pairs.length < 1) {
            return 0;
        }
        Arrays.sort(
                pairs,
                new Comparator<int[]>() {
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        return Integer.compare(o1[1], o2[1]);
                    }
                });
        int ans = 0;
        int max = Integer.MIN_VALUE;
        for (int[] pair : pairs) {
            if (pair[0] > max) {
                max = pair[1];
                ans++;
            }
        }
        return ans;
    }
}
