# 树相关的题目目录

## 144. 二叉树的前序遍历

[https://leetcode-cn.com/problems/binary-tree-preorder-traversal/](https://leetcode-cn.com/problems/binary-tree-preorder-traversal/)

## 145. 二叉树的后序遍历

[https://leetcode-cn.com/problems/binary-tree-postorder-traversal/](https://leetcode-cn.com/problems/binary-tree-postorder-traversal/)

### 非递归方式用前序的非递归交换入栈的顺序,最后再反转数组

## 94. 二叉树的中序遍历

[https://leetcode-cn.com/problems/binary-tree-inorder-traversal/](https://leetcode-cn.com/problems/binary-tree-inorder-traversal/)

## 102. 二叉树的层序遍历

[https://leetcode-cn.com/problems/binary-tree-level-order-traversal/](https://leetcode-cn.com/problems/binary-tree-level-order-traversal/)

## 101. 对称二叉树

相当于后序,同时遍历  
https://leetcode-cn.com/problems/symmetric-tree/

## 104. 二叉树的最大深度

后序,左,右,最大+1  
https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/

## 110. 平衡二叉树

高度:后序 / 深度:前序 / 根的深度==高度   
后序,左,右,01  
https://leetcode-cn.com/problems/balanced-binary-tree/

## 111. 二叉树的最小深度

后序,和求最大的不同(要到叶子节点),要注意左右子树各空的情况  
https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/

## 112. 路径总和

前序,回溯
https://leetcode-cn.com/problems/path-sum/

## 226. 翻转二叉树

后序  
https://leetcode-cn.com/problems/invert-binary-tree/

## 257. 二叉树的所有路径

前序,回溯    
https://leetcode-cn.com/problems/binary-tree-paths/

## 98. 验证二叉搜索树

https://leetcode-cn.com/problems/validate-binary-search-tree/

## 105. 从前序与中序遍历序列构造二叉树

https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

## 106. 从中序与后序遍历序列构造二叉树

https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/

## 113. 路径总和 II

https://leetcode-cn.com/problems/path-sum-ii/

## 235. 二叉搜索树的最近公共祖先

https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

## 236. 二叉树的最近公共祖先

https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/

## 450. 删除二叉搜索树中的节点

https://leetcode-cn.com/problems/delete-node-in-a-bst/

## 501. 二叉搜索树中的众数

https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/

## 530. 二叉搜索树的最小绝对差

https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/

## 617. 合并二叉树

https://leetcode-cn.com/problems/merge-two-binary-trees/

## 700. 二叉搜索树中的搜索

https://leetcode-cn.com/problems/search-in-a-binary-search-tree/

## 701. 二叉搜索树中的插入操作

https://leetcode-cn.com/problems/insert-into-a-binary-search-tree/

# =================================以下不是书中的题==================================

## 107. 二叉树的层序遍历 II

[https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/](https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/)

## 199. 二叉树的右视图

[https://leetcode-cn.com/problems/binary-tree-right-side-view/](https://leetcode-cn.com/problems/binary-tree-right-side-view/)

## 637. 二叉树的层平均值

[https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/](https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/)

## 429. N 叉树的层序遍历

[https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/](https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/)

## 515. 在每个树行中找最大值

[https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/](https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/)

## 116. 填充每个节点的下一个右侧节点指针

[https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/](https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/)

## 2049. 统计最高分的节点数目

dfs,计算分数将删除节点后的三部分想乘机    
https://leetcode-cn.com/problems/count-nodes-with-the-highest-score/

## 590. N 叉树的后序遍历

和二叉树的没有什么区别  
https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/

## 606. 根据二叉树创建字符串

深度优先搜索  
如果当前节点只有右孩子，那我们在递归时，  
需要先加上一层空的括号 ‘()’ 表示左孩子为空，  
再对右孩子进行递归，并在结果外加上一层括号。

https://leetcode-cn.com/problems/construct-string-from-binary-tree/

## 653. 两数之和 IV - 输入 BST

2次dfs  
https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst/

## 440. 字典序的第K小数字

字典树  
https://leetcode-cn.com/problems/k-th-smallest-in-lexicographical-order/