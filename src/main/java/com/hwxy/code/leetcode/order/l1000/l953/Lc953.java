package com.hwxy.code.leetcode.order.l1000.l953;

import java.util.HashMap;
import java.util.Map;

/**
 * 953. 验证外星语词典
 * https://leetcode.cn/problems/verifying-an-alien-dictionary/
 * 
 * @author hwxy
 * @date 2022/05/17
 **/
public class Lc953 {
    public boolean isAlienSorted(String[] words, String order) {
        if (words == null || words.length == 0 || order == null || order.isEmpty()) {
            return false;
        }
        // 索引
        Map<Character, Integer> charIndexer = new HashMap<>(26);
        char[] cs = order.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            charIndexer.put(cs[i], i);
        }
        for (int left = 0, right = 1; right < words.length; left++, right++) {
            char[] lcs = words[left].toCharArray();
            char[] rcs = words[right].toCharArray();
            // [quvp,k],[apple,app]
            for (int i = 0; i < Math.min(lcs.length, rcs.length); i++) {
                // 每次都要判读,只有==才会对相同的2个词持续判断,>直接false,<要进行下一轮
                if (charIndexer.get(lcs[i]) > charIndexer.get(rcs[i])) {
                    return false;
                } else if (charIndexer.get(lcs[i]) < charIndexer.get(rcs[i])) {
                    break;
                }
            }
            // 对于[apple,app]这种要进行额外判断
            if (lcs.length > rcs.length) {
                if (charIndexer.get(lcs[rcs.length - 1]) >= charIndexer.get(rcs[rcs.length - 1])) {
                    return false;
                }
            }
        }
        return true;
    }
}
