package com.hwxy.code.leetcode.order.l700.l641;

/**
 * 641. 设计循环双端队列
 * https://leetcode.cn/problems/design-circular-deque/
 * 
 * @author hwxy
 * @date 2022/08/15
 **/
public class Lc641 {}


class MyCircularDeque {

    private final int maxSize;

    private int size;

    private int head;

    private int tail;

    private final int[] values;

    /**
     * 有几个坑
     * 1. head和tail定义为可以取到
     * 2. head相当于是add为--,delete为++,初始化为0
     * 3. tail相当于是add为++,delete为--,初始化为-1,当tail为-1并且取tail时要用head和size计算出tail
     * 4. 所有操作要对maxSize求模
     * 
     * @param k
     */
    public MyCircularDeque(int k) {
        maxSize = k;
        values = new int[maxSize];
        size = 0;
        head = 0;
        tail = -1;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        head = (head - 1 + maxSize) % maxSize;
        values[head] = value;
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        tail = (tail + 1 + maxSize) % maxSize;
        values[tail] = value;
        size++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        head = (head + 1 + maxSize) % maxSize;
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        tail = (tail - 1 + maxSize) % maxSize;
        size--;
        return true;
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        // head初始化为0
        // if (head == -1) {
        // return values[tail - size + 1];
        // }
        return values[head];
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        if (tail == -1) {
            return values[head + size - 1];
        }
        return values[tail];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == maxSize;
    }
}
