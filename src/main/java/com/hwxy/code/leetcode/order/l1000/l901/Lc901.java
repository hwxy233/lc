package com.hwxy.code.leetcode.order.l1000.l901;

import java.util.ArrayList;
import java.util.List;

/**
 * 901. 股票价格跨度
 * https://leetcode.cn/problems/online-stock-span/
 *
 * @author hwxy
 * @date 2022/10/21
 **/
public class Lc901 {
    class StockSpanner {
        /**
         * dp[i]=前面所有小于dp[i]的和
         * 注意每次减去下标的step为dp的值
         * 也可以是用单调栈
         */
        private List<Pair> dp;

        public StockSpanner() {
            dp = new ArrayList<>();
        }

        public int next(int price) {
            int lowerCnt = 1;
            for (int i = dp.size() - 1; i >= 0; ) {
                Pair pair = dp.get(i);
                if (price < pair.price) {
                    break;
                }
                lowerCnt += pair.lowerCnt;
                i -= pair.lowerCnt;
            }
            dp.add(new Pair(price, lowerCnt));
            return lowerCnt;
        }
    }

    static class Pair {
        int price;
        int lowerCnt;

        public Pair(int price, int lowerCnt) {
            this.price = price;
            this.lowerCnt = lowerCnt;
        }
    }
}
