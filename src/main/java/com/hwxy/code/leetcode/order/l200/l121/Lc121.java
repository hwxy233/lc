package com.hwxy.code.leetcode.order.l200.l121;

/**
 * 121. 买卖股票的最佳时机
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 * 
 * @author hwxy
 * @date 2022/05/06
 **/
public class Lc121 {
    /**
     * 滑动窗口
     * 右边不断移动,左边只要大于右边就进行右移
     * 
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int ans = 0;
        for (int left = 0, right = 1; right < prices.length; right++) {
            // 右移左窗口
            while (left < right && prices[left] >= prices[right]) {
                left++;
            }
            ans = Math.max(ans, prices[right] - prices[left]);
        }
        return ans;
    }
}
