package com.hwxy.code.leetcode.order.l1700.l1684;

import java.util.HashSet;
import java.util.Set;

/**
 * 1684. 统计一致字符串的数目
 * https://leetcode.cn/problems/count-the-number-of-consistent-strings/
 *
 * @author hwxy
 * @date 2022/11/08
 **/
public class Lc1684 {
    public int countConsistentStrings(String allowed, String[] words) {
        if (allowed == null || allowed.isEmpty() || words == null || words.length == 0) {
            return 0;
        }
        Set<Character> allowedCharSet = new HashSet<>();
        for (char c : allowed.toCharArray()) {
            allowedCharSet.add(c);
        }
        int ans = 0;
        for (String word : words) {
            boolean canAdd = true;
            char[] wcs = word.toCharArray();
            Set<Character> wcSet = new HashSet<>();
            for (char c : wcs) {
                wcSet.add(c);
            }
            if (wcSet.size() > allowedCharSet.size()) {
                continue;
            }
            for (char c : wcSet) {
                if (!allowedCharSet.contains(c)) {
                    canAdd = false;
                    break;
                }
            }
            if (canAdd) {
                ans++;
            }
        }
        return ans;
    }
}
