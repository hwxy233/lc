package com.hwxy.leetcode.order.l2100.lc2006;

import java.util.*;

/**
 * 2006. 差的绝对值为 K 的数对数目
 * https://leetcode-cn.com/problems/count-number-of-pairs-with-absolute-difference-k/
 * 
 * @author hwxy
 * @date 2022/02/09
 **/
public class Lc2006 {

    public static void main(String[] args) {
        System.out.println(10 % 8);
    }

    public int countKDifference(int[] nums, int k) {
        if (nums == null) {
            return 0;
        }
        // return f1(nums, k);
        return f2(nums, k);
    }

    private int f2(int[] nums, int k) {
        Map<Integer, Integer> valueIndexCount = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            res += valueIndexCount.getOrDefault(k + num, 0)
                    + valueIndexCount.getOrDefault(-k + num, 0);
            // 由于是顺序的前到后的遍历所以,只要按序保存就可以保证 i < j
            valueIndexCount.put(num, valueIndexCount.getOrDefault(num, 0) + 1);
        }
        return res;
    }

    private int f1(int[] nums, int k) {
        // hash表记录值和下表数组，比较大于下标的数量
        Map<Integer, List<Integer>> valueIndexes = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            valueIndexes.computeIfAbsent(nums[i], key -> new ArrayList<>()).add(i);
        }
        for (List<Integer> list : valueIndexes.values()) {
            Collections.sort(list);
        }
        // 遍历找下标打的
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            List<Integer> indexes = valueIndexes.get(k + val);
            if (indexes != null) {
                res += calCnt(i, indexes);
            }
            indexes = valueIndexes.get(-k + val);
            if (indexes != null) {
                res += calCnt(i, indexes);
            }
        }
        return res;
    }

    private int calCnt(int index, List<Integer> indexes) {
        int smallCnt = 0;
        for (int i : indexes) {
            if (i > index) {
                break;
            }
            smallCnt++;
        }
        return indexes.size() - smallCnt;
    }
}
