package com.hwxy.code.leetcode.order.l1700.l1619;

import java.util.Arrays;

/**
 * 1619. 删除某些元素后的数组均值
 * https://leetcode.cn/problems/mean-of-array-after-removing-some-elements/
 *
 * @author hwxy
 * @date 2022/09/14
 */
public class Lc1619 {
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        double sum = 0;
        int start = arr.length / 20;
        int end = arr.length - start;
        for (int i = start; i < end; i++) {
            sum += arr[i];
        }
        return sum / (end - start);
    }
}
