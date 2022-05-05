package com.hwxy.code.leetcode.order.l200.l191;

/**
 * 191. 位1的个数
 * https://leetcode-cn.com/problems/number-of-1-bits/
 * 
 * @author hwxy
 * @date 2022/04/05
 **/
public class Lc191 {
    /**
     * 2种方法
     * 1. 不断和2的i次方做与运算,由地位到高位计算1的个数,结果不为0就+1
     * 2. lowbit,不断和(n-1)做与运算,该运算可以将地位由1变为0
     * 
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int res = 0;
        // 32进制的int
        for (int i = 0; i < 32; i++) {
            // 与2的i次方进行与运算,只要结果不为0就说明那一位是1
            if ((n & (1 << i)) != 0) {
                res++;
            }
        }
        return res;
    }

    public int hammingWeight1(int n) {
        int res = 0;
        while (n != 0) {
            // 不断进行lowbit
            n = n & (n - 1);
            res++;
        }
        return res;
    }
}
