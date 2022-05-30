# Tree

## 1. Easy

### 965. 单值二叉树

<details>
<summary>Tips</summary>

1. 先序遍历
2. 先将根和左右子树比较,然后dfs左和右

</details>

[https://leetcode.cn/problems/univalued-binary-tree/](https://leetcode.cn/problems/univalued-binary-tree/)

### 1022. 从根到叶的二进制数之和

<details>
<summary>Tips</summary>

1. 先序可以直接用参数记录也可以回溯

</details>

[https://leetcode.cn/problems/sum-of-root-to-leaf-binary-numbers/](https://leetcode.cn/problems/sum-of-root-to-leaf-binary-numbers/)

## 2. Medium

### 449. 序列化和反序列化二叉搜索树

<details>
<summary>Tips</summary>

1. 可以先做297题
2. 先序遍历
4. 然后不需要额外编码null
5. 反序列化时left是当前的根,从left+1到right找第一个 > 根的就是右子树
6. 前面的区间就是左子树

</details>

[https://leetcode.cn/problems/serialize-and-deserialize-bst/](https://leetcode.cn/problems/serialize-and-deserialize-bst/)

## 3. Hard

### 297. 二叉树的序列化与反序列化

<details>
<summary>Tips</summary>

1. 把null值编码进去,这样就可以唯一确定一课树了
2. 反序列化时,每次pop队首元素来代替游标
3. 只要是null了就说明这个子树到底了

</details>

[https://leetcode.cn/problems/serialize-and-deserialize-binary-tree/](https://leetcode.cn/problems/serialize-and-deserialize-binary-tree/)