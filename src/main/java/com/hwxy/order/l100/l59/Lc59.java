package com.hwxy.order.l100.l59;

import java.util.Arrays;

/**
 * 59. 螺旋矩阵 II
 * https://leetcode-cn.com/problems/spiral-matrix-ii/
 *
 * @author hwxy
 * @date 2022/01/30
 **/
public class Lc59 {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Lc59().generateMatrix(3)));
    }


    public int[][] generateMatrix(int n) {
        if (n < 1) {
            return null;
        }
        int[][] res = new int[n][n];
        int startX = 0;
        int startY = 0;
        int loop = n / 2;
        int count = 1;
        // 为保证左闭右开需要的区间终止条件
        int offset = 1;
        // 循环有限次数
        for (int l = 0; l < loop; l++) {
            // 上行(x不变y边,左闭右开)
            for (int i = startY; i < startY + n - offset; i++) {
                res[startX][i] = count++;
            }
            // 右列(x边y不变)
            for (int i = startX; i < startX + n - offset; i++) {
                res[i][startY + n - offset] = count++;
            }
            // 下行(x不变y边)
            for (int i = startY + n - offset; i > startY; i--) {
                res[startX + n - offset][i] = count++;
            }
            // 左列(x边y不变)
            for (int i = startX + n - offset; i > startX; i--) {
                res[i][startY] = count++;
            }
            // 缩圈
            startX++;
            startY++;
            offset += 2;
        }
        if (n % 2 == 1) {
            res[loop][loop] = count;
        }
        return res;
    }
}
