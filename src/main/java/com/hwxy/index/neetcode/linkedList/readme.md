# LinkedList

## 1. Easy

### 206. 反转链表

<details>
<summary>Tips</summary>

1. 维护一个pre节点

</details>

[https://leetcode-cn.com/problems/reverse-linked-list/](https://leetcode-cn.com/problems/reverse-linked-list/)

### 21. 合并两个有序链表

<details>
<summary>Tips</summary>

1. 只要维护一个烧饼节点和一个pre就很容易了

</details>

[https://leetcode-cn.com/problems/merge-two-sorted-lists/](https://leetcode-cn.com/problems/merge-two-sorted-lists/)

### 143. 重排链表

<details>
<summary>Tips</summary>

1. 用一个列表可以根据索引查找

</details>

[https://leetcode-cn.com/problems/reorder-list/](https://leetcode-cn.com/problems/reorder-list/)

### 141. 环形链表

<details>
<summary>Tips</summary>

1. 用快慢指针,一个走一步,一个每次走2步,只要相遇就是有环
2. 使用Set去重

</details>

[https://leetcode.cn/problems/linked-list-cycle/](https://leetcode.cn/problems/linked-list-cycle/)

## 2. Medium

19. 删除链表的倒数第 N 个结点

<details>
<summary>Tips</summary>

1. 使用双指针
2. 左右间隔n个距离同正向移动
3. 使用一个虚拟节点可以简化处理

</details>

[https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/](https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/)

## 3. Hard

23. 合并K个升序链表

<details>
<summary>Tips</summary>

1. 使用优先级队列更简单
2. 归并排序合并n个
3. 对于合并2个链表一定要使用烧饼节点会很简单
4. 参考143. 重排链表

</details>

[https://leetcode.cn/problems/merge-k-sorted-lists/](https://leetcode.cn/problems/merge-k-sorted-lists/)