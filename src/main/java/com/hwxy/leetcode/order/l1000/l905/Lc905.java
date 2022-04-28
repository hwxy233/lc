package com.hwxy.leetcode.order.l1000.l905;

/**
 * 905. 按奇偶排序数组
 * https://leetcode-cn.com/problems/sort-array-by-parity/
 * 
 * @author hwxy
 * @date 2022/04/28
 **/
public class Lc905 {
    /**
     * 双指针法,从前向后找奇数
     * 从后向前找偶数
     * 然后交换
     * 
     * @param nums
     * @return
     */
    public int[] sortArrayByParity(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            while (i < nums.length && nums[i] % 2 != 1) {
                i++;
            }
            while (j >= 0 && nums[j] % 2 != 0) {
                j--;
            }
            if (i < j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        return nums;
    }
}
