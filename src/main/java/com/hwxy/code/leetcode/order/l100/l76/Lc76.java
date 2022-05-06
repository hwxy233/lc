package com.hwxy.code.leetcode.order.l100.l76;

import java.util.HashMap;
import java.util.Map;

/**
 * 76. 最小覆盖子串
 * https://leetcode-cn.com/problems/minimum-window-substring/
 * 
 * @author hwxy
 * @date 2022/05/06
 **/
public class Lc76 {
    /**
     * 滑动窗口
     * 1. 不断向右移动记录字符直到满足次数
     * 2. 这是更新结果并开始不断左移
     * 3. 直到不满足次数停止左移开始右移重复1,2
     * 
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }
        // 统计出t的字符数量
        Map<Character, Integer> tCharCounter = new HashMap<>();
        for (char tc : t.toCharArray()) {
            tCharCounter.put(tc, tCharCounter.getOrDefault(tc, 0) + 1);
        }
        Map<Character, Integer> sCharCounter = new HashMap<>();
        String ans = "";
        char[] scs = s.toCharArray();
        for (int left = 0, right = 0; right < scs.length; right++) {
            sCharCounter.put(scs[right], sCharCounter.getOrDefault(scs[right], 0) + 1);
            // 统计出一个至少够长度的区间,找到一个至少满足要求的区间
            if ((right - left + 1 < t.length()) || !check(tCharCounter, sCharCounter)) {
                continue;
            }
            do {
                // 找到了一个满足要求的
                if (ans.isEmpty() || ans.length() > (right - left + 1)) {
                    ans = s.substring(left, right + 1);
                }
                // 开始左移
                sCharCounter.put(scs[left], sCharCounter.get(scs[left]) - 1);
                left++;
            } while ((right - left + 1 >= t.length()) && check(tCharCounter, sCharCounter));
        }
        return ans;
    }

    /**
     * t的字符数量都要<=s的字符数量
     * 
     * @param tCharCounter
     * @param sCharCounter
     * @return
     */
    private boolean check(Map<Character, Integer> tCharCounter,
            Map<Character, Integer> sCharCounter) {
        for (Map.Entry<Character, Integer> entry : tCharCounter.entrySet()) {
            if (entry.getValue() > sCharCounter.getOrDefault(entry.getKey(), 0)) {
                return false;
            }
        }
        return true;
    }
}
