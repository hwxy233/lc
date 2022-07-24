package com.hwxy.code.leetcode.sfo.sfo2.sfo115;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * 剑指 Offer II 115. 重建序列
 * https://leetcode.cn/problems/ur2n8P/
 *
 * @author hwxy
 * @date 2022/07/23
 **/
public class Sfo115 {
    public boolean sequenceReconstruction(int[] nums, int[][] sequences) {
        if (nums == null || nums.length == 0 || sequences == null) {
            return false;
        }
        // 1到n的入度
        int[] inDegrees = new int[nums.length + 1];
        // 维护一个前节点和后节点的关系
        Set<Integer>[] graph = new Set[nums.length + 1];
        // 计算出所有节点的入度和图的关系
        for (int[] sequence : sequences) {
            for (int i = 1; i < sequence.length; i++) {
                int pre = sequence[i - 1];
                int next = sequence[i];
                inDegrees[next]++;
                if (graph[pre] == null) {
                    graph[pre] = new HashSet();
                }
                graph[pre].add(next);
            }
        }
        // 找出所有入度为0的点
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i < inDegrees.length; i++) {
            if (inDegrees[i] == 0) {
                queue.offer(i);
            }
        }
        // 只要找到某个入度为0的节点的出度>1就说明存在多个选择,不唯一
        while (!queue.isEmpty()) {
            // 路径不唯一的话就是有问题的
            if (queue.size() > 1) {
                return false;
            }
            int pre = queue.poll();
            if (graph[pre] == null) {
                continue;
            }
            // 找出所有的后继,入度-1
            for (int next : graph[pre]) {
                inDegrees[next]--;
                // 入度为0的作为下一个选择
                if (inDegrees[next] == 0) {
                    queue.offer(next);
                }
            }

        }
        return true;
    }

}
