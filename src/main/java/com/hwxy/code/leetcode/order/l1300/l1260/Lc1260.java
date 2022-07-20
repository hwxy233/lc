package com.hwxy.code.leetcode.order.l1300.l1260;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 1260. 二维网格迁移
 * https://leetcode.cn/problems/shift-2d-grid/
 * 
 * @author hwxy
 * @date 2022/07/20
 **/
public class Lc1260 {

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        if (grid == null || grid.length == 0 || k < 0) {
            return Collections.emptyList();
        }
        int m = grid.length;
        int n = grid[0].length;
        List<List<Integer>> ans = new ArrayList<>(grid.length);
        // 第一次遍历先把结果的位置占上
        for (int i = 0; i < m; i++) {
            List<Integer> ret = new ArrayList<>(n);
            for (int j = 0; j < n; j++) {
                ret.add(0);
            }
            ans.add(ret);
        }
        // 第二次遍历填充结果
        for (int i = 0; i < m; i++) {
            // 将二维数组转换为一维数组
            // grid[i][j] = grid[index], index = i*n(列数)+j
            // 那么对于index+k后, newIndex = (index+k)%(m*n)
            // 那么新的i和j就是newIndex的商和余数, newI = newIndex/n, newJ = newIndex%n
            for (int j = 0; j < n; j++) {
                int newIndex = (i * n + j + k) % (m * n);
                int newI = newIndex / n;
                int newJ = newIndex % n;
                ans.get(newI).set(newJ, grid[i][j]);
            }
        }
        return ans;
    }
}
