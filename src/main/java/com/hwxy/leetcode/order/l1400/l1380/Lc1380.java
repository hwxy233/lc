package com.hwxy.leetcode.order.l1400.l1380;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 1380. 矩阵中的幸运数
 * https://leetcode-cn.com/problems/lucky-numbers-in-a-matrix/
 * 
 * @author hwxy
 * @date 2022/02/15
 **/
public class Lc1380 {
    /**
     * 用一个数组存行的最小值
     * 用一个Set存列的最大值
     * 如果数组的值在Set中存在则是幸运树
     * 
     * @param matrix
     * @return
     */
    public List<Integer> luckyNumbers(int[][] matrix) {
        int[] lineMinValues = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            int lineMin = Integer.MAX_VALUE;
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] < lineMin) {
                    lineMin = matrix[i][j];
                }
            }
            lineMinValues[i] = lineMin;
        }
        Set<Integer> columnMaxValues = new HashSet<>();
        for (int i = 0; i < matrix[0].length; i++) {
            int columnMax = Integer.MIN_VALUE;
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[j][i] > columnMax) {
                    columnMax = matrix[j][i];
                }
            }
            columnMaxValues.add(columnMax);
        }
        List<Integer> res = new LinkedList<>();
        for (int lm : lineMinValues) {
            if (columnMaxValues.contains(lm)) {
                res.add(lm);
            }
        }
        return res;
    }
}
