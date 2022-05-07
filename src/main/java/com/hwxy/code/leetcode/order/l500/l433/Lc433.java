package com.hwxy.code.leetcode.order.l500.l433;

import java.util.*;

/**
 * 433. 最小基因变化
 * https://leetcode-cn.com/problems/minimum-genetic-mutation/
 * 
 * @author hwxy
 * @date 2022/05/07
 **/
public class Lc433 {
    public static final char[] CHANGE_CHARS = new char[] {'A', 'T', 'C', 'G'};

    /**
     * 深度优先搜索
     * 每次把替换的8*4种可能进行遍历,只要最后能找到就是答案
     * 这样可以保证找到的一定是最短的
     * 
     * @param start
     * @param end
     * @param bank
     * @return
     */
    public int minMutation(String start, String end, String[] bank) {
        if (start == null || end == null || bank == null || bank.length < 1) {
            return -1;
        }
        if (start.equals(end)) {
            return 0;
        }
        // 存储合法的
        Set<String> bankSet = new HashSet<>();
        Collections.addAll(bankSet, bank);
        // 找不到就是-1
        if (!bankSet.contains(end)) {
            return -1;
        }
        // 存储访问过的
        Set<String> visited = new HashSet<>();
        visited.add(start);
        Queue<String> queue = new ArrayDeque<>();
        queue.add(start);
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            // 一层加一次,如果初始化为1可以放在第一个for循环结束进行++
            ans++;
            // 对该层(相同变化数的)进行遍历
            for (int i = 0; i < size; i++) {
                String o = queue.poll();
                // 对每个位置进行替换
                for (int j = 0; j < o.length(); j++) {
                    for (char changeChar : CHANGE_CHARS) {
                        StringBuilder sb = new StringBuilder(o);
                        sb.setCharAt(j, changeChar);
                        String ns = sb.toString();
                        // 合法且未访问
                        if (bankSet.contains(ns) && !visited.contains(ns)) {
                            // 得到结果
                            if (end.equals(ns)) {
                                return ans;
                            }
                            visited.add(ns);
                            queue.add(ns);
                        }
                    }
                }
            }
        }
        return -1;
    }

}
