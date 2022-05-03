package com.hwxy.leetcode.order.l100.l49;

import java.util.*;

/**
 * 49. 字母异位词分组
 * https://leetcode-cn.com/problems/group-anagrams/
 * 
 * @author hwxy
 * @date 2022/05/03
 **/
public class Lc49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return Collections.emptyList();
        }
        Map<String, List<String>> sortedStrRes = new HashMap<>();
        for (String str : strs) {
            char[] cs = str.toCharArray();
            Arrays.sort(cs);
            sortedStrRes.computeIfAbsent(new String(cs), s -> new ArrayList<>()).add(str);
        }
        List<List<String>> res = new ArrayList<>(sortedStrRes.size());
        res.addAll(sortedStrRes.values());
        return res;
    }
}
