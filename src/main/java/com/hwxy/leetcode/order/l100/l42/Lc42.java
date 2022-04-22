package com.hwxy.leetcode.order.l100.l42;

/**
 * 42. 接雨水
 * https://leetcode-cn.com/problems/trapping-rain-water/
 *
 * @author hwxy
 * @date 2022/02/01
 **/
public class Lc42 {
    public static void main(String[] args) {
        System.out.println(new Lc42().trap(new int[] {4, 2, 0, 3, 2, 5}));
    }


    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            // 收尾不计算
            if (i == 0 || i == height.length - 1) {
                continue;
            }
            int lHeight = height[i];
            int rHeight = height[i];
            // 找出左右的最大高度
            for (int r = i + 1; r < height.length; r++) {
                rHeight = Math.max(height[r], rHeight);
            }
            // 注意>=0
            for (int l = i - 1; l >= 0; l--) {
                lHeight = Math.max(height[l], lHeight);
            }
            // 左右最大高度的最小值 - 当前高度就是雨水
            res += Math.min(lHeight, rHeight) - height[i];
        }
        return res;
    }
}
