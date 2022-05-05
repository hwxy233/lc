package com.hwxy.code.leetcode.order.l100.l11;

/**
 * 11. 盛最多水的容器
 * https://leetcode-cn.com/problems/container-with-most-water/
 * 
 * @author hwxy
 * @date 2022/05/05
 **/
public class Lc11 {
    /**
     * 反正是双指针,一前一后的那种
     * 
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int ans = 0;
        for (int left = 0, right = height.length - 1; left < right;) {
            // 乘积是较小的高度*距离
            ans = Math.max(ans, (right - left) * Math.min(height[left], height[right]));
            // 每次移动较小的高度的指针
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }
}
