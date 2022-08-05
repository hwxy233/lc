package com.hwxy.code.leetcode.order.l6200.l6135;

import java.util.HashMap;
import java.util.Map;

/**
 * 6135. 图中的最长环
 * https://leetcode.cn/contest/weekly-contest-304/problems/longest-cycle-in-a-graph/
 *
 * @author hwxy
 * @date 2022/07/31
 **/
public class Lc6135 {

    public int longestCycle(int[] edges) {
        if (edges == null || edges.length == 0) {
            return -1;
        }
        // 记录一下每个节点的最大环的size,防止重复遍历
        Map<Integer, Integer> indexCycleSize = new HashMap<>(edges.length);
        int ans = -1;
        for (int i = 0; i < edges.length; i++) {
            if (indexCycleSize.containsKey(i)) {
                continue;
            }
            ans = Math.max(ans, findCycle(i, edges, indexCycleSize));
        }
        return ans;
    }

    /**
     * 已经产生过环和产生了新的环分来讨论即可
     * 
     * @param edge
     * @param edges
     * @param indexCycleSize
     * @return
     */
    private int findCycle(int edge, int[] edges, Map<Integer, Integer> indexCycleSize) {
        int step = 0;
        Map<Integer, Integer> indexSteps = new HashMap<>();
        indexSteps.put(edge, step);
        // 是否已经走过了
        boolean indexCycled = false;
        // 是否产生了新环
        boolean newCycled = false;
        while (edges[edge] != -1) {
            int next = edges[edge];
            if (indexCycleSize.containsKey(next)) {
                indexCycled = true;
                break;
            }
            if (indexSteps.containsKey(next)) {
                newCycled = true;
                break;
            }
            edge = next;
            step++;
            indexSteps.put(edge, step);
        }
        // 说明已经路由到了环的节点
        if (indexCycled) {
            Integer cycleSize = indexCycleSize.get(edges[edge]);
            for (Integer key : indexSteps.keySet()) {
                indexCycleSize.put(key, cycleSize);
            }
            return cycleSize;
        }
        // 产生了新环
        if (newCycled) {
            Integer cycleSize = step - indexSteps.get(edges[edge]) + 1;
            for (Integer key : indexSteps.keySet()) {
                indexCycleSize.put(key, cycleSize);
            }
            return cycleSize;
        }
        return -1;
    }
}
