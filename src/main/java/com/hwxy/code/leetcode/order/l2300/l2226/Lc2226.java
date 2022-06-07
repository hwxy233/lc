package com.hwxy.code.leetcode.order.l2300.l2226;

/**
 * 2226. 每个小孩最多能分到多少糖果
 * https://leetcode.cn/problems/maximum-candies-allocated-to-k-children/
 * 
 * @author hwxy
 * @date 2022/06/07
 **/
public class Lc2226 {
    public int maximumCandies(int[] candies, long k) {
        if (candies == null || candies.length == 0 || k < 1) {
            return 0;
        }
        // 红蓝二分查找,下界为0(1-1),上界为平均值+1
        long l = 0;
        long r = 0;
        for (int candie : candies) {
            r += candie;
        }
        r = r / k + 1;
        // isBlue:按照mid分的堆数>=k,返回l
        while (l + 1 != r) {
            long mid = (l + r) >> 1;
            if (isBlue(candies, mid, k)) {
                l = mid;
            } else {
                r = mid;
            }
        }
        return (int) l;
    }

    private boolean isBlue(int[] candies, long mid, long k) {
        if (mid == 0) {
            return false;
        }
        long cnt = 0;
        for (int candie : candies) {
            cnt += candie / mid;
        }
        return cnt >= k;
    }
}
