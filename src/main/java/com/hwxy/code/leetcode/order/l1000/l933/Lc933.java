package com.hwxy.code.leetcode.order.l1000.l933;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 933. 最近的请求次数
 * https://leetcode-cn.com/problems/number-of-recent-calls/
 * 
 * @author hwxy
 * @date 2022/05/06
 **/
public class Lc933 {
    public static void main(String[] args) {
        RecentCounter recentCounter = new RecentCounter();
        System.out.println(recentCounter.ping(1));
        System.out.println(recentCounter.ping(10));
        System.out.println(recentCounter.ping(3001));
        System.out.println(recentCounter.ping(3002));
    }
}


/**
 * RecentCounter() 初始化计数器，请求数为 0 。
 * int ping(int t) 在时间 t 添加一个新请求，其中 t 表示以毫秒为单位的某个时间，并返回过去 3000 毫秒内发生的所有请求数（包括新请求）。
 * 确切地说，返回在 [t-3000,t] 内发生的请求数。
 * 保证 每次对 ping 的调用都使用比之前更大的 t 值。
 *
 */
class RecentCounter {
    /**
     * 因为t是递增的,这就相当于是一个滑动窗口
     * 只要维护[t-3000,t]范围的ping即可,之前的数据可以poll掉
     */
    private final Queue<Integer> queue;

    public RecentCounter() {
        queue = new ArrayDeque<>();
    }


    public int ping(int t) {
        queue.offer(t);
        // 小于t-3000的都直接出队列
        while (!queue.isEmpty() && queue.peek() < (t - 3000)) {
            queue.poll();
        }
        return queue.size();
    }
}
