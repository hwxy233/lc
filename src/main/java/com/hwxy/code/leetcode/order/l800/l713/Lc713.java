package com.hwxy.code.leetcode.order.l800.l713;

/**
 * 713. 乘积小于 K 的子数组
 * https://leetcode-cn.com/problems/subarray-product-less-than-k/
 * 
 * @author hwxy
 * @date 2022/05/05
 **/
public class Lc713 {
    private int ans;

    /**
     * 双指针法维护一个滑动窗口
     * 计算连续子数组的个数的公式为right-left+1
     * 因为每个新子数组就是最初的元素nums[left]不断增加后面的元素nums[left+1]直到nums[right]
     * 相当于所有元素的个数
     * 
     * @param nums
     * @param k
     * @return
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) {
            return 0;
        }
        int ans = 0;
        int product = 1;
        // 不断右移窗口
        for (int left = 0, right = 0; right < nums.length; right++) {
            product *= nums[right];
            // 如果超过k了就左移窗口
            while (product >= k && left <= right) {
                product /= nums[left++];
            }
            // 子数组的个数就是最终子数组的元素数
            ans += (right - left + 1);
        }
        return ans;
    }

    /**
     * 超时
     * 
     * @param nums
     * @param k
     * @return
     */
    private int numSubarrayProductLessThanK1(int[] nums, int k) {
        ans = 0;
        for (int i = 0; i < nums.length; i++) {
            dfs(nums, k, i, 1);
        }
        return ans;
    }

    private void dfs(int[] nums, int k, int index, int product) {
        if (index >= nums.length) {
            return;
        }
        int p = product * nums[index];
        if (p >= k) {
            return;
        }
        ans++;
        dfs(nums, k, index + 1, p);
    }
}
