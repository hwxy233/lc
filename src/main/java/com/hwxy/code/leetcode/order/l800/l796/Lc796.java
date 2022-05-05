package com.hwxy.code.leetcode.order.l800.l796;

/**
 * 796. 旋转字符串
 * https://leetcode-cn.com/problems/rotate-string/
 * 
 * @author hwxy
 * @date 2022/04/07
 **/
public class Lc796 {
    /**
     * 将2个s拼到一起
     * 如果包含goal则说明可以
     * 
     * @param s
     * @param goal
     * @return
     */
    public boolean rotateString(String s, String goal) {
        if (s == null || goal == null || s.length() != goal.length()) {
            return false;
        }
        return (s + s).contains(goal);
    }
}
