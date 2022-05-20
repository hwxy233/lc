package com.hwxy.code.leetcode.order.l500.l436;

import java.util.*;

/**
 * 436. 寻找右区间
 * https://leetcode.cn/problems/find-right-interval/
 * 
 * @author hwxy
 * @date 2022/05/20
 **/
public class Lc436 {
    public static final int[] BAD_ANS = new int[] {-1};

    /**
     * 1. 对每个右区间二分搜索,找出>=有区间的最小的做区间,可能没有做区间
     * 2. 可以用二维数组排序代替HashMap和List的存储
     * 
     * @param intervals
     * @return
     */
    public int[] findRightInterval(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return BAD_ANS;
        }
        // 找一个大于等于右区间的最小最区间
        Map<Integer, Integer> leftValueIndex = new HashMap<>();
        for (int i = 0; i < intervals.length; i++) {
            leftValueIndex.putIfAbsent(intervals[i][0], i);
        }
        int[] ans = new int[intervals.length];
        // 对每个右区间二分搜索,找出>=有区间的最小的做区间,可能没有做区间
        List<Integer> leftValues = new ArrayList<>(leftValueIndex.keySet());
        Collections.sort(leftValues);
        for (int i = 0; i < intervals.length; i++) {
            // 找一个大于等于右区间的最小最区间
            Integer leftValue = binarySearch(leftValues, intervals[i][1]);
            if (leftValue == null) {
                ans[i] = -1;
            } else {
                ans[i] = leftValueIndex.get(leftValue);
            }
        }
        return ans;
    }

    /**
     * 找下标,不要找值,找值可能不在
     * 
     * @param leftValues
     * @param rightValue
     * @return
     */
    private Integer binarySearch(List<Integer> leftValues, int rightValue) {
        int l = -1;
        int r = leftValues.size() + 1;
        while (l + 1 != r) {
            // isBlue:<rightValue;返回r
            int mid = (l + r) >> 1;
            if (mid >= leftValues.size()) {
                return null;
            }
            if (leftValues.get(mid) < rightValue) {
                l = mid;
            } else {
                r = mid;
            }
        }
        if (r >= leftValues.size()) {
            return null;
        }
        return leftValues.get(r);
    }

}
