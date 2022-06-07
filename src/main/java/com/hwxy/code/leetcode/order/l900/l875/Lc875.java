package com.hwxy.code.leetcode.order.l900.l875;

/**
 * 875. 爱吃香蕉的珂珂
 * https://leetcode.cn/problems/koko-eating-bananas/
 * 
 * @author hwxy
 * @date 2022/06/07
 **/
public class Lc875 {
    public int minEatingSpeed(int[] piles, int h) {
        if (piles == null || piles.length == 0 || h < 1) {
            return 0;
        }
        // 红蓝二分查找,下界为0(1-1),最小一个小时吃1根香蕉;上界为max+1,最多一小时吃一堆香蕉
        int l = 0;
        int r = 0;
        for (int pile : piles) {
            r = Math.max(r, pile);
        }
        r = r + 1;
        // isBlue为吃香蕉速度为mid时所花时间>h,所以最终返回r
        while (l + 1 != r) {
            int mid = (l + r) >> 1;
            if (isBlue(mid, piles, h)) {
                l = mid;
            } else {
                r = mid;
            }
        }
        return r;
    }

    private boolean isBlue(int mid, int[] piles, int h) {
        int k = 0;
        for (int pile : piles) {
            // 时间向上取整
            k += pile % mid == 0 ? pile / mid : pile / mid + 1;
        }
        return k > h;
    }
}
