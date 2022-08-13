package com.hwxy.code.leetcode.order.l700.l636;

import java.util.List;
import java.util.Stack;

/**
 * 636. 函数的独占时间
 * https://leetcode.cn/problems/exclusive-time-of-functions/
 * 
 * @author hwxy
 * @date 2022/08/07
 **/
public class Lc636 {

    public int[] exclusiveTime(int n, List<String> logs) {
        if (n < 1 || logs == null || logs.size() == 0) {
            return null;
        }
        int[] ans = new int[n];
        Stack<Func> stack = new Stack<>();
        long cur = 0;
        for (String log : logs) {
            Func func = createFunc(log);
            // 新的start
            if (func.type == 0) {
                // 检查有没有存在的start,存在就累加时间给他
                if (!stack.isEmpty()) {
                    ans[stack.peek().id] += (func.time - cur);
                }
                stack.push(func);
                cur = func.time;
            } else {
                // 遇到end就直接pop出一个start
                Func curStart = stack.pop();
                ans[curStart.id] += (func.time - cur + 1);
                // 要+1
                cur = func.time + 1;
            }
        }
        return ans;
    }

    private Func createFunc(String log) {
        String[] strs = log.split(":");
        return new Func(Integer.parseInt(strs[0]), Long.parseLong(strs[2]),
                "start".equals(strs[1]) ? 0 : 1);
    }

    static class Func {
        int id;
        long time;
        int type;

        public Func(int id, long start, int type) {
            this.id = id;
            this.time = start;
            this.type = type;
        }
    }

}
