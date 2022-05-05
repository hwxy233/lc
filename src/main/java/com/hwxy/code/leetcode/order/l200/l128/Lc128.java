package com.hwxy.code.leetcode.order.l200.l128;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 128. 最长连续序列
 * https://leetcode-cn.com/problems/longest-consecutive-sequence/
 * 
 * @author hwxy
 * @date 2022/05/04
 **/
public class Lc128 {
    /**
     * 用一个Set去记录所有的不重复的num
     * 然后对每个num不断+1看看Set里有没有
     * 
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        int ans = 1;
        for (int num : nums) {
            // 说明从这里开始时序列的第一个
            if (!numSet.contains(num - 1)) {
                int length = 1;
                // 先+1
                while (numSet.contains(++num)) {
                    length++;
                }
                ans = Math.max(ans, length);
            }
        }
        return ans;
    }
}
