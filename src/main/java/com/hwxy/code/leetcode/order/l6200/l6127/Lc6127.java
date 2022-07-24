package com.hwxy.code.leetcode.order.l6200.l6127;

import java.util.*;

import com.hwxy.code.utils.JsonUtil;

/**
 * 6127. 优质数对的数目
 * https://leetcode.cn/contest/weekly-contest-303/problems/number-of-excellent-pairs/
 * 
 * @author hwxy
 * @date 2022/07/24
 **/
public class Lc6127 {

    public static void main(String[] args) {
        System.out.println(
                new Lc6127().countExcellentPairs(JsonUtil.convertToIntArray("[1,2,3,1]"), 3));
    }

    private long ans = 0;

    public long countExcellentPairs(int[] nums, int k) {
        Arrays.sort(nums);
        // 防止重复
        Set<Integer> used = new HashSet<>();
        Map<Integer, Integer> bitCount = new HashMap<>();
        for (int num : nums) {
            if (used.add(num)) {
                int bits = Integer.bitCount(num);
                bitCount.put(bits, bitCount.getOrDefault(bits, 0) + 1);
            }
        }
        // 根据容斥定理, 根据容斥原理 ∣A∪B∣=∣A∣+∣B∣−∣A∩B∣
        // 所以∣A∪B∣+∣A∩B∣=∣A∣+∣B∣
        long ans = 0;
        for (Map.Entry<Integer, Integer> entry1 : bitCount.entrySet()) {
            for (Map.Entry<Integer, Integer> entry2 : bitCount.entrySet()) {
                if (entry1.getKey() + entry2.getKey() >= k) {
                    // 组合数等于2个数量相乘
                    ans += (long) entry1.getValue() * entry2.getValue();
                }
            }
        }
        return ans;
    }

}
