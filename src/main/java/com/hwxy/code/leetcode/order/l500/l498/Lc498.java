package com.hwxy.code.leetcode.order.l500.l498;

/**
 * 498. 对角线遍历
 * https://leetcode.cn/problems/diagonal-traverse/
 * 
 * @author hwxy
 * @date 2022/06/14
 **/
public class Lc498 {
    public int[] findDiagonalOrder(int[][] mat) {
        if (mat == null || mat.length == 0) {
            return null;
        }
        int[] ans = new int[mat.length * mat[0].length];
        int cnt = 0;
        int x = 0;
        int y = 0;
        boolean bottomToTop = true;
        while (cnt < ans.length) {
            int lastX = x;
            int lastY = y;
            if (bottomToTop) {
                while (y < mat[0].length && x >= 0) {
                    lastX = x;
                    lastY = y;
                    ans[cnt++] = mat[x][y];
                    y += 1;
                    x -= 1;
                }
                if (x < 0 && y >= mat[0].length) {
                    x = lastX + 1;
                    y = lastY;
                } else if (x < 0) {
                    y = lastY + 1;
                    x = lastX;
                } else {
                    x = lastX + 1;
                    y = lastY;
                }
                bottomToTop = false;
            } else {
                while (y >= 0 && x < mat.length) {
                    lastX = x;
                    lastY = y;
                    ans[cnt++] = mat[x][y];
                    y -= 1;
                    x += 1;
                }
                if (y < 0 && x >= mat.length) {
                    x = lastX;
                    y = lastY + 1;
                } else if (y < 0) {
                    y = lastY;
                    x = lastX + 1;
                } else {
                    x = lastX;
                    y = lastY + 1;
                }
                bottomToTop = true;
            }
        }
        return ans;
    }
}
