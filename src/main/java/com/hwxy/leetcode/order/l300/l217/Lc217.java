package com.hwxy.leetcode.order.l300.l217;

import java.util.HashSet;
import java.util.Set;

/**
 * 217. 存在重复元素
 * https://leetcode-cn.com/problems/contains-duplicate/
 *
 * @author hwxy
 * @date 2022/05/03
 **/
public class Lc217 {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        Set<Integer> contains = new HashSet<>();
        for (int num : nums) {
            if (!contains.add(num)) {
                return true;
            }
        }
        return false;
    }
}
