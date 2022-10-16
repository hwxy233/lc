package com.hwxy.code.leetcode.order.l900.l884;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 886. 可能的二分法
 * https://leetcode.cn/problems/possible-bipartition/
 *
 * @author hwxy
 * @date 2022/10/16
 **/
public class Lc884 {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        if (n < 1) {
            return false;
        }
        // 建图
        Map<Integer, Set<Integer>> graph = new HashMap<>(n);
        for (int[] dis : dislikes) {
            graph.computeIfAbsent(dis[0], key -> new HashSet<>()).add(dis[1]);
            graph.computeIfAbsent(dis[1], key -> new HashSet<>()).add(dis[0]);
        }
        // 染色dfs, 未染色为0, 染红色为1, 染蓝色为-1
        int[] colors = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            // 对i染色,并递归的对i的邻居染色,如果有染色失败的说明false
            if (colors[i] == 0 && !dfs(i, graph, colors, 1)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int index, Map<Integer, Set<Integer>> graph, int[] colors, int color) {
        // 给自己染色color
        colors[index] = color;
        if (graph.containsKey(index)) {
            // 染色邻居
            for (int neb : graph.get(index)) {
                // 如果邻居和自己颜色一样就不对了
                if (colors[neb] == color) {
                    return false;
                }
                // 染相反的颜色-color
                else if (colors[neb] == 0 && !dfs(neb, graph, colors, -color)) {
                    return false;
                }
            }
        }
        return true;
    }
}
