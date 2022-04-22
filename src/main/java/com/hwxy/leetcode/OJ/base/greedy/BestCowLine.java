package com.hwxy.leetcode.OJ.base.greedy;

/**
 * 字典序最小
 * POJ 3617
 *
 * @author hwxy
 * @date 2021/03/27
 **/
public class BestCowLine {
    public static void main(String[] args) {
        System.out.println(getBestCowLine(6, new char[]{'A', 'C', 'D', 'B', 'C', 'B'}));
    }

    /**
     * 每次读取首尾
     * 构成一个字典序最小的
     *
     * @param n 字符串长度
     * @param s 字符串
     * @return 最小字典序
     */
    public static String getBestCowLine(int n, char[] s) {
        // 正反比较字符串
        int leftIndex = 0;
        int rightIndex = n - 1;
        StringBuilder result = new StringBuilder();
        // 用左边的还是右边的
        boolean isLeft = false;
        // 有等号因为相同时会少一个
        while (leftIndex <= rightIndex) {
            for (int i = 0; i < n; i++) {
                // 没有相等的情况，因为有可能会一直相同，这是用哪边都一样
                if (s[leftIndex + i] > s[rightIndex - i]) {
                    isLeft = false;
                    break;
                } else if (s[leftIndex + i] < s[rightIndex - i]) {
                    isLeft = true;
                    break;
                }
            }
            if (isLeft) {
                result.append(s[leftIndex]);
                leftIndex++;
            } else {
                result.append(s[rightIndex]);
                rightIndex--;
            }
        }
        return String.valueOf(result);
    }
}
