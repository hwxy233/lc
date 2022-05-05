package com.hwxy.code.leetcode.order.l200.l150;

import java.util.Stack;

/**
 * 150. 逆波兰表达式求值
 * https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
 * 
 * @author hwxy
 * @date 2022/02/01
 **/
public class Lc150 {
    public static void main(String[] args) {
        // System.out.println(new Lc150().evalRPN(new String[] {"2", "1", "+", "3", "*"}));
        System.out.println(new Lc150().evalRPN(new String[] {"4", "13", "5", "/", "+"}));
    }

    /**
     * 有效的算符包括 +、-、*、/ 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
     * 
     * @param tokens
     * @return
     */
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            throw new RuntimeException("非法参数");
        }
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            // 运算符出栈,都是n2在前
            switch (s) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    int n1 = stack.pop();
                    int n2 = stack.pop();
                    stack.push(n2 - n1);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    n1 = stack.pop();
                    n2 = stack.pop();
                    stack.push(n2 / n1);
                    break;
                default:
                    stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
}
