package com.hwxy.leetcode.order.l300.l225;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 225. 用队列实现栈
 * https://leetcode-cn.com/problems/implement-stack-using-queues/
 *
 * @author hwxy
 * @date 2022/02/01
 **/
public class Lc225 {
    class MyStack {
        private Queue<Integer> queue;

        /**
         * void push(int x) 将元素 x 压入栈顶。
         * int pop() 移除并返回栈顶元素。
         * int top() 返回栈顶元素。
         * boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
         *
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/implement-stack-using-queues
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         */
        public MyStack() {
            queue = new LinkedList<>();
        }

        /**
         * void push(int x) 将元素 x 压入栈顶。
         * 
         * @param x
         */
        public void push(int x) {
            queue.add(x);
        }

        /**
         * int pop() 移除并返回栈顶元素。
         * 
         * @return
         */
        public int pop() {
            // 返回最后一个元素
            reconstructQueue();
            return queue.poll();
        }

        private void reconstructQueue() {
            int size = queue.size();
            for (int i = 0; i < size - 1; i++) {
                queue.add(queue.poll());
            }
        }

        /**
         * int top() 返回栈顶元素。
         * 
         * @return
         */
        public int top() {
            // 返回最后一个元素
            Integer top = pop();
            // 记得pop完再push回去
            push(top);
            return top;
        }

        /**
         * boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
         * 
         * @return
         */
        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
