package com.hwxy.order.l300.l209;

/**
 * 209. 长度最小的子数组
 * https://leetcode-cn.com/problems/minimum-size-subarray-sum/
 *
 * @author hwxy
 * @date 2022/01/30
 **/
public class Lc209 {
    public static void main(String[] args) {
        System.out.println(new Lc209().minSubArrayLen(7, new int[] {2, 3, 1, 2, 4, 3}));
    }

    public int minSubArrayLen(int target, int[] nums) {
        // return f1(target, nums);
        return f2(target, nums);
    }

    /**
     * 双for循环
     * 
     * @param target
     * @param nums
     * @return
     */
    private int f1(int target, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= target) {
                    int subLength = j - i + 1;
                    res = Math.min(res, subLength);
                    break;
                }
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    /**
     * 滑动窗口
     * 
     * @param target
     * @param nums
     * @return
     */
    private int f2(int target, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int res = Integer.MAX_VALUE;
        int sum = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            // 不断缩小需要while
            while (sum >= target) {
                int subLen = right - left + 1;
                res = Math.min(res, subLen);
                // 该调整窗口大小了,缩小窗口
                sum -= nums[left++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
