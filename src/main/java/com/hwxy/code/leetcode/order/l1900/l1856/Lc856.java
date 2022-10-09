package com.hwxy.code.leetcode.order.l1900.l1856;

import java.util.Stack;

/**
 * 856. 括号的分数
 * https://leetcode.cn/problems/score-of-parentheses/
 *
 * @author hwxy
 * @date 2022/10/09
 **/
public class Lc856 {
    public int scoreOfParentheses(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        // 避免上层没有数据的情况
        stack.push(0);
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(0);
            } else {
                // 如果当前层是0则说明只要给前一层+1即可,否则要*2
                int cur = stack.pop();
                int pre = stack.pop();
                if (cur == 0) {
                    stack.push(pre + 1);
                } else {
                    stack.push(pre + cur * 2);
                }
            }
        }
        return stack.peek();
    }
}
