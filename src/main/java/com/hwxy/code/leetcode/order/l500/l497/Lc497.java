package com.hwxy.code.leetcode.order.l500.l497;

import java.util.Arrays;
import java.util.Random;

import com.hwxy.code.utils.JsonUtil;

/**
 * 497. 非重叠矩形中的随机点
 * https://leetcode.cn/problems/random-point-in-non-overlapping-rectangles/
 * 
 * @author hwxy
 * @date 2022/06/09
 **/
public class Lc497 {
    public static void main(String[] args) {
        Solution solution =
                new Solution(JsonUtil.convertToT("[[-2, -2, 1, 1], [2, 2, 4, 6]]", int[][].class));

        System.out.println(Arrays.toString(solution.pick()));
        System.out.println(Arrays.toString(solution.pick()));
        System.out.println(Arrays.toString(solution.pick()));
        System.out.println(Arrays.toString(solution.pick()));
        System.out.println(Arrays.toString(solution.pick()));
    }
}


class Solution {
    private final int[][] rects;
    private final Random rectRandom;
    /**
     * 因为是等概率所以直接在rects随机不等的因为各矩形的面积不同
     * 所以要按照面积随机,然后二分找到矩形
     * 再在矩形里随机
     */
    private final int[] preSum;

    public Solution(int[][] rects) {
        this.rects = rects;
        rectRandom = new Random();
        preSum = new int[rects.length];
        for (int i = 0; i < rects.length; i++) {
            int sum = (rects[i][2] - rects[i][0] + 1) * (rects[i][3] - rects[i][1] + 1);
            if (i > 0) {
                sum += preSum[i - 1];
            }
            preSum[i] = sum;
        }
    }

    public int[] pick() {
        int sumRandom = rectRandom.nextInt(preSum[preSum.length - 1]);
        int rectIndex = binarySearch(sumRandom + 1);
        int[] rect = rects[rectIndex];
        // 在矩形里随机
        int[] ans = new int[2];
        int xLength = rect[2] - rect[0];
        int yLength = rect[3] - rect[1];
        ans[0] = rect[0] + rectRandom.nextInt(xLength + 1);
        ans[1] = rect[1] + rectRandom.nextInt(yLength + 1);
        return ans;
    }

    private int binarySearch(int sumRandom) {
        int l = -1;
        // 注意这里是length(length-1+1)不是length+1
        int r = preSum.length;
        // isBlue为<sumRandom,返回r
        while (l + 1 != r) {
            int m = (l + r) >> 1;
            if (preSum[m] < sumRandom) {
                l = m;
            } else {
                r = m;
            }
        }
        return r;
    }

}


/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */
