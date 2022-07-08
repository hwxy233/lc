package com.hwxy.code.leetcode.order.l300.l295;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.function.ToIntFunction;

/**
 * 295. 数据流的中位数
 * https://leetcode.cn/problems/find-median-from-data-stream/submissions/
 * 
 * @author hwxy
 * @date 2022/07/06
 **/
public class Lc295 {

}


class MedianFinder {
    /**
     * 升序但是存较大的一半
     */
    private final Queue<Integer> escBigQueue;
    /**
     * 降序但是存较小的一半
     */
    private final Queue<Integer> descSmallQueue;

    public static final double TWO_D = 2D;

    public MedianFinder() {
        escBigQueue = new PriorityQueue<>(Integer::compare);
        descSmallQueue = new PriorityQueue<>(
                Comparator.comparingInt((ToIntFunction<Integer>) value -> value).reversed());

    }

    /**
     * 每次较先放到另一个再放到目的的
     * 
     * @param num
     */
    public void addNum(int num) {
        // 保证descSmallQueue是长度较长的
        if (escBigQueue.size() == descSmallQueue.size()) {
            escBigQueue.offer(num);
            descSmallQueue.offer(escBigQueue.poll());
        } else {
            descSmallQueue.offer(num);
            escBigQueue.offer(descSmallQueue.poll());
        }
    }

    public double findMedian() {
        if (descSmallQueue.isEmpty()) {
            return Double.MAX_VALUE;
        }
        if (escBigQueue.size() == descSmallQueue.size()) {
            return (escBigQueue.peek() + descSmallQueue.peek()) / TWO_D;
        } else {
            return descSmallQueue.peek();
        }
    }
}
