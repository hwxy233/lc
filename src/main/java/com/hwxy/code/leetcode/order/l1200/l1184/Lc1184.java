package com.hwxy.code.leetcode.order.l1200.l1184;

/**
 * 1184. 公交站间的距离
 * https://leetcode.cn/problems/distance-between-bus-stops/
 *
 * @author hwxy
 * @date 2022/07/24
 **/
public class Lc1184 {

    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if (distance == null || start < 0 || destination < 0 || start >= distance.length
                || destination >= distance.length || start == destination) {
            return 0;
        }
        // 要么是正向要么是逆向
        int ans = cal(distance, start, destination);
        ans = Math.min(ans, cal(distance, destination, start));
        return ans;

    }

    private int cal(int[] distance, int start, int destination) {
        int sum = 0;
        while (start != destination) {
            sum += distance[start];
            start = (start + 1) % distance.length;
        }
        return sum;
    }
}
