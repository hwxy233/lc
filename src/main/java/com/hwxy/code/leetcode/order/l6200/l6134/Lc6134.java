package com.hwxy.code.leetcode.order.l6200.l6134;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 6134. 找到离给定两个节点最近的节点
 * https://leetcode.cn/contest/weekly-contest-304/problems/find-closest-node-to-given-two-nodes/
 * 
 * @author hwxy
 * @date 2022/07/31
 **/
public class Lc6134 {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        if (edges == null || edges.length == 0) {
            return 0;
        }
        // 找2个点能到达的所有点的距离,注意环
        Map<Integer, Integer> node1IndexStep = steps(edges, node1);
        Map<Integer, Integer> node2IndexStep = steps(edges, node2);
        int ans = -1;
        int minStep = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> entry : node1IndexStep.entrySet()) {
            if (node2IndexStep.containsKey(entry.getKey())) {
                int step = Math.max(entry.getValue(), node2IndexStep.get(entry.getKey()));
                if (step < minStep) {
                    minStep = step;
                    ans = entry.getKey();
                }
            }
        }
        return ans;
    }

    private Map<Integer, Integer> steps(int[] edges, int node) {
        Set<Integer> used = new HashSet<>();
        used.add(node);
        Map<Integer, Integer> res = new HashMap<>();
        int step = 0;
        res.put(node, step);
        while (edges[node] != -1) {
            if (used.contains(edges[node])) {
                return res;
            }
            node = edges[node];
            step++;
            used.add(node);
            res.put(node, step);
        }
        return res;
    }
}
