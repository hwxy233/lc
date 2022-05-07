package com.hwxy.code.leetcode.order.l100.l20;

import java.util.Stack;

/**
 * 干嘛的
 *
 * @author hwxy
 * @date 2022/05/07
 **/
public class Lc20NeetCode {
    /**
     * 栈
     * 1. 压栈所有的左边括号
     * 2. 当出现右边括号则出栈进行匹配
     * 
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if (s == null || s.length() < 2) {
            return false;
        }
        char[] scs = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char sc : scs) {
            if (sc == '(' || sc == '{' || sc == '[') {
                stack.push(sc);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char leftC = stack.pop();
                switch (leftC) {
                    case '(':
                        if (sc != ')') {
                            return false;
                        }
                        break;
                    case '[':
                        if (sc != ']') {
                            return false;
                        }
                        break;
                    case '{':
                        if (sc != '}') {
                            return false;
                        }
                        break;
                }
            }
        }
        return stack.isEmpty();
    }
}
