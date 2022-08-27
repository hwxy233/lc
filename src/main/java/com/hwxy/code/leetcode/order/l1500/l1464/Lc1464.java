package com.hwxy.code.leetcode.order.l1500.l1464;

/**
 * 1464. 数组中两元素的最大乘积 https://leetcode.cn/problems/maximum-product-of-two-elements-in-an-array/
 *
 * @author hwxy
 * @date 2022/08/26
 */
public class Lc1464 {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        //        Arrays.sort(nums);
        //        return (nums[nums.length - 1] - 1) * (nums[nums.length - 2] - 1);

        int m1 = 0;
        int m2 = 0;
        for (int num : nums) {
            if (num > m1) {
                m2 = m1;
                m1 = num;
            } else if (num > m2) {
                m2 = num;
            }
        }
        return (m1 - 1) * (m2 - 1);
    }
}
