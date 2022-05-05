package com.hwxy.code.leetcode.order.l700.l661;

/**
 * 661. 图片平滑器
 * https://leetcode-cn.com/problems/image-smoother/
 * 
 * @author hwxy
 * @date 2022/03/24
 **/
public class Lc661 {
    private static final int[][] CS =
            new int[][] {{-1, -1}, {0, -1}, {1, -1},
                    {-1, 0}, {0, 0}, {1, 0},
                    {-1, 1}, {0, 1}, {1, 1}};

    /**
     * 简单模拟,注意边界条件
     * 
     * @param img
     * @return
     */
    public int[][] imageSmoother(int[][] img) {
        if (img == null || img.length == 0) {
            return null;
        }
        int[][] res = new int[img.length][img[0].length];
        for (int i = 0; i < img.length; i++) {
            for (int j = 0; j < img[i].length; j++) {
                int sum = 0;
                int cnt = 0;
                for (int[] c : CS) {
                    int x = i + c[0];
                    int y = j + c[1];
                    if (x < 0 || x >= img.length || y < 0 || y >= img[i].length) {
                        continue;
                    }
                    sum += img[x][y];
                    cnt++;
                }
                if (cnt != 0) {
                    res[i][j] = sum / cnt;
                }
            }
        }
        return res;
    }
}
