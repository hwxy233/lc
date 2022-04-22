package com.hwxy.leetcode.order.l100.l27;

import java.util.Arrays;

/**
 * 27. 移除元素
 * https://leetcode-cn.com/problems/remove-element/
 *
 * @author hwxy
 * @date 2022/01/30
 **/
public class Lc27 {
    public static void main(String[] args) {
        int[] a = new int[] {0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println(new Lc27().removeElement(a, 2));
        System.out.println(Arrays.toString(a));
    }

    public int removeElement(int[] nums, int val) {
        // return f1(nums, val);
        return f2(nums, val);
    }

    /**
     * 双for循环
     * 
     * @param nums
     * @param val
     * @return
     */
    private int f1(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            if (nums[i] == val) {
                for (int j = i + 1; j < size; j++) {
                    nums[j - 1] = nums[j];
                }
                size--;
                i--;
            }
        }
        return size;
    }

    /**
     * 快慢指针
     * 
     * @param nums
     * @param val
     * @return
     */
    private int f2(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != val) {
                nums[slowIndex++] = nums[fastIndex];
            }
        }
        return slowIndex;
    }
}
