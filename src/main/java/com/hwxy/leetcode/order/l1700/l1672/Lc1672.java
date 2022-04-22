package com.hwxy.leetcode.order.l1700.l1672;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 1672. 最富有客户的资产总量
 * https://leetcode-cn.com/problems/richest-customer-wealth/
 * 
 * @author hwxy
 * @date 2022/04/14
 **/
public class Lc1672 {
    /**
     * 算每行的大小
     * 
     * @param accounts
     * @return
     */
    public int maximumWealth(int[][] accounts) {
        if (accounts == null) {
            return 0;
        }
        return Arrays.stream(accounts).map((int[] a) -> Arrays.stream(a).sum())
                .max(Comparator.naturalOrder())
                .get();
    }
}
