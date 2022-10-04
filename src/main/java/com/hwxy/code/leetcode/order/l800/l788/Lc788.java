package com.hwxy.code.leetcode.order.l800.l788;

/**
 * 788. 旋转数字
 * https://leetcode.cn/problems/rotated-digits/
 *
 * @author hwxy
 * @date 2022/09/25
 **/
public class Lc788 {
    public int rotatedDigits(int n) {
        if (n < 1) {
            return 0;
        }
        int ans = 0;
        // 直接遍历即可
        for (int i = 1; i <= n; i++) {
            char[] isCs = String.valueOf(i).toCharArray();
            int cnt018 = 0;
            boolean contains347 = false;
            for (char isc : isCs) {
                if (isc == '3' || isc == '4' || isc == '7') {
                    contains347 = true;
                    break;
                }
                if (isc == '0' || isc == '1' || isc == '8') {
                    cnt018++;
                }
            }
            if (contains347 || cnt018 == isCs.length) {
                continue;
            }
            ans++;
        }
        return ans;
    }
}
