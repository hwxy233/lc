package com.hwxy.code.leetcode.order.l1700.l1668;

/**
 * 1668. 最大重复子字符串
 * https://leetcode.cn/problems/maximum-repeating-substring/
 *
 * @author hwxy
 * @date 2022/11/03
 **/
public class Lc1668 {
    public int maxRepeating(String sequence, String word) {
        if (sequence == null
                || sequence.isEmpty()
                || word == null
                || word.isEmpty()
                || sequence.length() < word.length()) {
            return 0;
        }
        int ans = 0;
        for (int i = 0; i < sequence.length(); i++) {
            int j = i;
            if (sequence.startsWith(word, j)) {
                int curCnt = 1;
                j += word.length();
                while (sequence.startsWith(word, j)) {
                    curCnt++;
                    j += word.length();
                }
                ans = Math.max(ans, curCnt);
            }
        }
        return ans;
    }
}
