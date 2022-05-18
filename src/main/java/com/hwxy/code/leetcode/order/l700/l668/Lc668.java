package com.hwxy.code.leetcode.order.l700.l668;

/**
 * 668. 乘法表中第k小的数
 * https://leetcode.cn/problems/kth-smallest-number-in-multiplication-table/
 * 
 * @author hwxy
 * @date 2022/05/18
 **/
public class Lc668 {
    /**
     * 和378题一样
     * 
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int findKthNumber(int m, int n, int k) {
        if (m <= 0 || n <= 0 || k <= 0) {
            return 0;
        }
        // 蓝红对值二分
        int l = 0;
        int r = m * n + 1;
        // isBlue:<=mid的数量<k
        while (l + 1 != r) {
            int mid = (l + r) >> 1;
            if (isBlue(mid, m, n) < k) {
                l = mid;
            } else {
                r = mid;
            }
        }
        return r;
    }

    private int isBlue(int mid, int m, int n) {
        int row = m;
        int column = 1;
        int cnt = 0;
        while (row >= 1 && column <= n) {
            if (row * column <= mid) {
                cnt += row;
                column++;
            } else {
                row--;
            }
        }
        return cnt;
    }
}
