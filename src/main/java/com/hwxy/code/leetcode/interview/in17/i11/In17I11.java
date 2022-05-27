package com.hwxy.code.leetcode.interview.in17.i11;

/**
 * 面试题 17.11. 单词距离
 * https://leetcode.cn/problems/find-closest-lcci/
 * 
 * @author hwxy
 * @date 2022/05/27
 **/
public class In17I11 {
    /**
     * 同方向
     * 
     * @param words
     * @param word1
     * @param word2
     * @return
     */
    public int findClosest(String[] words, String word1, String word2) {
        if (words == null || words.length < 2 || word1 == null || word2 == null
                || word1.equals(word2)) {
            return -1;
        }
        int ans = Integer.MAX_VALUE;
        // 都是左边最后的下标
        int word1Index = -1;
        int word2Index = -1;
        // 每次和左边最后的下标比较即可,同方向的双指针
        for (int i = 0; i < words.length; i++) {
            if (word1.equals(words[i])) {
                word1Index = i;
            } else if (word2.equals(words[i])) {
                word2Index = i;
            }
            if (word1Index >= 0 && word2Index >= 0) {
                ans = Math.min(ans, Math.abs(word1Index - word2Index));
            }
        }
        return ans;
    }
}
