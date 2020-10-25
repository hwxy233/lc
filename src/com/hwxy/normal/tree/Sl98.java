package com.hwxy.normal.tree;

import java.util.Objects;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 假设一个二叉搜索树具有如下特征：
 * <p>
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 * <p>
 * 输入:
 * sss  2
 * ss / \
 * s 1   3
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:
 * sss  5
 * sss / \
 * ss 1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Sl98 {
    /**
     * 假设一个二叉搜索树具有如下特征：
     * <p>
     * 节点的左子树只包含小于当前节点的数。
     * 节点的右子树只包含大于当前节点的数。
     * 所有左子树和右子树自身必须也是二叉搜索树。
     *
     * @param root 根
     * @return t:是bst
     */
    public boolean isValidBST(TreeNode root) {
        if (Objects.isNull(root)) {
            return true;
        }
        return isValidBST(root, null, null);
    }

    /**
     * 不光要比较当前节点,还要比较左右子树
     *
     * @param root 当前的根
     * @param min  最小值的节点,对于左子树这个值是之前的最小值,对于右子树是root
     * @param max  最大值的节点,对于左子树是root,对于柚子树是之前的max
     * @return
     */
    private boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (Objects.isNull(root)) {
            return true;
        }
        if (Objects.nonNull(min) && root.val <= min.val) {
            return false;
        }
        if (Objects.nonNull(max) && root.val >= max.val) {
            return false;
        }
        return isValidBST(root.left, min, root)
                && isValidBST(root.right, root, max);
    }
}
