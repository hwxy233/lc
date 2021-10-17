package com.hwxy.order.l300.l216;

import java.util.LinkedList;
import java.util.List;

/**
 * 干嘛的
 *
 * @author hwxy
 * @date 2021/07/11
 **/
public class Lc216 {

    public static void main(String[] args) {
        Lc216 lc216 = new Lc216();
        System.out.println(lc216.combinationSum3(3, 9));
    }

    private List<List<Integer>> result = null;

    private final LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        if (k <= 0 || n <= 0) {
            return result;
        }
        result = new LinkedList<>();
        backtracking(k, n, 1, 0);
        return result;
    }

    /**
     * 横着遍历1~9
     * 竖着遍历除了开头的
     * 
     * @param k 几个数累加
     * @param n 和是多少
     * @param startIndex 到哪个数字了
     * @param sum 当前的和
     */
    private void backtracking(int k, int n, int startIndex, int sum) {
        // 超出了范围的就减掉
        if (sum > n) {
            return;
        }
        if (path.size() == k) {
            // 如果和相等了
            if (sum == n) {
                result.add(new LinkedList<>(path));
            }
            return;
        }
        // 横着1~9,应该可以jianzhi, 横向不足3个的减掉
        for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i++) {
            path.add(i);
            sum += i;
            backtracking(k, n, i + 1, sum);
            // 弹出元素和减少sum
            path.removeLast();
            sum -= i;
        }
    }
}
