package com.hwxy.code.leetcode.order.l100.l93;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * 干嘛的
 *
 * @author hwxy
 * @date 2021/08/08
 **/
public class Lc93 {

    public static void main(String[] args) {
        Lc93 lc93 = new Lc93();
        // System.out.println(lc93.restoreIpAddresses("101023"));
        // System.out.println(lc93.restoreIpAddresses("25525511135"));
         System.out.println(lc93.restoreIpAddresses("0000"));
    }

    private final LinkedList<String> result = new LinkedList<>();

    private final LinkedList<String> tmp = new LinkedList<>();

    public List<String> restoreIpAddresses(String s) {
        if (Objects.isNull(s) || s.length() == 0 || s.length() > 12) {
            return result;
        }
        backtracking(s, 0);
        return result;
    }

    private void backtracking(String s, int index) {
        if (index >= s.length()) {
            if (tmp.size() == 4) {
                result.add(tmp.get(0) + "." + tmp.get(1) + "." + tmp.get(2) + "." + tmp.get(3));
            }
            return;
        }
        // 每段最多分割出3个数字, 可以在这里剪枝,超过s长度就舍弃
        for (int i = 1; i <= 3 && index + i <= s.length(); i++) {
            String next = s.substring(index, index + i);
            // 0只能独自成段
            if (next.length() != 1 && next.startsWith("0") || Integer.parseInt(next) > 255) {
                continue;
            }
            tmp.add(next);
            backtracking(s, index + i);
            tmp.removeLast();
        }
    }

}
