package com.hwxy.code.leetcode.order.l500.l424;

/**
 * 424. 替换后的最长重复字符
 * https://leetcode-cn.com/problems/longest-repeating-character-replacement/
 * 
 * @author hwxy
 * @date 2022/05/06
 **/
public class Lc424 {
    /**
     * 滑动窗口
     * 每次右移时记录该字符出现的次数和最多出现字符放入次数进行比较
     * 如果发现此时窗口长度-最大字符长度>k的话说明需要滑动窗口
     * 减少最左字符的次数
     * 最终的结果就是窗口的长度
     * 窗口增大和最多字符的次数一定是同时增长的,如果窗口长度不变(平移)那么最多字符的次数一定不变
     * 
     * @param s
     * @param k
     * @return
     */
    public int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] charCount = new int[26];
        char[] scs = s.toCharArray();
        int maxCharLength = 0;
        int ans = 0;
        for (int left = 0, right = 0; right < scs.length; right++) {
            // 每次右边进来字符就进行次数增加
            charCount[scs[right] - 'A']++;
            maxCharLength = Math.max(maxCharLength, charCount[scs[right] - 'A']);
            // 如果窗口区间减去最多出现的字符>k说明需要右移左窗口
            if (right - left + 1 - maxCharLength > k) {
                left++;
                charCount[scs[left] - 'A']--;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
