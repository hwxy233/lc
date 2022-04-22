package com.hwxy.leetcode.order.l100.l20;

import java.util.Stack;

/**
 * 20. 有效的括号
 * https://leetcode-cn.com/problems/valid-parentheses/
 *
 * @author hwxy
 * @date 2022/02/01
 **/
public class Lc20 {
    public static void main(String[] args) {
        System.out.println(new Lc20().isValid("([)]"));
    }

    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     * 
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        char[] pa = s.toCharArray();
        for (char c : pa) {
            if (c == '(' || c == '{' || c == '[') {
                // 左括号入栈
                stack.push(c);
            } else {
                // 右括号多了
                if (stack.isEmpty()) {
                    return false;
                }
                char left = stack.pop();
                // 期望的右括号
                char target;
                switch (left) {
                    case '(':
                        target = ')';
                        break;
                    case '{':
                        target = '}';
                        break;
                    default:
                        target = ']';
                }
                if (target != c) {
                    return false;
                }
            }
        }
        // 非空说明左括号多了
        return stack.isEmpty();
    }

}
