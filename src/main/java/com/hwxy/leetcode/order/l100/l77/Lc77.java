package com.hwxy.leetcode.order.l100.l77;

import java.util.LinkedList;
import java.util.List;

import lombok.Getter;

@Getter
public class Lc77 {

    /**
     * 最终结果
     */
    private final List<List<Integer>> result = new LinkedList<>();

    /**
     * 每次回溯的结果
     */
    private final LinkedList<Integer> path = new LinkedList<>();

    public static void main(String[] args) {
        Lc77 lc77 = new Lc77();
        System.out.println(lc77.combine(4, 3));
    }

    public List<List<Integer>> combine(int n, int k) {
        if (n <= 0 || k <= 0) {
            return null;
        }
        backtracking(n, k, 1);
        return result;
    }

    /**
     * 回溯(递归)函数
     * 
     * @param n 共n个数 树的宽度
     * @param k 要组合多少个数 树的深度
     * @param startIndex n里的索引
     */
    private void backtracking(int n, int k, int startIndex) {
        // path的大小等于k了，就结束
        if (path.size() == k) {
            result.add(new LinkedList<>(path));
            return;
        }
        // 横向,startIndex记录到哪了
        // 剪枝(for循环选择的起始位置之后的元素个数 已经不足 我们需要的元素个数了，那么就没有必要搜索了):
        // 还需要的元素数(k - path.size()) ,至多要从该起始位置 : n - (k - path.size()) + 1,+1是因为<=
        // eg: n=4,k=2,最多从(4 - (2 - 0) + 1)=3,也就是i最大是3
        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            // 纵向,递归了
            backtracking(n, k, i + 1);
            // 回溯,弹出最后的元素
            path.removeLast();
        }
    }
}
