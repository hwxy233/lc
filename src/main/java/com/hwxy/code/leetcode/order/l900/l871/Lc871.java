package com.hwxy.code.leetcode.order.l900.l871;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 871. 最低加油次数
 * https://leetcode.cn/problems/minimum-number-of-refueling-stops/
 * 
 * @author hwxy
 * @date 2022/07/02
 **/
public class Lc871 {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if (stations == null || stations.length == 0) {
            // 特殊情况没有加油站
            return target <= startFuel ? 0 : -1;
        }
        // 油量多的排在前面
        Queue<Integer> stationQueue = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        int remain = startFuel;
        int distance = 0;
        int stationIndex = 0;
        int ans = 0;
        while (distance < target) {
            // 没油了
            if (remain == 0) {
                if (stationQueue.isEmpty()) {
                    return -1;
                } else {
                    // 加油从路过的加油站选油最多的
                    remain += stationQueue.poll();
                    ans++;
                }
            }
            // 用这些油走到头
            distance += remain;
            remain = 0;
            // 路过的加油到队列
            while (stationIndex < stations.length && stations[stationIndex][0] <= distance) {
                stationQueue.add(stations[stationIndex][1]);
                stationIndex++;
            }
        }
        return ans;
    }
}
