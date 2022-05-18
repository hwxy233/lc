package com.hwxy.code.leetcode.order.l400.l378;

/**
 * 378. 有序矩阵中第 K 小的元素
 * https://leetcode.cn/problems/kth-smallest-element-in-a-sorted-matrix/
 * 
 * @author hwxy
 * @date 2022/05/18
 **/
public class Lc378 {
    /**
     * 1. 是对值的数量做蓝红二分,不是下标
     * 2. 为什么值二分的结果一定在数组里?
     * 3. 因为返回时的结果是数组中第k小的结果
     * 4. 如果不在数组里,那么第k小的是谁呢?
     * 
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length <= 0 || k <= 0) {
            return 0;
        }
        // 红蓝2分;isBlue:<=target的数量<k,返回r
        int l = matrix[0][0] - 1;
        int r = matrix[matrix.length - 1][matrix.length - 1] + 1;
        while (l + 1 != r) {
            int mid = (l + r) >> 1;
            if (isBlue(matrix, mid) < k) {
                l = mid;
            } else {
                r = mid;
            }
        }
        return r;
    }

    /**
     * 总左下角开始计数
     * 
     * @param matrix
     * @param mid
     * @return
     */
    private int isBlue(int[][] matrix, int mid) {
        int cnt = 0;
        int row = matrix.length - 1;
        int column = 0;
        while (row >= 0 && column < matrix.length) {
            // 如果当前值<=mid,则进行计数,一次加一列的值
            if (matrix[row][column] <= mid) {
                cnt += row + 1;
                // 然后右移这样会更大
                column++;
            } else {
                // 小了上移会更小
                row--;
            }
        }
        return cnt;
    }
}
