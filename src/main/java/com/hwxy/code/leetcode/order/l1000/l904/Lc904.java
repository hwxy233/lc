package com.hwxy.code.leetcode.order.l1000.l904;

import java.util.HashMap;
import java.util.Map;

/**
 * 904. 水果成篮
 * https://leetcode.cn/problems/fruit-into-baskets/
 *
 * @author hwxy
 * @date 2022/10/17
 **/
public class Lc904 {
    public int totalFruit(int[] fruits) {
        if (fruits == null || fruits.length == 0) {
            return 0;
        }
        int ans = 0;
        // 使用map作为窗口记录出现次数
        Map<Integer, Integer> window = new HashMap<>();
        int l = 0;
        int r = 0;
        while (r < fruits.length) {
            if (window.containsKey(fruits[r]) || window.size() < 2) {

            } else {
                // 只要出现第三种数字就滑动直到2种
                ans = Math.max(ans, r - 1 - l + 1);
                while (window.size() > 1) {
                    int cnt = window.get(fruits[l]);
                    cnt--;
                    // 只要cnt=0了就移出
                    if (cnt == 0) {
                        window.remove(fruits[l]);
                    } else {
                        window.put(fruits[l], cnt);
                    }
                    l++;
                }
            }
            window.put(fruits[r], window.getOrDefault(fruits[r], 0) + 1);
            r++;
        }
        ans = Math.max(ans, r - 1 - l + 1);
        return ans;
    }
}
