package com.hwxy.code.leetcode.order.l700.l687;

import com.hwxy.code.ds.TreeNode;

/**
 * 687. 最长同值路径
 *
 * <p>https://leetcode.cn/problems/longest-univalue-path/
 *
 * @author hwxy
 * @date 2022/09/02
 */
public class Lc687 {
    private int ans;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        ans = 0;
        dfs(root, -1001);
        return ans - 1;
    }

    /**
     * 求路径,我还以为求节点数呢
     *
     * <p>后序遍历,求左子树的相同节点数,求右子树相同节点数,那么当前节点的路径长就是左+右
     *
     * <p>但是因为是路径返回给父节点的只能是2个子树中较长的
     *
     * @param root
     * @param parentVal
     * @return
     */
    private int dfs(TreeNode root, int parentVal) {
        if (root == null) {
            return 0;
        }
        int leftSameCnt = dfs(root.left, root.val);
        int rightSameCnt = dfs(root.right, root.val);
        ans = Math.max(ans, leftSameCnt + rightSameCnt + 1);
        if (root.val == parentVal) {
            return Math.max(leftSameCnt, rightSameCnt) + 1;
        }
        return 0;
    }
}
