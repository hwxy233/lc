package com.hwxy.code.OJ.ds.heap.expedition;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.function.ToIntFunction;

/**
 * 加油站问题
 * POJ 2431
 *
 * @author hwxy
 * @date 2021/07/03
 **/
public class Expedition {
    private static int[] A;
    private static int[] B;

    /**
     * 变量定义同上
     *
     * @param l 行驶距离
     * @param p 油箱的油量
     * @param n 加油站数量
     * @param a 加油站距离
     * @param b 加油站的油量
     * @return
     */
    public static int solve(int l, int p, int n, int[] a, int[] b) {
        if (Objects.isNull(a) || Objects.isNull(b)) {
            return -1;
        }
        // 大到小排序的堆
        PriorityQueue<Integer> heap = new PriorityQueue<>(
                Comparator.comparingInt((ToIntFunction<Integer>) value -> value).reversed());
        // 多申请一个
        A = Arrays.copyOf(a, n + 1);
        B = Arrays.copyOf(b, n + 1);
        // 把最后一个位置当做加油站,油量为0
        A[n] = l;
        B[n] = 0;
        // 加油次数
        int count = 0;
        // 当前位置
        int pos = 0;
        // 剩余油量
        int tank = p;

        for (int i = 0; i < n; i++) {
            // 距离下个加油站的距离
            int d = A[i] - pos;
            // 不断加油直到能走到下个加油站
            while (tank - d < 0) {
                // 到不了下一站
                if (heap.isEmpty()) {
                    return -1;
                }
                // 加了
                tank += heap.poll();
                count++;
            }
            tank -= d;
            // 这就看出来最后一个也是加油站的好处了
            pos = A[i];
            heap.add(B[i]);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(solve(25, 10, 4, new int[] {10, 14, 20, 21}, new int[] {10, 5, 2, 4}));
    }
}
