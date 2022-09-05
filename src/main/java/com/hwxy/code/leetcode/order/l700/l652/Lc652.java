package com.hwxy.code.leetcode.order.l700.l652;

import com.hwxy.code.ds.TreeNode;

import java.util.*;

/**
 * 652. 寻找重复的子树
 *
 * <p>https://leetcode.cn/problems/find-duplicate-subtrees/
 *
 * @author hwxy
 * @date 2022/09/05
 */
public class Lc652 {
    private Set<TreeNode> repeat;
    private Map<String, TreeNode> seen;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        repeat = new HashSet<>();
        seen = new HashMap<>();
        dfs(root);
        return new ArrayList<>(repeat);
    }

    /**
     * 后序遍历
     *
     * <p>序列化这棵树使用 s=val(leftVal)(rightVal)的方式
     *
     * <p>然后用1个map记录出现过的
     *
     * @param root
     * @return
     */
    private String dfs(TreeNode root) {
        if (root == null) {
            return "";
        }
        String s = root.val + "(" + dfs(root.left) + ")(" + dfs(root.right) + ")";
        if (seen.containsKey(s)) {
            repeat.add(seen.get(s));
        } else {
            seen.put(s, root);
        }
        return s;
    }
}
