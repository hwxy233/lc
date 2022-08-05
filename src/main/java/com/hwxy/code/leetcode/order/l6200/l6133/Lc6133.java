package com.hwxy.code.leetcode.order.l6200.l6133;

/**
 * 6133. 分组的最大数量
 * https://leetcode.cn/problems/maximum-number-of-groups-entering-a-competition/
 * 
 * @author hwxy
 * @date 2022/08/01
 **/
public class Lc6133 {
    public int maximumGroups(int[] grades) {
        if (grades == null || grades.length == 0) {
            return 0;
        }
        // 其实和分数无关,相当于先排序然后从1,2,3,4...这样进行选择罢了
        int n = grades.length;
        int ans = 0;
        int preSize = 1;
        while (n >= preSize) {
            n -= preSize;
            ans++;
            preSize++;
        }
        return ans;
    }
}
