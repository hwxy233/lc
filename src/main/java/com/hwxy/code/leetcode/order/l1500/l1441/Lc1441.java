package com.hwxy.code.leetcode.order.l1500.l1441;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 1441. 用栈操作构建数组
 * https://leetcode.cn/problems/build-an-array-with-stack-operations/
 *
 * @author hwxy
 * @date 2022/10/15
 **/
public class Lc1441 {
    public static final String PUSH = "Push";
    public static final String POP = "Pop";

    public List<String> buildArray(int[] target, int n) {
        if (target == null || target.length == 0 || n < 1 || target.length > n) {
            return Collections.emptyList();
        }
        List<String> ans = new ArrayList<>();
        // j用来遍历target,i用来遍历n
        int j = 0;
        for (int i = 1; i <= n; i++) {
            if (j == target.length) {
                break;
            }
            // 如果不是当前的target就先PUSH再POP
            if (i != target[j]) {
                ans.add(PUSH);
                ans.add(POP);
            } else {
                // 否则直接PUSH
                ans.add(PUSH);
                j++;
            }
        }
        return ans;
    }
}
