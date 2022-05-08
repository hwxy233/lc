package com.hwxy.code.leetcode.order.l500.l442;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 442. 数组中重复的数据
 * https://leetcode-cn.com/problems/find-all-duplicates-in-an-array/
 * 
 * @author hwxy
 * @date 2022/05/08
 **/
public class Lc442 {
    /**
     * 原地哈希
     * 题目说了nums[i]的范围是[1,n]最多出现2次
     * 所以原地交换,只要nums[i]只出现1次则必定在nums[i]-1的位置,
     * nums[i] != nums[nums[i] - 1]不断进行交换,最后只要nums[i]-1!=i的都是结果
     * 
     * @param nums
     * @return
     */
    public List<Integer> findDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }
        for (int i = 0; i < nums.length; i++) {
            // 本质上就是 nums[i] != i
            while (nums[i] != nums[nums[i] - 1]) {
                // 不能这么写,因为nums[i]的值改变了
                // int tmp = nums[i];
                // nums[i] = nums[nums[i] - 1];
                // nums[nums[i] - 1] = tmp;
                swap(nums, i, nums[i] - 1);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - 1 != i) {
                ans.add(nums[i]);
            }
        }
        return ans;
    }

    public void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
