package com.hwxy.code.leetcode.order.l6100.l6064;

import java.util.Arrays;

/**
 * 6064. 不含特殊楼层的最大连续楼层数
 * https://leetcode.cn/contest/weekly-contest-293/problems/maximum-consecutive-floors-without-special-floors/
 * 
 * @author hwxy
 * @date 2022/05/15
 **/
public class Lc6064 {
    public int maxConsecutive(int bottom, int top, int[] special) {
        if (bottom >= top || special.length >= (top - bottom + 1)) {
            return 0;
        }
        // 直接遍历special
        Arrays.sort(special);
        int ans = special[0] - bottom;;
        for (int i = 1; i < special.length; i++) {
            int count = special[i] - special[i - 1] - 1;
            ans = Math.max(ans, count);
        }
        // 最后的
        ans = Math.max(ans, top - special[special.length - 1]);
        return ans;
    }
}
