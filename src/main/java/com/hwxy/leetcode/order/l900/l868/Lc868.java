package com.hwxy.leetcode.order.l900.l868;

/**
 * 868. 二进制间距
 * https://leetcode-cn.com/problems/binary-gap/
 * 
 * @author hwxy
 * @date 2022/04/24
 **/
public class Lc868 {
    public int binaryGap(int n) {
        if (n < 1) {
            return 0;
        }
        int res = 0;
        String binary = Integer.toBinaryString(n);
        char[] bcs = binary.toCharArray();
        int preOneIndex = -1;
        for (int i = 0; i < bcs.length; i++) {
            if (bcs[i] != '1') {
                continue;
            }
            if (preOneIndex != -1) {
                res = Math.max(res, i - preOneIndex);
            }
            preOneIndex = i;
        }
        // 也可以直接位运算和1做&运算然后移位这样找到最低位的1
        // int last = -1, ans = 0;
        // for (int i = 0; n != 0; ++i) {
        // if ((n & 1) == 1) {
        // if (last != -1) {
        // ans = Math.max(ans, i - last);
        // }
        // last = i;
        // }
        // n >>= 1;
        // }
        return res;
    }
}
