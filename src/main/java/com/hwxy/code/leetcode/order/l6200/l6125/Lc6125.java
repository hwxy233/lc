package com.hwxy.code.leetcode.order.l6200.l6125;

/**
 * 6125. 相等行列对
 * https://leetcode.cn/contest/weekly-contest-303/problems/equal-row-and-column-pairs/
 * 
 * @author hwxy
 * @date 2022/07/24
 **/
public class Lc6125 {

    public int equalPairs(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                boolean allSame = true;
                for (int k = 0; k < grid.length; k++) {
                    if (grid[i][k] != grid[k][j]) {
                        allSame = false;
                        break;
                    }
                }
                if (allSame) {
                    ans++;
                }
            }
        }

        return ans;
    }
}
