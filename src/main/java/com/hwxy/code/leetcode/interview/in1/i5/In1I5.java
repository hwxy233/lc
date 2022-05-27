package com.hwxy.code.leetcode.interview.in1.i5;

/**
 * 面试题 01.05. 一次编辑
 * https://leetcode.cn/problems/one-away-lcci/
 * 
 * @author hwxy
 * @date 2022/05/13
 **/
public class In1I5 {
    public boolean oneEditAway(String first, String second) {
        if (first == null || second == null) {
            return false;
        }
        // 长度最多相差一个
        if (Math.abs(first.length() - second.length()) > 1) {
            return false;
        }
        // 如果2个字符串的长度相同则只要按照顺序找到2个不同就false
        char[] fcs = first.toCharArray();
        // 如果2个字符串长度不同,则不同的时候长的多移动一次,移动2次则false
        char[] scs = second.toCharArray();
        if (fcs.length == scs.length) {
            return diffEq(fcs, scs);
        } else if (fcs.length > scs.length) {
            return diffNotEq(fcs, scs);
        } else {
            return diffNotEq(scs, fcs);
        }
    }

    private boolean diffNotEq(char[] longCs, char[] shortCs) {
        int diffCnt = 0;
        for (int i = 0, j = 0; diffCnt <= 2 && i < longCs.length && j < shortCs.length; i++, j++) {
            if (longCs[i] != shortCs[j]) {
                diffCnt++;
                // 长的移动,短的不移动
                j--;
            }
        }
        return diffCnt <= 1;
    }

    private boolean diffEq(char[] fcs, char[] scs) {
        int diffCnt = 0;
        for (int i = 0; i < fcs.length && diffCnt <= 2; i++) {
            if (fcs[i] != scs[i]) {
                diffCnt++;
            }
        }
        return diffCnt <= 1;
    }
}
