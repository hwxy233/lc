package com.hwxy.code.leetcode.order.l500.l440;

/**
 * 440. 字典序的第K小数字
 * https://leetcode-cn.com/problems/k-th-smallest-in-lexicographical-order/
 * 
 * @author hwxy
 * @date 2022/03/23
 **/
public class Lc440 {
    /**
     * 字典树
     * 
     * @param n
     * @param k
     * @return
     */
    public int findKthNumber(int n, int k) {
        int curr = 1;
        k--;
        while (k > 0) {
            int steps = getSteps(curr, n);
            if (steps <= k) {
                k -= steps;
                curr++;
            } else {
                curr = curr * 10;
                k--;
            }
        }
        return curr;
    }

    /**
     * 算出子树的数量
     * 前序遍历有序所以k跳过小的
     * 
     * @param curr
     * @param n
     * @return
     */
    public int getSteps(int curr, long n) {
        int steps = 0;
        long first = curr;
        long last = curr;
        while (first <= n) {
            steps += Math.min(last, n) - first + 1;
            first = first * 10;
            last = last * 10 + 9;
        }
        return steps;
    }

}
