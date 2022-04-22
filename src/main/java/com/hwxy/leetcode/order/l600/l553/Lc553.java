package com.hwxy.leetcode.order.l600.l553;

/**
 * 553. 最优除法
 * https://leetcode-cn.com/problems/optimal-division/
 * 
 * @author hwxy
 * @date 2022/02/27
 **/
public class Lc553 {
    public static void main(String[] args) {
        System.out.println(new Lc553().optimalDivision(new int[] {1000, 100, 10, 2}));
        System.out.println(new Lc553().optimalDivision(new int[] {3, 2}));
    }

    public String optimalDivision(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        if (nums.length == 1) {
            return String.valueOf(nums[0]);
        }
        // 直接在第二个加括号就行...
        StringBuilder sb = new StringBuilder();
        sb.append(nums[0]).append("/");
        if (nums.length == 2) {
            sb.append(nums[1]);
            return sb.toString();
        }
        sb.append("(");
        for (int i = 1; i < nums.length; i++) {
            sb.append(nums[i]);
            if (i == nums.length - 1) {
                sb.append(")");
            } else {
                sb.append("/");
            }
        }
        return sb.toString();
    }
}
