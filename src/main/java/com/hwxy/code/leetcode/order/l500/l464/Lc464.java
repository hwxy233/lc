package com.hwxy.code.leetcode.order.l500.l464;

import java.util.HashMap;
import java.util.Map;

/**
 * 464. 我能赢吗
 * https://leetcode.cn/problems/can-i-win/
 * 
 * @author hwxy
 * @date 2022/05/22
 **/
public class Lc464 {
    private int[] state;
    private Map<Integer, Boolean> dfsed;

    private int sum;

    /**
     * https://www.bilibili.com/video/BV1ox411j74S?spm_id_from=333.337.search-card.all.click
     * 这道题就是在考对“稳赢”的理解。
     * 这里的“稳赢”指的是，在我拿到第一个数之后，后面所有的数，你拿到哪一个，我都有对应的赢你的办法。
     * 举个栗子：1~16，比如我先拿到15会“稳赢”，就是剩下的1~14,16这些数，
     * 接下来你拿到任意一个数，我都有对应的套路拿到下一个能赢的数，一直到最后。
     * 而不是，我拿到15之后，其余闭着眼拿，不论拿到啥都能赢你。解题思路就是，找到一个，对方“稳输”的数，
     * 然后，所有已经出现的结果，要存储起来，不然执行次数上亿次，稳稳的超时。
     * 
     * @param maxChoosableInteger
     * @param desiredTotal
     * @return
     */
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if ((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal) {
            return false;
        }
        state = new int[maxChoosableInteger];
        dfsed = new HashMap<>();
        sum = 0;
        return backtracking(0, maxChoosableInteger, desiredTotal);
    }

    /**
     * 用一个int值(32位)可以记录下这最长的20个数
     * Arrays.toString(state)这样会超时
     * 
     * @param key 使用的数的组合,不能回溯掉只能放到参数里
     * @param maxChoosableInteger
     * @param desiredTotal
     * @return
     */
    private boolean backtracking(int key, int maxChoosableInteger, int desiredTotal) {
        // String key = Arrays.toString(state);
        if (dfsed.containsKey(key)) {
            return dfsed.get(key);
        }
        for (int i = 1; i <= maxChoosableInteger; i++) {
            if (state[i - 1] == 1) {
                continue;
            }
            sum += i;
            state[i - 1] = 1;
            // 1 << i | key 代表第i个数使用了顺便记录下之前使用的
            // 如果这次我赢了或者你没有赢则最终算我赢
            if (sum >= desiredTotal ||
                    !backtracking(1 << i | key, maxChoosableInteger, desiredTotal)) {
                dfsed.put(key, true);
                // 所有返回的地方都要回溯
                state[i - 1] = 0;
                sum -= i;
                return true;
            }
            state[i - 1] = 0;
            sum -= i;
        }
        dfsed.put(key, false);
        return false;
    }
}
