package com.hwxy.code.leetcode.order.l900.l873;

import java.util.HashSet;
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
