package com.hwxy.code.leetcode.order.l500.l454;

import java.util.HashMap;
import java.util.Map;

/**
 * 454. 四数相加 II
 * https://leetcode-cn.com/problems/4sum-ii/
 *
 * @author hwxy
 * @date 2022/01/31
 **/
public class Lc454 {
    public static void main(String[] args) {
        System.out.println(new Lc454().fourSumCount(new int[] {1, 2}, new int[] {-2, -1},
                new int[] {-1, 2}, new int[] {0, 2}));
    }


    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        if (nums1 == null ||
                nums2 == null ||
                nums3 == null ||
                nums4 == null) {
            return 0;
        }
        // 保存ab的和
        Map<Integer, Integer> abSumCount = new HashMap<>(nums1.length);
        for (int i : nums1) {
            for (int j : nums2) {
                int sum = i + j;
                if (abSumCount.containsKey(sum)) {
                    abSumCount.put(sum, abSumCount.get(sum) + 1);
                } else {
                    abSumCount.put(sum, 1);
                }
            }
        }
        int count = 0;
        // 遍历cd
        for (int i : nums3) {
            for (int j : nums4) {
                // 检查abSumCount是否有0-(c+d)
                int sum = i + j;
                Integer abCnt = abSumCount.get(-sum);
                if (abCnt != null) {
                    count += abCnt;
                }
            }
        }
        return count;
    }
}
