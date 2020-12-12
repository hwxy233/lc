package com.hwxy.type.tree.medium.lc95

import com.hwxy.type.tree.TreeNode

class Lc95 {

    fun generateTrees(n: Int): List<TreeNode?> {
        if (n <= 0) {
            return emptyList()
        }
        // 返回所有可能的TreeNode的root list
        return doGenerateTrees(1, n)
    }

    /**
     * 不断生成子树
     */
    private fun doGenerateTrees(minTreeNodeVal: Int, maxTreeNodeVal: Int): List<TreeNode?> {
        // 每次对当前的节点新建一个list,来接收他为根的所有树
        val result = mutableListOf<TreeNode?>()
        // bst的条件是 左 <= 根 < 右
        if (minTreeNodeVal > maxTreeNodeVal) {
            result.add(null)
            return result
        }
        // 从头遍历,并且使用后续遍历的方式才行。因为这样往回拼接root时才是从叶子向根构建的过程
        for (cur in minTreeNodeVal..maxTreeNodeVal) {
            // 获取所有左子树
            val leftTreeNodeList = doGenerateTrees(minTreeNodeVal, cur - 1)
            // 获取所有右子树
            val rightTreeNodeList = doGenerateTrees(cur + 1, maxTreeNodeVal)
            // 拼到root上
            buildTree(cur, result, leftTreeNodeList, rightTreeNodeList)
        }
        return result;
    }

    /**
     * 将所有的左子树和右子树的组合拼到新的root上
     */
    private fun buildTree(cur: Int, result: MutableList<TreeNode?>, leftTreeNodeList: List<TreeNode?>, rightTreeNodeList: List<TreeNode?>) {
        for (left in leftTreeNodeList) {
            for (right in rightTreeNodeList) {
                val root = TreeNode(cur);
                root.left = left
                root.right = right
                result.add(root)
            }
        }
    }
}