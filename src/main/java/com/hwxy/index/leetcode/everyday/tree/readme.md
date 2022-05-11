# Tree

## 2. Medium

### 449. 序列化和反序列化二叉搜索树

<details>
<summary>Tips</summary>

1. 先序遍历
2. 然后不需要额外编码null
3. 反序列化时left是当前的根,从left+1到right找第一个 > 根的就是右子树
4. 前面的区间就是左子树

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