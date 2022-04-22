package com.hwxy.leetcode.order.l900.l806;

import java.util.Arrays;

/**
 * 干嘛的
 * 
 * @author hwxy
 *
 * @date 2022/04/12
 **/
public class Lc806 {
    public static void main(String[] args) {
        System.out
                .println(
                        Arrays.toString(new Lc806().numberOfLines(
                                new int[] {4, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
                                        10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
                                "bbbcccdddaaa")));
    }

    public int[] numberOfLines(int[] widths, String s) {
        if (widths == null || s == null) {
            return null;
        }
        // 初始化为1行余0个
        int[] res = new int[] {1, 0};
        for (char c : s.toCharArray()) {
            res[1] += widths[c - 'a'];
            // 有可能加上最后一个后超过了100,这时需要换行
            if (res[1] > 100) {
                res[0]++;
                res[1] = widths[c - 'a'];
            }
        }
        return res;
    }
}
