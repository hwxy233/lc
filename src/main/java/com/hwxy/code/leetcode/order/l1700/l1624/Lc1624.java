package com.hwxy.code.leetcode.order.l1700.l1624;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1624. 两个相同字符之间的最长子字符串
 * https://leetcode.cn/problems/largest-substring-between-two-equal-characters/
 *
 * @author hwxy
 * @date 2022/09/17
 */
public class Lc1624 {
    public int maxLengthBetweenEqualCharacters(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        char[] scs = s.toCharArray();
        // 我还以为滑动窗口呢...
        Map<Character, List<Integer>> cIndexes = new HashMap<>();
        for (int i = 0; i < scs.length; i++) {
            cIndexes.computeIfAbsent(scs[i], c -> new ArrayList<>()).add(i);
        }
        int ans = -1;
        for (List<Integer> indexes : cIndexes.values()) {
            if (indexes.size() < 2) {
                continue;
            }
            ans = Math.max(ans, indexes.get(indexes.size() - 1) - indexes.get(0) - 1);
        }
        return ans;
    }
}
