package com.hwxy.leetcode.order.l700.l682;

import java.util.Stack;

/**
 * 682. 棒球比赛
 * https://leetcode-cn.com/problems/baseball-game/
 * 
 * @author hwxy
 * @date 2022/03/26
 **/
public class Lc682 {

    public static void main(String[] args) {
        System.out.println(new Lc682().calPoints(new String[] {"5", "2", "C", "D", "+"}));
        System.out.println(
                new Lc682().calPoints(new String[] {"5", "-2", "4", "C", "D", "9", "+", "+"}));
    }

    /**
     * 使用栈
     *
     * 整数 x - 表示本回合新获得分数 x
     * "+" - 表示本回合新获得的得分是前两次得分的总和。题目数据保证记录此操作时前面总是存在两个有效的分数。
     * "D" - 表示本回合新获得的得分是前一次得分的两倍。题目数据保证记录此操作时前面总是存在一个有效的分数。
     * "C" - 表示前一次得分无效，将其从记录中移除。题目数据保证记录此操作时前面总是存在一个有效的分数。
     *
     * @param ops
     * @return
     */
    public int calPoints(String[] ops) {
        if (ops == null || ops.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (String op : ops) {
            if ("+".equals(op)) {
                int a = stack.pop();
                int b = stack.pop();
                int n = a + b;
                res += n;
                // 顺序是b,a
                stack.push(b);
                stack.push(a);
                stack.push(n);
            } else if ("D".equals(op)) {
                // 只peek
                int a = stack.peek();
                int n = a * 2;
                res += n;
                stack.push(n);
            } else if ("C".equals(op)) {
                int n = stack.pop();
                res -= n;
            } else {
                int n = Integer.parseInt(op);
                res += n;
                stack.push(n);
            }
        }

        return res;
    }
}
