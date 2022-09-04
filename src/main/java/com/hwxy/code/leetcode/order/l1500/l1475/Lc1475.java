package com.hwxy.code.leetcode.order.l1500.l1475;

/**
 * 1475. 商品折扣后的最终价格
 *
 * <p>https://leetcode.cn/problems/final-prices-with-a-special-discount-in-a-shop/
 *
 * @author hwxy
 * @date 2022/09/01
 */
public class Lc1475 {
    public int[] finalPrices(int[] prices) {
        if (prices == null || prices.length == 0) {
            return prices;
        }
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] >= prices[j]) {
                    prices[i] -= prices[j];
                    break;
                }
            }
        }
        return prices;
    }
}
