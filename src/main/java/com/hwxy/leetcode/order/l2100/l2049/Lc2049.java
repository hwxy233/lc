package com.hwxy.leetcode.order.l2100.l2049;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2049. 统计最高分的节点数目
 * https://leetcode-cn.com/problems/count-nodes-with-the-highest-score/
 * 
 * @author hwxy
 * @date 2022/03/11
 **/
public class Lc2049 {
    public static void main(String[] args) {
        System.out.println(new Lc2049().countHighestScoreNodes(new int[] {-1, 2, 0, 2, 0}));
    }

    private List<List<Integer>> children;
    private Map<Integer, Integer> childCount;

    public int countHighestScoreNodes(int[] parents) {
        if (parents == null || parents.length == 0) {
            return 0;
        }
        // 1. 找到所有节点的子节点
        children = new ArrayList<>(parents.length);
        for (int i = 0; i < parents.length; i++) {
            children.add(new ArrayList<>(2));
        }
        for (int i = 0; i < parents.length; i++) {
            int parent = parents[i];
            if (parent == -1) {
                continue;
            }
            children.get(parent).add(i);
        }
        // 2. 求出每个节点的子节点的数量
        childCount = new HashMap<>(parents.length);
        dfs(0);
        // 3. 去掉某个节点的分数=左子节点的数量 * 右子节点的数量 * (所有节点数-1-左子节点数-右子节点数) // -1是减去节点本身
        long maxScore = Integer.MIN_VALUE;
        int res = 0;
        // 从第一个节点开始寻找所有的分数
        for (int i = 0; i < parents.length; i++) {
            long score = 1;
            int leftSize = parents.length - 1;
            for (int child : children.get(i)) {
                score *= childCount.get(child);
                leftSize -= childCount.get(child);
            }
            if (leftSize != 0) {
                score *= leftSize;
            }
            if (score > maxScore) {
                maxScore = score;
                res = 1;
            } else if (score == maxScore) {
                res++;
            }
        }
        return res;
    }

    /**
     * 求出每个子树(包括跟节点)的子节点数量
     * 
     * @param nodeIndex
     * @return 子节点数量
     */
    private int dfs(int nodeIndex) {
        List<Integer> child = children.get(nodeIndex);
        // 累加所有孩子的size,如果是叶子的话就是0
        int size = 1;
        for (int c : child) {
            size += dfs(c);
        }
        childCount.put(nodeIndex, size);
        return size;
    }
}
