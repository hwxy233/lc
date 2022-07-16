package com.hwxy.code.leetcode.order.l600.l567;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 567. 字符串的排列
 * https://leetcode.cn/problems/permutation-in-string/
 * 
 * @author hwxy
 * @date 2022/07/16
 **/
public class Lc567 {
    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() > s2.length()) {
            return false;
        }
        char[] s1cs = s1.toCharArray();
        Map<Character, Integer> need = new HashMap<>();
        for (char s1c : s1cs) {
            need.put(s1c, need.getOrDefault(s1c, 0) + 1);
        }
        char[] s2cs = s2.toCharArray();
        // 相当于是定长的窗口
        Map<Character, Integer> window = new HashMap<>(s1cs.length);
        // 只要和need大小相同了就说明有这个子串
        int valid = 0;
        int right = 0;
        int left = 0;
        while (right < s2cs.length) {
            char c = s2cs[right];
            // 更新窗口
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (Objects.equals(window.get(c), need.get(c))) {
                    valid++;
                }
            }
            // 定长窗口长度最长和s1一样
            while (right - left + 1 >= s1cs.length) {
                // 这时说明valid如果等于need则返回true
                if (valid == need.size()) {
                    return true;
                }
                char popC = s2cs[left];
                if (need.containsKey(popC)) {
                    // 需要撤销valid
                    if (Objects.equals(need.get(popC), window.get(popC))) {
                        valid--;
                    }
                    window.put(popC, window.getOrDefault(popC, 1) - 1);
                }
                left++;
            }
            right++;
        }
        return false;
    }
}
