package com.hwxy.code.leetcode.order.l1200.l1151;

import java.util.Arrays;

/**
 * 1051. 高度检查器
 * https://leetcode.cn/problems/height-checker/
 * 
 * @author hwxy
 * @date 2022/06/13
 **/
public class Lc1151 {
    public int heightChecker(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int[] old = Arrays.copyOf(heights, heights.length);
        Arrays.sort(heights);
        int ans = 0;
        for (int i = 0; i < old.length; i++) {
            if (old[i] != heights[i]) {
                ans++;
            }
        }
        return ans;
    }
}
