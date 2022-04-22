package com.hwxy.leetcode.order.l400.l349;

import java.util.HashSet;
import java.util.Set;

/**
 * 349. 两个数组的交集
 * https://leetcode-cn.com/problems/intersection-of-two-arrays/
 *
 * @author hwxy
 * @date 2022/01/31
 **/
public class Lc349 {
    /**
     * HashSet记录
     * 
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return nums1;
        }
        Set<Integer> h1 = new HashSet<>(nums1.length);
        Set<Integer> res = new HashSet<>(nums2.length);
        for (int i : nums1) {
            h1.add(i);
        }
        for (int i : nums2) {
            if (h1.contains(i)) {
                res.add(i);
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
}
