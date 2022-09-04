package com.hwxy.code.leetcode.order.l1000.l946;

import java.util.Stack;

/**
 * 946. 验证栈序列
 *
 * <p>https://leetcode.cn/problems/validate-stack-sequences/
 *
 * @author hwxy
 * @date 2022/08/31
 */
public class Lc946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed == null || popped == null || pushed.length != popped.length) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int poppedIndex = 0;
        for (int p : pushed) {
            stack.push(p);
            while (!stack.isEmpty() && stack.peek() == popped[poppedIndex]) {
                stack.pop();
                poppedIndex++;
            }
        }
        return stack.isEmpty();
    }
}
