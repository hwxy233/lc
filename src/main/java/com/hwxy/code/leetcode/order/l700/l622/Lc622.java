package com.hwxy.code.leetcode.order.l700.l622;

/**
 * 622. 设计循环队列
 * https://leetcode.cn/problems/design-circular-queue/
 * 
 * @author hwxy
 * @date 2022/08/02
 **/
public class Lc622 {}


class MyCircularQueue {
    private final int[] values;

    private int startIndex;

    private int endIndex;


    public MyCircularQueue(int k) {
        values = new int[k];
        startIndex = 0;
        endIndex = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        values[endIndex % values.length] = value;
        endIndex++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        startIndex++;
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return values[startIndex % values.length];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return values[(endIndex - 1) % values.length];
    }

    public boolean isEmpty() {
        return startIndex == endIndex;
    }

    public boolean isFull() {
        return endIndex - startIndex >= values.length;
    }
}
