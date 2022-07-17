package com.hwxy.code.leetcode.order.l6200.l6164;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 6164. 数位和相等数对的最大和
 * https://leetcode.cn/contest/weekly-contest-302/problems/max-sum-of-a-pair-with-equal-sum-of-digits/
 * 
 * @author hwxy
 * @date 2022/07/17
 **/
public class Lc6164 {
    public int maximumSum(int[] nums) {
        if (nums == null) {
            return -1;
        }
        Map<Integer, PriorityQueue<Integer>> sumNums = new HashMap<>();
        int ans = -1;
        for (int num : nums) {
            int sum = getSum(num);
            PriorityQueue<Integer> queue = sumNums.get(sum);
            if (queue == null) {
                queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
                sumNums.put(sum, queue);
            } else {
                ans = Math.max(ans, num + queue.peek());
            }
            queue.add(num);
        }
        return ans;
    }

    private int getSum(int num) {
        if (num < 10) {
            return num;
        }
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
