package com.hwxy.code.leetcode.order.l900.l870;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 870. 优势洗牌
 * https://leetcode.cn/problems/advantage-shuffle/
 *
 * @author hwxy
 * @date 2022/10/08
 **/
public class Lc870 {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length != nums2.length || nums1.length < 2) {
            return nums1;
        }
        int[] ans = new int[nums1.length];
        List<Integer> num1List = Arrays.stream(nums1).sorted().boxed().collect(Collectors.toList());
        // 二分,其实可以直接用TreeMap的highKey方法
        for (int i = 0; i < nums2.length; i++) {
            // 从num1中找>num2的最小值,找不到就取最小值
            int l = -1;
            int r = num1List.size();
            while (l + 1 != r) {
                int mid = (l + r) >> 1;
                if (isBlue(num1List, mid, nums2[i])) {
                    l = mid;
                } else {
                    r = mid;
                }
            }
            // l都是<=num2的,要取r
            if (r >= num1List.size()) {
                ans[i] = num1List.remove(0);
            } else {
                ans[i] = num1List.remove(r);
            }
        }
        return ans;
    }

    /**
     * 蓝红
     * 蓝: <=
     * 红: >
     *
     * @param num1List
     * @param mid
     * @param num2
     * @return
     */
    private boolean isBlue(List<Integer> num1List, int mid, int num2) {
        return num1List.get(mid) <= num2;
    }
}
