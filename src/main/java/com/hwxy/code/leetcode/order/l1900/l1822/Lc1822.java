package com.hwxy.code.leetcode.order.l1900.l1822;

/**
 * 1822. 数组元素积的符号
 * https://leetcode.cn/problems/sign-of-the-product-of-an-array/
 *
 * @author hwxy
 * @date 2022/10/27
 **/
public class Lc1822 {
    public int arraySign(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int negCnt = 0;
        for (int num : nums) {
            if (num == 0) {
                return 0;
            }
            if (num < 0) {
                negCnt++;
            }
        }
        return negCnt % 2 == 0 ? 1 : -1;
    }
}
