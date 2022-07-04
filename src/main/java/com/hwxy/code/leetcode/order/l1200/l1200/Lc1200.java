package com.hwxy.code.leetcode.order.l1200.l1200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 1200. 最小绝对差
 * https://leetcode.cn/problems/minimum-absolute-difference/
 * 
 * @author hwxy
 * @date 2022/07/04
 **/
public class Lc1200 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        if (arr == null || arr.length == 0) {
            return Collections.emptyList();
        }
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        List<List<Integer>> ans = new ArrayList<>();
        for (int left = 0, right = 1; right < arr.length; left++, right++) {
            int curDiff = Math.abs(arr[left] - arr[right]);
            if (curDiff > min) {
                continue;
            }
            if (curDiff < min) {
                ans.clear();
                min = curDiff;
            }
            ans.add(Arrays.asList(arr[left], arr[right]));
        }
        return ans;
    }
}
