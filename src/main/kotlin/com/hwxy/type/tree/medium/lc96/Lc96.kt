package com.hwxy.type.tree.medium.lc96

class Lc96 {
    fun numTrees(n: Int): Int {
        if (n <= 0) {
            return 0
        }
        // 从1~n遍历出bst
        return doCalculateBst(1, n)
    }

    private fun doCalculateBst(minNodeVal: Int, maxNodeVal: Int): Int {
        // 这里从0开始加,不能是1
        var totalSize = 0
        if (minNodeVal > maxNodeVal) {
            // 说明是null了,只有一种可能
            return 1
        }
        for (cur in minNodeVal..maxNodeVal) {
            // 左子树的数量
            val leftTreeSize = doCalculateBst(minNodeVal, cur - 1)
            // 右子树的数量
            val rightTreeSize = doCalculateBst(cur + 1, maxNodeVal)
            // 总数量 = 左 * 右
            totalSize += leftTreeSize * rightTreeSize
        }
        return totalSize
    }
}

