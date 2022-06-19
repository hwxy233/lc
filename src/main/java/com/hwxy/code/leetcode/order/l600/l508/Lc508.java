package com.hwxy.code.leetcode.order.l600.l508;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hwxy.code.ds.TreeNode;

/**
 * 508. 出现次数最多的子树元素和
 * https://leetcode.cn/problems/most-frequent-subtree-sum/
 * 
 * @author hwxy
 * @date 2022/06/19
 **/
public class Lc508 {
    private Map<Integer, Integer> map;
    private int maxCnt;

    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) {
            return null;
        }
        map = new HashMap<>();
        maxCnt = 0;
        dfs(root);
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxCnt) {
                list.add(entry.getKey());
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int val = root.val + dfs(root.left) + dfs(root.right);
        int cnt = map.getOrDefault(val, 0) + 1;
        if (cnt > maxCnt) {
            maxCnt = cnt;
        }
        map.put(val, cnt);
        return val;
    }
}
