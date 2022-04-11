package com.hwxy.order.l400.l357;

/**
 * 357. 统计各位数字都不同的数字个数
 * https://leetcode-cn.com/problems/count-numbers-with-unique-digits/
 * 
 * @author hwxy
 * @date 2022/04/11
 **/
public class Lc357 {
    public static void main(String[] args) {
        System.out.println(new Lc357().countNumbersWithUniqueDigits(3));
        System.out.println(new Lc357().countNumbersWithUniqueDigits(0));
        System.out.println(new Lc357().countNumbersWithUniqueDigits(2));
    }

    /**
     * 排列组合问题
     * C9,1 * A9,(n-1)
     * 因为在n>1的情况下,第一位为[1,9]这9种
     * 还剩下(n-1)个位子可以选,这是个排列问题所以是A9,(n-1)
     * 每种位数情况累加
     * 然后结果还需要加上n=1的10种可能
     * 
     * @param n 10的n次方,范围[0,10的n次方)
     * @return
     */
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 10;
        }
        // n=1的情况
        int res = 10;
        // C9,1的情况
        int cur = 9;
        for (int i = 0; i < n - 1; i++) {
            // 模拟A9,(n-1)
            cur = cur * (9 - i);
            // 每种情况都要累加
            res += cur;
        }
        return res;
    }
}
