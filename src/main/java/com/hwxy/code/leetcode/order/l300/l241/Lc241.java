package com.hwxy.code.leetcode.order.l300.l241;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 241. 为运算表达式设计优先级
 * https://leetcode.cn/problems/different-ways-to-add-parentheses/
 * 
 * @author hwxy
 * @date 2022/07/01
 **/
public class Lc241 {

    public static final char ZERO = '0';
    public static final char NINE = '9';
    public static final char PLUS = '+';
    public static final char MINUS = '-';
    public static final char MULTI = '*';

    private char[] ecs;

    public List<Integer> diffWaysToCompute(String expression) {
        if (expression == null || expression.isEmpty()) {
            return Collections.emptyList();
        }
        ecs = expression.toCharArray();
        return dfs(0, ecs.length - 1);
    }

    /**
     * 使用运算符进行分割成左右2部分分别计算
     * 
     * @param leftIndex
     * @param rightIndex
     * @return
     */
    private List<Integer> dfs(int leftIndex, int rightIndex) {
        List<Integer> ans = new ArrayList<>();
        for (int i = leftIndex; i <= rightIndex; i++) {
            if (ecs[i] <= NINE && ecs[i] >= ZERO) {
                continue;
            }
            List<Integer> leftAns = dfs(leftIndex, i - 1);
            List<Integer> rightAns = dfs(i + 1, rightIndex);
            for (int leftA : leftAns) {
                for (int rightA : rightAns) {
                    switch (ecs[i]) {
                        case PLUS:
                            ans.add(leftA + rightA);
                            break;
                        case MINUS:
                            ans.add(leftA - rightA);
                            break;
                        case MULTI:
                            ans.add(leftA * rightA);
                            break;
                    }
                }
            }
        }
        // 说明没有运算符号
        if (ans.isEmpty()) {
            int cur = 0;
            for (int i = leftIndex; i <= rightIndex; i++) {
                cur = cur * 10 + (ecs[i] - ZERO);
            }
            ans.add(cur);
        }
        return ans;
    }
}
