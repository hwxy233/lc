package com.hwxy.leetcode.OJ.ds.heap;

import lombok.Data;

import java.util.Arrays;
import java.util.Objects;

/**
 * 堆结构
 *
 * @author hwxy
 * @date 2021/07/03
 **/
@Data
public class Heap {
    /**
     * 实际上不是二叉树而是用数组存
     */
    private int[] heapArr;

    /**
     * 堆大小
     */
    private int heapSize;

    /**
     * 构建堆
     * 小到大
     *
     * @param arr
     */
    public Heap(int[] arr) {
        if (Objects.isNull(arr) || arr.length == 0) {
            throw new RuntimeException("参数长度不能为空");
        }
        // 申请的时候多申请1个位置
        heapSize = arr.length;
        heapArr = new int[heapSize + 1];
        // 我去终于支持初始化了吗
        Arrays.fill(heapArr, Integer.MAX_VALUE);
        // 遍历arr进行push, i=1从下到上
        for (int i = 0; i < heapSize; i++) {
            push(i + 1, arr[i]);
        }
    }

    /**
     * push到堆里
     * 孩子节点为i
     * 父亲节点为（i-1）/2
     * 从下向上移动
     *
     * @param i       下标
     * @param element 元素值
     */
    private void push(int i, int element) {
        while (i > 0) {
            int p = (i - 1) / 2;
            // 肯定是父 <= 子
            if (heapArr[p] <= element) {
                break;
            }
            // 父 > 子了就把子的值改为父的值
            heapArr[i] = heapArr[p];
            // 然后子变成新的父
            i = p;
        }
        // 最后i就是合适的位置了
        heapArr[i] = element;
    }

    /**
     * 把最小值给pop出去
     *
     * @return
     */
    public int pop() {
        if (heapSize <= 0) {
            throw new RuntimeException("没有了");
        }
        // 拿出根
        int ret = heapArr[0];
        // 最大值要放到根部颠倒一边,heapSize要先减小
        int max = heapArr[--heapSize];
        // 从头开始
        int i = 0;
        // 左子节点编号
        while (i * 2 + 1 < heapSize) {
            int left = i * 2 + 1;
            int right = i * 2 + 2;
            // 找出左和右里面的小的
            if (right < heapSize && heapArr[right] < heapArr[left]) {
                left = right;
            }
            if (heapArr[left] >= max) {
                break;
            }
            // 和push一样了
            heapArr[i] = heapArr[left];
            i = left;
        }
        heapArr[i] = max;
        return ret;
    }

    public static void main(String[] args) {
        Heap heap = new Heap(new int[]{3, 5, 1, 2, 7, 5, 0});
        System.out.println(Arrays.toString(heap.getHeapArr()));
        System.out.println(heap.pop());
        System.out.println(heap.pop());
        System.out.println(heap.pop());
        System.out.println(heap.pop());
        System.out.println(heap.pop());
        System.out.println(heap.pop());
        System.out.println(heap.pop());
        System.out.println(heap.pop());
        System.out.println(Arrays.toString(heap.getHeapArr()));

    }
}
