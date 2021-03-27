package com.hwxy.other.base.greedy;

/**
 * POJ 3069
 * 用最少的点覆盖所有点
 * 半径覆盖
 *
 * @author hwxy
 * @date 2021/03/27
 **/
public class SarumansArmy {
    public static void main(String[] args) {
        System.out.println(calPoints(6, 10, new int[]{1, 7, 15, 20, 30, 50}));
    }

    /**
     * 最少范围覆盖
     *
     * @param n      点个数
     * @param r      半径
     * @param points 所有点
     * @return 最少覆盖的点数量
     */
    public static int calPoints(int n, int r, int[] points) {
        int i = 0;
        int count = 0;
        while (i < n) {
            // 从当前点开始向右找距s大于r的点
            int s = points[i++];
            while (i < n && points[i] <= s + r) {
                i++;
            }
            // 半径左边满足了,还要考虑半径右边, i-1意味着这个点是标记点
            int p = points[i - 1];
            while (i < n && points[i] <= p + r) {
                i++;
            }
            count++;
        }
        return count;
    }
}
