# LinkedList

大部分可以用双指针的各种方法,比如一个或多个烧饼节点

## 1. Easy

### 21. 合并两个有序链表

<details>
<summary>Tips</summary>

1. 一个烧饼节点
2. 注意最后可能有没合并完的

</details>

[https://leetcode-cn.com/problems/merge-two-sorted-lists/](https://leetcode-cn.com/problems/merge-two-sorted-lists/)

### 876. 链表的中间结点

<details>
<summary>Tips</summary>

1. 快慢指针,一个走一步,一个走2步

</details>

[https://leetcode.cn/problems/middle-of-the-linked-list/](https://leetcode.cn/problems/middle-of-the-linked-list/)

### 160. 相交链表

<details>
<summary>Tips</summary>

1. 一个走到尾就切换另一个的头
2. 直到相同

</details>

[https://leetcode.cn/problems/intersection-of-two-linked-lists/](https://leetcode.cn/problems/intersection-of-two-linked-lists/)

## 2. Medium

### 86. 分隔链表

<details>
<summary>Tips</summary>

1. 2个烧饼节点
2. 一个小的,一个大的

</details>

[https://leetcode.cn/problems/partition-list/](https://leetcode.cn/problems/partition-list/)

### 23. 合并K个升序链表

<details>
<summary>Tips</summary>

1. 使用一个优先级队列将k个节点的next放进队列中排序]
2. 每次poll最小的然后把next再放进去

</details>

[https://leetcode.cn/problems/merge-k-sorted-lists/](https://leetcode.cn/problems/merge-k-sorted-lists/)