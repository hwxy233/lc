package com.hwxy.code.leetcode.order.l400.l396;

import java.util.Arrays;

/**
 * 396. 旋转函数
 * https://leetcode-cn.com/problems/rotate-function/
 * 
 * @author hwxy
 * @date 2022/04/22
 **/
public class Lc396 {
    /**
     * 0<k<n
     * F(k) = F(k-1) + numSum - n*a[n-k]
     * 
     * @param nums
     * @return
     */
    public int maxRotateFunction(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int numSum = Arrays.stream(nums).sum();
        // 计算f0
        int fkPrev = 0;
        for (int i = 0; i < nums.length; i++) {
            fkPrev += i * nums[i];
        }
        int res = fkPrev;
        for (int k = 1; k < nums.length; k++) {
            int fk = fkPrev + numSum - nums.length * nums[nums.length - k];
            res = Math.max(fk, res);
            fkPrev = fk;
        }
        return res;
    }
}
