package com.hwxy.code.leetcode.order.l900.l873;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 873. 最长的斐波那契子序列的长度
 * https://leetcode.cn/problems/length-of-longest-fibonacci-subsequence/
 * 
 * @author hwxy
 * @date 2022/07/09
 **/
public class Lc873 {

    public int lenLongestFibSubseq(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int n = arr.length;
        int ans = 0;
        Map<Integer, Integer> valueIndex = new HashMap<>();
        for (int i = 0; i < n; i++) {
            valueIndex.put(arr[i], i);
        }
        // dp[i][j]代表使用arr[i]为最后一个,arr[j]位倒数第二个的数量
        // dp[i][j] = max(dp[j][k] + 1, 3),下标 k < j < i, 且arr[k] < arr[j] < arr[i]
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                // 求出arrK,2个数的差
                int arrK = arr[i] - arr[j];
                // 不是递增的了
                if (arrK >= arr[j]) {
                    break;
                }
                // 看下是否存在arr里
                int k = valueIndex.getOrDefault(arrK, -1);
                if (k == -1) {
                    continue;
                }
                dp[i][j] = Math.max(3, dp[j][k] + 1);
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;

    }


    /**
     * 2重循环找前2个数,然后不断检查能否有第三个数和
     * 
     * @param arr
     * @return
     */
    public int lenLongestFibSubseq1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int ans = 0;
        Set<Integer> set = new HashSet<>(arr.length);
        for (int a : arr) {
            set.add(a);
        }
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                int cnt = cal(arr[i], arr[j], set);
                if (cnt != 0) {
                    cnt += 2;
                }
                ans = Math.max(ans, cnt);
            }
        }
        return ans;
    }

    private int cal(int first, int second, Set<Integer> set) {
        int cnt = 0;
        while (true) {
            int want = first + second;
            if (set.contains(want)) {
                cnt++;
                first = second;
                second = want;
            } else {
                break;
            }
        }
        return cnt;
    }

}
