package com.hwxy.code.leetcode.order.l900.l890;

import java.util.*;

/**
 * 890. 查找和替换模式
 * https://leetcode.cn/problems/find-and-replace-pattern/
 * 
 * @author hwxy
 * @date 2022/06/12
 **/
public class Lc890 {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        if (words == null || words.length == 0 || pattern == null || pattern.length() == 0) {
            return Collections.emptyList();
        }
        char[] pcs = pattern.toCharArray();
        List<String> ans = new ArrayList<>();
        for (String word : words) {
            if (word.length() != pcs.length) {
                continue;
            }
            Map<Character, Character> pToW = new HashMap<>();
            Map<Character, Character> wToP = new HashMap<>();
            char[] wcs = word.toCharArray();
            boolean canAdd = true;
            for (int i = 0; i < wcs.length; i++) {
                // 1.先看pToW有没有
                Character w = pToW.get(pcs[i]);
                if (w == null) {
                    // 然后反向看wToP有没有
                    Character p = wToP.get(wcs[i]);
                    if (p == null) {
                        // 反向没有说明确实没有映射
                        pToW.put(pcs[i], wcs[i]);
                        wToP.put(wcs[i], pcs[i]);
                    } else {
                        // 反向有如果不等于当前p则有问题 p=abb;w=ccc
                        if (p != pcs[i]) {
                            canAdd = false;
                            break;
                        }
                    }
                } else {
                    // 2.否则必须和当前w相等 p=abb,w=abc
                    if (w != wcs[i]) {
                        canAdd = false;
                        break;
                    }
                }
            }
            if (canAdd) {
                ans.add(word);
            }
        }
        return ans;
    }
}
