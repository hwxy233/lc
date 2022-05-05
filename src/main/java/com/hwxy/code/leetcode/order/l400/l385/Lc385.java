package com.hwxy.code.leetcode.order.l400.l385;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 385. 迷你语法分析器
 * https://leetcode-cn.com/problems/mini-parser/
 * 
 * @author hwxy
 * @date 2022/04/15
 **/
public class Lc385 {
    public static void main(String[] args) {
        System.out.println(new Lc385().deserialize("324"));
        System.out.println(new Lc385().deserialize("[123,[111],[456,[789]]]"));
    }

    private char[] cs;
    private int i;

    /**
     * 用栈不过不是对输入的字符串使用而是对结果使用
     * 为了维持父子关系
     * 
     * @param s
     * @return
     */
    public NestedInteger deserialize(String s) {
        if (s == null || s.isEmpty()) {
            return null;
        }
        // "[123,[456,[789]]]"
        cs = s.toCharArray();
        i = 0;
        NestedInteger res = null;
        Stack<NestedInteger> nestedIntegerStack = new Stack<>();
        for (; i < cs.length; i++) {
            if (cs[i] == '[') {
                NestedInteger nestedInteger = new NestedInteger();
                if (!nestedIntegerStack.isEmpty()) {
                    NestedInteger fa = nestedIntegerStack.pop();
                    fa.add(nestedInteger);
                    nestedIntegerStack.add(fa);
                }
                nestedIntegerStack.add(nestedInteger);
            } else if (cs[i] == '-' || (cs[i] >= '0' && cs[i] <= '9')) {
                int num = getNum();
                if (nestedIntegerStack.isEmpty()) {
                    return new NestedInteger(num);
                }
                NestedInteger fa = nestedIntegerStack.pop();
                fa.add(new NestedInteger(num));
                nestedIntegerStack.add(fa);
            } else if (cs[i] == ',') {
                continue;
            } else {
                res = nestedIntegerStack.pop();
            }
        }
        while (!nestedIntegerStack.isEmpty()) {
            res = nestedIntegerStack.pop();
        }
        return res;
    }

    private int getNum() {
        StringBuilder sb = new StringBuilder();
        // 注意小于要先写
        while (i < cs.length && cs[i] != ',') {
            if (cs[i] == '[') {
                i++;
                continue;
            }
            if (cs[i] == ']') {
                break;
            }
            sb.append(cs[i++]);
        }
        // 回退,防止调用处的i++破坏]出栈
        i--;
        return Integer.parseInt(sb.toString());
    }


    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    @Getter
    @ToString
    class NestedInteger {
        private int val;
        private List<NestedInteger> nestedIntegers = new ArrayList<>();

        // Constructor initializes an empty nested list.
        public NestedInteger() {

        }

        // Constructor initializes a single integer.
        public NestedInteger(int value) {
            this.val = value;
        }

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger() {
            return nestedIntegers.isEmpty();
        }

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger() {
            return val;
        }

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value) {
            val = value;
        }

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni) {
            nestedIntegers.add(ni);
        }

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList() {
            return nestedIntegers;
        }
    }
}
