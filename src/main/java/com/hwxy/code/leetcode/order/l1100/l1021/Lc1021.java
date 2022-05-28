package com.hwxy.code.leetcode.order.l1100.l1021;

import java.util.Stack;

/**
 * 1021. 删除最外层的括号
 * https://leetcode.cn/problems/remove-outermost-parentheses/
 * 
 * @author hwxy
 * @date 2022/05/28
 **/
public class Lc1021 {
    public static final char LEFT_PARENTHESES = '(';
    public static final char RIGHT_PARENTHESES = ')';

    public String removeOuterParentheses(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        // 记录左括号的个数,大于1时说明不是最外层括号可以append,遇到右括号时同理但是记得减一
        int leftParenthesesCount = 0;
        char[] scs = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : scs) {
            if (c == LEFT_PARENTHESES) {
                leftParenthesesCount++;
                if (leftParenthesesCount > 1) {
                    sb.append(c);
                }
            } else {
                if (leftParenthesesCount > 1) {
                    sb.append(c);
                }
                leftParenthesesCount--;
            }
        }
        return sb.toString();
    }

    public String removeOuterParenthesesStack(String s) {
        StringBuilder res = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        char[] scs = s.toCharArray();
        for (char c : scs) {
            if (c == RIGHT_PARENTHESES) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                res.append(c);
            }
            if (c == LEFT_PARENTHESES) {
                stack.push(c);
            }
        }
        return res.toString();
    }

}
