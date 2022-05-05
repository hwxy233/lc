package com.hwxy.code.leetcode.order.l100.l15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 干嘛的
 *
 * @author hwxy
 * @date 2022/05/05
 **/
public class Lc15NeetCode {
    /**
     * 先排序
     * 然后双指针用nums[i]的负数当做sum去找2个数的和是否为sum
     * 注意相邻相同元素去重,可以在向结果集存入结果之后进行去重
     * 
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return Collections.emptyList();
        }
        // 先排序
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        // 遍历到倒数第三个就行,并且要是<=0的值才有可能凑出0来
        for (int i = 0; i < nums.length - 2 && nums[i] <= 0; i++) {
            // 相同的都过滤掉
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 把当前的数的负数当做sum,如果还能有2个数的和凑成sum就行
            int sum = nums[i] * -1;
            // 双指针找sum
            for (int left = i + 1, right = nums.length - 1; left < right;) {
                int tpSum = nums[left] + nums[right];
                if (tpSum > sum) {
                    right--;
                } else if (tpSum < sum) {
                    left++;
                } else {
                    // 有可能有多个组合可以凑出来
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 如果相邻相等了应该跳过,这里左向右会停在最后一个相同的位置
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right
                            && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                }
            }
        }
        return res;
    }
}
