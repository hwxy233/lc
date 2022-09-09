package com.hwxy.code.leetcode.order.l1600.l1598;

/**
 * 1598. 文件夹操作日志搜集器
 *
 * <p>https://leetcode.cn/problems/crawler-log-folder/
 *
 * @author hwxy
 * @date 2022/09/09
 */
public class Lc1598 {
    public static final String CUR_DIR = "./";
    public static final String PARENT_DIR = "../";

    public int minOperations(String[] logs) {
        if (logs == null || logs.length == 0) {
            return 0;
        }
        int ans = 0;
        for (String log : logs) {
            if (CUR_DIR.equals(log)) {
                continue;
            } else if (PARENT_DIR.equals(log)) {
                if (ans == 0) {
                    continue;
                }
                ans -= 1;
            } else {
                ans += 1;
            }
        }
        return ans;
    }
}
