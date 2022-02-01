package com.hwxy.order.l300.l232;

import java.util.Stack;

/**
 * 232. 用栈实现队列
 * https://leetcode-cn.com/problems/implement-queue-using-stacks/
 *
 * @author hwxy
 * @date 2022/02/01
 **/
public class Lc232 {

    /**
     * void push(int x) 将元素 x 推到队列的末尾
     * int pop() 从队列的开头移除并返回元素
     * int peek() 返回队列开头的元素
     * boolean empty() 如果队列为空，返回 true ；否则，返回 false
     *
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/implement-queue-using-stacks
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    class MyQueue {
        private Stack<Integer> inStack;
        private Stack<Integer> outStack;

        public MyQueue() {
            inStack = new Stack<>();
            outStack = new Stack<>();
        }

        /**
         * void push(int x) 将元素 x 推到队列的末尾
         * 
         * @param x
         */
        public void push(int x) {
            inStack.push(x);
        }

        /**
         * int pop() 从队列的开头移除并返回元素
         * 
         * @return
         */
        public int pop() {
            // 将in的元素都弹到out里,然后出out
            if (!outStack.isEmpty()) {
                return outStack.pop();
            }
            fillQueue();
            return outStack.pop();
        }

        private void fillQueue() {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }

        /**
         * int peek() 返回队列开头的元素
         * 
         * @return
         */
        public int peek() {
            // 将in的元素都弹到out里,然后出peek
            if (!outStack.isEmpty()) {
                return outStack.peek();
            }
            fillQueue();
            return outStack.peek();
        }

        /**
         * boolean empty() 如果队列为空，返回 true ；否则，返回 false
         * 
         * @return
         */
        public boolean empty() {
            // 都为空的话才空
            return outStack.isEmpty() && inStack.isEmpty();
        }
    }
}
