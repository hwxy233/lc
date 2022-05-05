package com.hwxy.code.leetcode.order.l2100.l2055;

import java.util.Arrays;

/**
 * 2055. 蜡烛之间的盘子
 * https://leetcode-cn.com/problems/plates-between-candles/
 * 
 * @author hwxy
 * @date 2022/03/08
 **/
public class Lc2055 {
    public static void main(String[] args) {
        // System.out.println(
        // Arrays.toString(new Lc2055().platesBetweenCandles("**|**|***|",
        // new int[][] {{2, 5}, {5, 9}})));
        System.out.println(
                Arrays.toString(new Lc2055().platesBetweenCandles("***|**|*****|**||**|*",
                        new int[][] {{1, 17}, {4, 5}, {14, 17}, {5, 11}, {15, 16}})));
    }

    public int[] platesBetweenCandles(String s, int[][] queries) {
        char[] sc = s.toCharArray();
        // 找到第一个'|'然后开始计算
        int stat = 0;
        while (stat < sc.length && sc[stat] != '|') {
            stat++;
        }
        int pSize = 0;
        // 到i为止'|'所累计的'*'的数量
        int[] pSizeArray = new int[sc.length];
        for (int i = stat; i < sc.length; i++) {
            if (sc[i] == '*') {
                pSize++;
            } else {
                pSizeArray[i] = pSize;
            }
        }
        // 记录下|的位置,pIndexLeft距离左边最近的|的下标
        int[] pIndexLeft = new int[sc.length];
        for (int i = 0, l = -1; i < sc.length; i++) {
            if (sc[i] == '|') {
                l = i;
            }
            pIndexLeft[i] = l;
        }
        // pIndexRight距离右边最近的|的下标
        int[] pIndexRight = new int[sc.length];
        for (int i = sc.length - 1, l = -1; i >= 0; i--) {
            if (sc[i] == '|') {
                l = i;
            }
            pIndexRight[i] = l;
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            // 从query的前后找到'|'的位置然后用2个|的*的数量相减
            int[] query = queries[i];
            int start = query[0];
            int end = query[1];
            // 找到start右边和end左边的|
            if (pIndexLeft[end] == -1 || pIndexRight[start] == -1
                    || pIndexLeft[end] <= pIndexRight[start]) {
                continue;
            }
            res[i] = pSizeArray[pIndexLeft[end]] - pSizeArray[pIndexRight[start]];
        }
        return res;
    }
}
