package com.hwxy.leetcode.order.l300.l239;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 239. 滑动窗口最大值
 * https://leetcode-cn.com/problems/sliding-window-maximum/
 * 
 * @author hwxy
 * @date 2022/02/01
 **/
public class Lc239 {
    public static void main(String[] args) {
        System.out.println(Arrays
                .toString(new Lc239().maxSlidingWindow(new int[] {1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        PQueue pQueue = new PQueue();
        for (int i = 0; i < k; i++) {
            pQueue.push(nums[i]);
        }
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        res[index++] = pQueue.peek();
        for (int i = k; i < nums.length; i++) {
            pQueue.pop(nums[i - k]);
            pQueue.push(nums[i]);
            res[index++] = pQueue.peek();
        }
        return res;
    }

    /**
     * 单调队列
     */
    private static class PQueue {
        private Deque<Integer> queue;

        PQueue() {
            queue = new LinkedList<>();
        }

        /**
         * 只有等于队列头的值才pop
         * 
         * @param val
         */
        void pop(int val) {
            if (queue.isEmpty() || val != queue.peekFirst()) {
                return;
            }
            queue.pollFirst();
        }

        /**
         * 
         * @param val
         */
        void push(int val) {
            while (!queue.isEmpty() && val > queue.peekLast()) {
                queue.pollLast();
            }
            queue.addLast(val);
        }

        int peek() {
            return queue.peekFirst();
        }
    }
}
