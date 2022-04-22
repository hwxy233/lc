package com.hwxy.leetcode.order.l400.l386;

import java.util.ArrayList;
import java.util.List;

/**
 * 386. 字典序排数
 * https://leetcode-cn.com/problems/lexicographical-numbers/
 * 
 * @author hwxy
 * @date 2022/04/18
 **/
public class Lc386 {
    private List<Integer> res;
    private int max;

    /**
     * 深度优先搜索
     * 从[1,9]每个都dfs一遍
     * 在dfs里对参数index进行[0,9]的index*=10 + i的dfs
     * 
     * @param n
     * @return
     */
    public List<Integer> lexicalOrder(int n) {
        if (n < 1) {
            return null;
        }
        res = new ArrayList<>(n);
        max = n;
        for (int i = 1; i < 10; i++) {
            dfs(i);
        }
        return res;
    }

    private void dfs(int index) {
        if (index > max) {
            return;
        }
        res.add(index);
        // 从0开始,下个dfs会进行判断范围
        for (int i = 0; i < 10; i++) {
            dfs(index * 10 + i);
        }
    }
}
