package com.hwxy.code.leetcode.order.l1700.l1652;

/**
 * 1652. 拆炸弹
 * https://leetcode.cn/problems/defuse-the-bomb/
 *
 * @author hwxy
 * @date 2022/09/24
 **/
public class Lc1652 {
    public int[] decrypt(int[] code, int k) {
        if (code == null || code.length == 0) {
            return code;
        }
        if (k == 0) {
            return new int[code.length];
        }
        int[] ans = new int[code.length];
        // 注意好求模
        if (k < 0) {
            for (int i = 0; i < code.length; i++) {
                for (int j = 1; j <= -k; j++) {
                    ans[i] += code[(code.length + i - j) % code.length];
                }
            }
        } else {
            for (int i = 0; i < code.length; i++) {
                for (int j = 1; j <= k; j++) {
                    ans[i] += code[(code.length + i + j) % code.length];
                }
            }
        }
        return ans;
    }
}
