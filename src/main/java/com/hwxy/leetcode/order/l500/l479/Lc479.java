package com.hwxy.leetcode.order.l500.l479;

/**
 * 479. 最大回文数乘积
 * https://leetcode-cn.com/problems/largest-palindrome-product/
 * 
 * @author hwxy
 * @date 2022/04/16
 **/
public class Lc479 {
    public static void main(String[] args) {
        System.out.println(new Lc479().largestPalindrome(2));
    }

    /**
     * n位数*n位数的结果为2n位数,因为是回文数所以只要枚举左半边即可
     * 注意溢出
     * 
     * @param n
     * @return
     */
    public int largestPalindrome(int n) {
        if (n == 1) {
            return 9;
        }
        // n位数*n位数的结果为2n位数,因为是回文数所以只要枚举左半边即可
        // 从最大值开始枚举
        long max = (long) (Math.pow(10, n) - 1);
        for (long left = max; left > 0; left--) {
            // 用left构造回文数
            long p = left;
            for (long right = left; right > 0; right /= 10) {
                // 每次加余数
                p = p * 10 + right % 10;
            }
            // 然后再从max开始不断的除p直到x*x<p
            for (long x = max; x * x >= p; x--) {
                if (p % x == 0) {
                    return (int) (p % 1337);
                }
            }
        }
        return 0;
    }
}
