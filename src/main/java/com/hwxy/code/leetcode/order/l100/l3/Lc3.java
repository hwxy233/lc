package com.hwxy.code.leetcode.order.l100.l3;

import java.util.HashSet;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * 
 * @author hwxy
 * @date 2022/05/06
 **/
public class Lc3 {




    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        // 维护一个滑动窗口
        // 以及一个Set记录字符出现
        // 每次右移到新字符时如果Set已经用过则要不断右移左窗口直到Set消失
        // 记录字符的使用情况
        Set<Character> usedSet = new HashSet<>();
        char[] scs = s.toCharArray();
        int ans = 0;
        for (int left = 0, right = left; right < s.length(); right++) {
            // 新字符使用过了,需要右移左窗口
            while (usedSet.contains(scs[right])) {
                // 重置使用状态
                usedSet.remove(scs[left]);
                left++;
            }
            // 标记使用了
            usedSet.add(scs[right]);
            // 获取该下标范围的字符个数
            ans = Math.max(ans, (right - left + 1));
        }
        return ans;
    }
}
