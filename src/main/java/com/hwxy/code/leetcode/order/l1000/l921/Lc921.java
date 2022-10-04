package com.hwxy.code.leetcode.order.l1000.l921;

import java.util.Stack;

/**
 * 921. 使括号有效的最少添加
 * https://leetcode.cn/problems/minimum-add-to-make-parentheses-valid/
 *
 * @author hwxy
 * @date 2022/10/04
 **/
public class Lc921 {
    public int minAddToMakeValid(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        Stack<Character> stack = new Stack<>();
        char[] scs = s.toCharArray();
        // 必须左右匹配才行
        for (char c : scs) {
            if (!stack.isEmpty()) {
                if (c == ')' && stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            } else {
                stack.push(c);
            }
        }
        return stack.size();
    }
}
