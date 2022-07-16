package com.hwxy.code.leetcode.order.l100.l3;

import java.util.HashMap;
import java.util.Map;


/**
 * 3. 无重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 *
 * @author hwxy
 * @date 2022/07/16
 **/
public class Lc3Nc {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        char[] scs = s.toCharArray();
        int left = 0;
        int right = 0;
        int ans = 0;
        // 每个字符最多一个
        Map<Character, Integer> window = new HashMap<>();
        while (right < scs.length) {
            char offerC = scs[right];
            window.put(offerC, window.getOrDefault(offerC, 0) + 1);
            // 保证新加进来的字符的数量只能是1
            while (window.get(offerC) > 1) {
                // 不断pop左边的字符并数量-1
                char popC = scs[left];
                window.put(popC, window.get(popC) - 1);
                // 缩小窗口
                left++;
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }
}
