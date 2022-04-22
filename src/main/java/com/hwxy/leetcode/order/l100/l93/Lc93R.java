package com.hwxy.leetcode.order.l100.l93;

import java.util.LinkedList;
import java.util.List;

/**
 * 干嘛的
 *
 * @author hwxy
 * @date 2021/10/02
 **/
public class Lc93R {

    public static void main(String[] args) {
        Lc93R lc93R = new Lc93R();
        System.out.println(lc93R.restoreIpAddresses("101023"));
    }

    private LinkedList<String> res = new LinkedList<>();

    private LinkedList<String> path = new LinkedList<>();

    public List<String> restoreIpAddresses(String s) {
        if (s == null || s.length() == 0) {
            return res;
        }
        backtracking(s, 0);
        return res;
    }

    private void backtracking(String s, int index) {
        if (index >= s.length()) {
            if (path.size() == 4) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < path.size(); i++) {
                    stringBuilder.append(path.get(i));
                    if (i != path.size() - 1) {
                        stringBuilder.append(".");
                    }
                }
                res.add(stringBuilder.toString());
            }
            return;
        }
        // 剪枝,ip最多循环3次; 并且index加上i后小于长度
        for (int i = 1; i < 4 && index + i <= s.length(); i++) {
            String sub = s.substring(index, index + i);
            if (!checkIp(sub)) {
                continue;
            }
            path.add(sub);
            // 这里是index+i,相当于(0,index+i)的是已经使用过的
            backtracking(s, index + i);
            path.removeLast();
        }
    }

    private boolean checkIp(String sub) {
        if ((sub.length() > 1 && sub.startsWith("0"))) {
            return false;
        }
        int i = Integer.parseInt(sub);
        return i <= 255;
    }

    private boolean checkIp(String s, int start, int end) {
        String sub = s.substring(start, end);
        if ((sub.length() > 1 && sub.startsWith("0"))) {
            return false;
        }
        int i = Integer.parseInt(sub);
        return i <= 255;
    }
}
