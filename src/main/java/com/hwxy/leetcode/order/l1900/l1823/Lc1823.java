package com.hwxy.leetcode.order.l1900.l1823;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 1823. 找出游戏的获胜者
 * https://leetcode-cn.com/problems/find-the-winner-of-the-circular-game/
 * 
 * @author hwxy
 * @date 2022/05/04
 **/
public class Lc1823 {
    /**
     * 用一个队列也可以
     * 
     * @param n
     * @param k
     * @return
     */
    public int findTheWinner(int n, int k) {
        Queue<Integer> queue = new ArrayDeque<>(n);
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }
        while (queue.size() != 1) {
            // 每次pop队头k-1次,并add到队尾,结束的队头就是要寄的
            for (int i = 0; i < k - 1; i++) {
                queue.add(queue.poll());
            }
            queue.poll();
        }
        return queue.poll();
    }
}
