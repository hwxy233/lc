package com.hwxy.leetcode.order.l1700.l1606;

import java.util.*;

/**
 * 1606. 找到处理最多请求的服务器
 * https://leetcode-cn.com/problems/find-servers-that-handled-most-number-of-requests/
 * 
 * @author hwxy
 * @date 2022/04/04
 **/
public class Lc1606 {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        if (k <= 0 || arrival == null || arrival.length == 0 || load == null || load.length == 0) {
            return Collections.emptyList();
        }
        // 可用的
        TreeSet<Integer> avl = new TreeSet<>();
        for (int i = 0; i < k; i++) {
            avl.add(i);
        }
        // 处理请求的,a[0]完成时间,a[1]服务器编号
        PriorityQueue<int[]> busy = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        // 处理的请求数量
        int[] processed = new int[k];
        // 处理请求
        for (int i = 0; i < arrival.length; i++) {
            // 如果busy不为空 && busy的处理完成时间 < 当前任务的完成时间,则可以出队
            while (!busy.isEmpty() && busy.peek()[0] <= arrival[i]) {
                int server = busy.poll()[1];
                // 出队后进入可用的
                avl.add(server);
            }
            if (avl.isEmpty()) {
                continue;
            }
            // 先从 i % k 找到最接近的大的
            Integer wantServer = avl.ceiling(i % k);
            if (wantServer == null) {
                // 否则使用第一个
                wantServer = avl.first();
            }
            avl.remove(wantServer);
            processed[wantServer]++;
            int endTime = arrival[i] + load[i];
            busy.offer(new int[] {endTime, wantServer});
        }
        // 遍历找出所有最忙的
        int maxProcessed = Arrays.stream(processed).max().getAsInt();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < processed.length; i++) {
            if (maxProcessed == processed[i]) {
                res.add(i);
            }
        }
        return res;
    }
}
