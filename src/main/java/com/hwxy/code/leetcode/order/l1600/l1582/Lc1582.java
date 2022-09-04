package com.hwxy.code.leetcode.order.l1600.l1582;

/**
 * 1582. 二进制矩阵中的特殊位置
 *
 * <p><a href="https://leetcode.cn/problems/special-positions-in-a-binary-matrix/">题目链接</a>
 *
 * @author hwxy
 * @date 2022/09/04
 */
public class Lc1582 {
    public int numSpecial(int[][] mat) {
        if (mat == null || mat.length == 0) {
            return 0;
        }
        // 求每行和每列的sum,然后特殊位必然是那个位置是1但是同行列为0所以sum都为1才行
        int[] lineSum = new int[mat.length];
        int[] columnSum = new int[mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                lineSum[i] += mat[i][j];
                columnSum[j] += mat[i][j];
            }
        }
        int ans = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] != 1) {
                    continue;
                }
                if (lineSum[i] - mat[i][j] == 0 && columnSum[j] - mat[i][j] == 0) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
