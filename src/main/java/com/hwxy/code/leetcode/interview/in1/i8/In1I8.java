package com.hwxy.code.leetcode.interview.in1.i8;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 面试题 01.08. 零矩阵
 * https://leetcode.cn/problems/zero-matrix-lcci/
 *
 * @author hwxy
 * @date 2022/09/30
 **/
public class In1I8 {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        Set<Integer> zeroLines = new HashSet<>();
        Set<Integer> zeroColumns = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    zeroLines.add(i);
                    zeroColumns.add(j);
                }
            }
        }
        for (int line : zeroLines) {
            Arrays.fill(matrix[line], 0);
        }
        for (int column : zeroColumns) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][column] = 0;
            }
        }
    }
}
