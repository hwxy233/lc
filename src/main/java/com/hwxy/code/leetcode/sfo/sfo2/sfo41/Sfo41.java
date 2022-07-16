package com.hwxy.code.leetcode.sfo.sfo2.sfo41;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 剑指 Offer II 041. 滑动窗口的平均值
 * https://leetcode.cn/problems/qIsx9U/
 * 
 * @author hwxy
 * @date 2022/07/16
 **/
public class Sfo41 {}


class MovingAverage {

    private final Queue<Integer> queue;

    private double sum;

    private final int maxSize;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        if (size < 1) {
            throw new IllegalArgumentException();
        }
        queue = new ArrayDeque<>(size + 1);
        sum = 0;
        maxSize = size;
    }

    public double next(int val) {
        queue.offer(val);
        sum += val;
        if (queue.size() > maxSize) {
            sum -= queue.poll();
        }
        return sum / queue.size();
    }
}
