package com.hwxy.code.leetcode.order.l100.l75;

import com.hwxy.code.utils.JsonUtil;

/**
 * 75. 颜色分类
 * https://leetcode.cn/problems/sort-colors/
 * 
 * @author hwxy
 * @date 2022/07/08
 **/
public class Lc75 {
    public static void main(String[] args) {
        Lc75 lc75 = new Lc75();
        lc75.sortColors(JsonUtil.convertToT("[1,0,2]", int[].class));
    }


    public void sortColors(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        // 使用循环不变量的方法来进行编程
        // 0: [0,p1)
        // 1: [p1,i)
        // 2: (p2,len-1]
        int p1 = 0;
        int p2 = nums.length - 1;
        for (int i = 0; i <= p2;) {
            if (nums[i] == 0) {
                swap(nums, p1, i);
                p1++;
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                // 右边交换不i++
                swap(nums, i, p2);
                p2--;
            }
        }
    }

    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}
