package com.hwxy.order.l100.l77;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import com.hwxy.type.tree.TreeNode;
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
        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            // 纵向,递归了
            backtracking(n, k, i + 1);
            // 回溯,弹出最后的元素
            path.removeLast();
        }
    }
}
