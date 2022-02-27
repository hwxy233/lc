package com.hwxy.order.l6100.l6009;

/**
 * 6009. 使两字符串互为字母异位词的最少步骤数
 * https://leetcode-cn.com/contest/weekly-contest-282/problems/minimum-number-of-steps-to-make-two-strings-anagram-ii/
 * 
 * 英文字母的数量是26个,不是24个
 * 
 * @author hwxy
 * @date 2022/02/27
 **/
public class Lc6009 {
    public static void main(String[] args) {
        System.out.println(new Lc6009().minSteps("cotxazilut", "nahrrmcchxwrieqqdwdpneitkxgnt"));
    }

    public int minSteps(String s, String t) {
        if (s == null || t == null) {
            return 0;
        }
        // 先统计数量
        int[] swc = new int[26];
        int[] twc = new int[26];
        for (char sc : s.toCharArray()) {
            swc[sc - 'a'] += 1;
        }
        for (char tc : t.toCharArray()) {
            twc[tc - 'a'] += 1;
        }
        // 然后挨个寻找不同的数量
        int res = 0;
        for (int i = 0; i < swc.length; i++) {
            if (swc[i] == twc[i]) {
                continue;
            }
            // 这时候数量是不同的,差值的绝对值就是步骤书
            res += Math.abs(swc[i] - twc[i]);
        }
        return res;
    }
}
