package com.hwxy.leetcode.order.l100.l40;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * 干嘛的
 *
 * @author hwxy
 * @date 2021/07/17
 **/
public class Lc40 {

    public static void main(String[] args) {
        Lc40 lc40 = new Lc40();
        System.out.println(lc40.combinationSum2(new int[] {10, 1, 2, 7, 6, 1, 5}, 8));
    }

    private List<List<Integer>> result = new LinkedList<>();

    private LinkedList<Integer> tmp = new LinkedList<>();

    /**
     * 去重使用
     * 去重的是树层间,不是树枝间
     * 说明意思呢,在排序后,如果当前一个元素和前一个相同,这是要去重了
     * 这么去呢
     * 如果这时used是true说明是同一个组合(树枝的)不用管
     * 但是如果是false,就说明是上一个树层使用过的
     */
    private boolean[] used;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (Objects.isNull(candidates) || candidates.length == 0 || target <= 0) {
            return result;
        }
        used = new boolean[candidates.length];
        // Arrays.fill(used, false);
        Arrays.sort(candidates);
        backtracking(candidates, 0, 0, target, 0);
        return result;
    }

    /**
     * 记得消去重复遍历过得
     * 
     * @param candidates
     * @param index
     * @param sum
     * @param target
     * @param count
     */
    private void backtracking(int[] candidates, int index, int sum, int target, int count) {
        if (sum > target) {
            return;
        } else if (sum == target) {
            result.add(new LinkedList<>(tmp));
            // 应当return
            return;
        }
        for (int i = index; i < candidates.length && sum + candidates[i] <= target; i++) {
            // 这里是这样的假设数组为[1,1,2]编号为a,b,c;在a的1遍历时用到1,1时,used为[t,t,f]
            // 当b的1遍历时以为和a的位置相同了这是used为[f,f,f]
            // 这里used的true就表示是树枝用了,false为树层用了
            if (i != 0 && candidates[i] == candidates[i - 1] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            // 操作
            tmp.add(candidates[i]);
            backtracking(candidates, i + 1, sum + candidates[i], target, count + 1);
            // 撤销
            tmp.removeLast();
            used[i] = false;
        }
    }
}
