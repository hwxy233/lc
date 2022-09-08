package com.hwxy.code.leetcode.order.l700.l667;

/**
 * 667. 优美的排列 II
 *
 * <p>https://leetcode.cn/problems/beautiful-arrangement-ii/
 *
 * @author hwxy
 * @date 2022/09/08
 */
public class Lc667 {
    public int[] constructArray(int n, int k) {
        if (n < 1 || k > n) {
            return null;
        }
        int[] ans = new int[n];
        // 直接最小,最大,次小,次大...这样排列直到index==k因为这时恰好有了k-1种不同
        // 剩下的不同就用1来填补,看下是顺着填充还是逆着填充即可
        int left = 1;
        int right = n;
        int index = 0;
        while (index != k) {
            if (index % 2 == 0) {
                ans[index] = left++;
            } else {
                ans[index] = right--;
            }
            index++;
        }
        if (Math.abs(ans[index - 1] - right) == 1) {
            for (int i = right; i >= left; i--) {
                ans[index++] = i;
            }
        } else {
            for (int i = left; i <= right; i++) {
                ans[index++] = i;
            }
        }
        return ans;
    }
}
