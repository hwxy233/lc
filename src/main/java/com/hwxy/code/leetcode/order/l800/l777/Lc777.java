package com.hwxy.code.leetcode.order.l800.l777;

/**
 * 777. 在LR字符串中交换相邻字符
 * https://leetcode.cn/problems/swap-adjacent-in-lr-string/
 *
 * @author hwxy
 * @date 2022/10/02
 **/
public class Lc777 {
    public boolean canTransform(String start, String end) {
        if (start == null || end == null || start.length() != end.length()) {
            return false;
        }
        int i = 0;
        char[] scs = start.toCharArray();
        int j = 0;
        char[] ecs = end.toCharArray();
        // 双指针,L和R在state和end的相对位置是固定的
        while (i < start.length() || j < end.length()) {
            while (i < start.length() && scs[i] == 'X') {
                i++;
            }
            while (j < end.length() && ecs[j] == 'X') {
                j++;
            }
            if (i == start.length() || j == end.length()) {
                return i == j;
            }
            // 相同
            if (scs[i] != ecs[j]) {
                return false;
            }
            // L可以左移所以是>=
            if (scs[i] == 'L' && i < j) {
                return false;
            }
            // R是右移所以是<=
            if (scs[i] == 'R' && i > j) {
                return false;
            }
            i++;
            j++;
        }
        return i == j;
    }
}
