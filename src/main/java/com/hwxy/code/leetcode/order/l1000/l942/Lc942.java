package com.hwxy.code.leetcode.order.l1000.l942;

/**
 * 942. 增减字符串匹配
 * https://leetcode.cn/problems/di-string-match/
 * 
 * @author hwxy
 * @date 2022/05/09
 **/
public class Lc942 {

    /**
     * 贪心🤔
     * 每次都选最大/最小数
     * 只要是I就赋值成min++,D就是max--
     * 再根据最后一位是I还是D给结果的最后一个元素赋值
     * 
     * @param s
     * @return
     */
    public int[] diStringMatch(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        int max = s.length();
        int min = 0;
        int[] ans = new int[s.length() + 1];
        char[] scs = s.toCharArray();
        // 只要是I就赋值成min++,D就是max--
        for (int i = 0; i < scs.length; i++) {
            if (scs[i] == 'I') {
                ans[i] = min++;
            } else {
                ans[i] = max--;
            }
        }
        // 此时min==max
        if (s.charAt(s.length() - 1) == 'I') {
            ans[ans.length - 1] = min;
        } else {
            ans[ans.length - 1] = max;
        }
        return ans;
    }
}
