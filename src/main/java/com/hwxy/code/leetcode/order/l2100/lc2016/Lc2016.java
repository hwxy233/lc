package com.hwxy.code.leetcode.order.l2100.lc2016;

/**
 * 2016. 增量元素之间的最大差值
 * https://leetcode-cn.com/problems/maximum-difference-between-increasing-elements/
 * 
 * @author hwxy
 * @date 2022/02/26
 **/
public class Lc2016 {
    public static void main(String[] args) {
        System.out.println(new Lc2016().maximumDifference(new int[] {7, 1, 5, 4}));
    }

    public int maximumDifference(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        // return f1(nums);
        return f2(nums);
    }

    /**
     * 由于0 <= i < j
     * 所以可以计算出差值的j一定在i的右侧
     * 只需要维护一个[0,j)的最小值即可
     * 
     * @param nums
     * @return
     */
    private int f2(int[] nums) {
        int max = -1;
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > min) {
                max = Math.max(max, nums[i] - min);
            } else {
                min = nums[i];
            }
        }
        return max;
    }

    /**
     * 双层循环
     * 
     * @param nums
     * @return
     */
    private int f1(int[] nums) {
        int max = -1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] >= nums[j]) {
                    continue;
                }
                max = Math.max(max, nums[j] - nums[i]);
            }
        }
        return max;
    }
}
