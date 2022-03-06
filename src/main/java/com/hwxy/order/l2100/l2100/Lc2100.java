package com.hwxy.order.l2100.l2100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 2100. 适合打劫银行的日子
 * https://leetcode-cn.com/problems/find-good-days-to-rob-the-bank/
 * 
 * @author hwxy
 * @date 2022/03/06
 **/
public class Lc2100 {
    public static void main(String[] args) {
        System.out.println(new Lc2100().goodDaysToRobBank(new int[] {5, 3, 3, 3, 5, 6, 2}, 2));
        System.out.println(new Lc2100().goodDaysToRobBank(new int[] {1, 1, 1, 1, 1}, 0));
        System.out.println(new Lc2100().goodDaysToRobBank(new int[] {1, 2, 3, 4, 5, 6}, 2));
    }

    /**
     * 官方说是动态规划但是好像没什么关系...
     * 
     * @param security
     * @param time
     * @return
     */
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        if (security == null || security.length == 0) {
            return Collections.emptyList();
        }
        // 先统计非递增和非递减的长度
        int[] notInc = new int[security.length];
        int[] notDesc = new int[security.length];
        notInc[0] = 0;
        // notInc[i]表示到第i天(包括i)的费递增天数
        for (int i = 1; i < security.length; i++) {
            if (security[i] <= security[i - 1]) {
                notInc[i] = notInc[i - 1] + 1;
            }
        }
        notDesc[notDesc.length - 1] = 0;
        // notDesc[i]表示到第i天(包括i)的费递减天数,从后向前统计
        for (int i = security.length - 2; i >= 0; i--) {
            if (security[i] <= security[i + 1]) {
                notDesc[i] = notDesc[i + 1] + 1;
            }
        }
        List<Integer> res = new ArrayList<>(security.length);
        // 如果某一天的非递减和费递增的数量都>=time则说明可以的
        for (int i = time; i < security.length - time; i++) {
            if (notInc[i] >= time && notDesc[i] >= time) {
                res.add(i);
            }
        }
        return res;
    }
}
