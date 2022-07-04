# Tree

## 1. Easy

### 226. 翻转二叉树

<details>
<summary>Tips</summary>

1. 先换左右就是先序遍历
2. 后换就是后序遍历

</details>

[https://leetcode-cn.com/problems/invert-binary-tree/](https://leetcode-cn.com/problems/invert-binary-tree/)

### 104. 二叉树的最大深度

<details>
<summary>Tips</summary>

1. 可以用参数变量,这样就是先计数
2. 也可以不用参数变量这样是叶子节点返回计数

</details>

[https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/](https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/)

### 100. 相同的树

<details>
<summary>Tips</summary>

1. 比较自己和子树

</details>

[https://leetcode.cn/problems/same-tree/](https://leetcode.cn/problems/same-tree/)

### 572. 另一棵树的子树

<details>
<summary>Tips</summary>

1. 子树不是子结构,子树要求相等,所以要么本身是subRoot要么左或右是subRoot
2. 比较相等参考100题

</details>

[https://leetcode.cn/problems/subtree-of-another-tree/](https://leetcode.cn/problems/subtree-of-another-tree/)

### 235. 二叉搜索树的最近公共祖先

<details>
<summary>Tips</summary>

1. 利用l < root < r的性质
2. 根>p和q,说明在左子树中
3. 根<p和q,说明在右子树
4. 说明一边一个或者是当前是p和q之一
5. 建议看下236

</details>

[https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/](https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/)

## 2. Medium

### 230. 二叉搜索树中第K小的元素

<details>
<summary>Tips</summary>

1. 中序遍历计数即可

</details>

[https://leetcode.cn/problems/kth-smallest-element-in-a-bst/](https://leetcode.cn/problems/kth-smallest-element-in-a-bst/)

### 102. 层次遍历

<details>
<summary>Tips</summary>

1. 用queue

</details>

[https://leetcode-cn.com/problems/binary-tree-level-order-traversal/](https://leetcode-cn.com/problems/binary-tree-level-order-traversal/)

### 98. 验证二叉搜索树

<details>
<summary>Tips</summary>

1. 中序遍历,记录上个根节点的值即可
2. 当前节点一定 > 上个节点

</details>

[https://leetcode-cn.com/problems/validate-binary-search-tree/](https://leetcode-cn.com/problems/validate-binary-search-tree/)

### 105. 从前序与中序遍历序列构造二叉树

<details>
<summary>Tips</summary>

1. 用前序的节点去中序进行切分左右
2. 给前序计数++,作为当前节点
3. 可以用Map存下中序的index加快遍历
4. 可以看下106

</details>

[https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/](https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/)

## 3. Hard

### 124. 二叉树中的最大路径和

<details>
<summary>Tips</summary>

1. 后续遍历3选2(root+l或者root+r)

</details>


[https://leetcode.cn/problems/binary-tree-maximum-path-sum/](https://leetcode.cn/problems/binary-tree-maximum-path-sum/)

### 297. 二叉树的序列化与反序列化

<details>
<summary>Tips</summary>

1. 前序遍历
2. 将NULL和和分隔符,编码进字符串即可

</details>

[https://leetcode.cn/problems/serialize-and-deserialize-binary-tree/](https://leetcode.cn/problems/serialize-and-deserialize-binary-tree/)