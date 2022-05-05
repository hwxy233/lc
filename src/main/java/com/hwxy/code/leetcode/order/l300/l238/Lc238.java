package com.hwxy.code.leetcode.order.l300.l238;

/**
 * 238. 除自身以外数组的乘积
 * https://leetcode-cn.com/problems/product-of-array-except-self/
 * 
 * @author hwxy
 * @date 2022/05/04
 **/
public class Lc238 {
    /**
     * 要求不能使用除法
     * 时间复杂度O(n)
     * 可以用2个数组:
     * 1. 一个存储i所有左侧的乘积
     * 2. 一个存储i所有右侧的乘积
     * 那么每个i的结果就是i对应位置的左边和右边的乘积
     * 
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int[] lProduct = new int[nums.length];
        // 第一个元素的左边乘积为1
        lProduct[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            lProduct[i] = lProduct[i - 1] * nums[i - 1];
        }
        // 右边最后一个元素的右边的乘积为1
        int[] rProduct = new int[nums.length];
        rProduct[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            rProduct[i] = rProduct[i + 1] * nums[i + 1];
        }
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = lProduct[i] * rProduct[i];
        }
        return ans;
    }
}
