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

### 450. 删除二叉搜索树中的节点

<details>
<summary>Tips</summary>

1. 找到左子树的右子树的最小节点作为右子树的根,root.left作为新的root
2. 返回root.left作为新的root

</details>

[https://leetcode.cn/problems/delete-node-in-a-bst/](https://leetcode.cn/problems/delete-node-in-a-bst/)

### 508. 出现次数最多的子树元素和

<details>
<summary>Tips</summary>

1. HashMap统计值和次数
2. 然后用个int存最大次数即可

</details>

[https://leetcode.cn/problems/most-frequent-subtree-sum/](https://leetcode.cn/problems/most-frequent-subtree-sum/)

### 513. 找树左下角的值

<details>
<summary>Tips</summary>

1. dfs:
    1. 记录一个层高和最高层高
    2. 一定是左边先遍历到,先遍历到的是答案
2. bfs:
    1. 每层i==0的就是最左

</details>

[https://leetcode.cn/problems/find-bottom-left-tree-value/](https://leetcode.cn/problems/find-bottom-left-tree-value/)

### 814. 二叉树剪枝

<details>
<summary>Tips</summary>

1. 后续遍历
2. 左右子树都不包含并且自己也不是1才算不包含

</details>

[https://leetcode.cn/problems/binary-tree-pruning/](https://leetcode.cn/problems/binary-tree-pruning/)

### 1161. 最大层内元素和

<details>
<summary>Tips</summary>

1. 层次遍历即可

</details>

[https://leetcode.cn/problems/maximum-level-sum-of-a-binary-tree/
](https://leetcode.cn/problems/maximum-level-sum-of-a-binary-tree/
)

### 623. 在二叉树中增加一行

<details>
<summary>Tips</summary>

1. 层次遍历即可

</details>

[https://leetcode.cn/problems/add-one-row-to-tree/
](https://leetcode.cn/problems/add-one-row-to-tree/
)

### 654. 最大二叉树

<details>
<summary>Tips</summary>

1. 根据题目规则先序遍历即可

</details>

[https://leetcode.cn/problems/maximum-binary-tree/
](https://leetcode.cn/problems/maximum-binary-tree/
)

### 655. 输出二叉树

<details>
<summary>Tips</summary>

1. 先求下树高然后按照题目规则模拟即可
2. 注意初始化`ArrayList(n)`时是空的需要`add`n次才行

</details>

[https://leetcode.cn/problems/print-binary-tree/
](https://leetcode.cn/problems/print-binary-tree/
)

### 1302. 层数最深叶子节点的和

<details>
<summary>Tips</summary>

1. 记录一个sum值,每层计算完直接赋值给sum即可

</details>

[https://leetcode.cn/problems/deepest-leaves-sum/
](https://leetcode.cn/problems/deepest-leaves-sum/
)

## 3. Hard

### 297. 二叉树的序列化与反序列化

<details>
<summary>Tips</summary>

1. 把null值编码进去,这样就可以唯一确定一课树了
2. 反序列化时,每次pop队首元素来代替游标
3. 只要是null了就说明这个子树到底了

</details>

[https://leetcode.cn/problems/serialize-and-deserialize-binary-tree/](https://leetcode.cn/problems/serialize-and-deserialize-binary-tree/)