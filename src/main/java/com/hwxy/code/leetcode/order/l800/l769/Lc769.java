package com.hwxy.code.leetcode.order.l800.l769;

/**
 * 769. 最多能完成排序的块
 * https://leetcode.cn/problems/max-chunks-to-make-sorted/
 *
 * @author hwxy
 * @date 2022/10/13
 **/
public class Lc769 {
    public int maxChunksToSorted(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int ans = 0;
        int max = -1;
        // 贪心,每次找最大值,只有当最大值为当前下标时说明前面的可以是一组
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            if (max == i) {
                ans++;
            }
        }
        return ans;
    }
}
