<!-- TOC -->

* [TwoPointers](#twopointers)
    * [1.Easy](#1easy)
        * [5234. 移除字母异位词后的结果数组](#5234-)
        * [1089. 复写零](#1089-)
    * [2. Medium](#2-medium)
        * [面试题 01.05. 一次编辑](#-0105-)
        * [面试题 17.11. 单词距离](#-1711-)

<!-- TOC -->

# TwoPointers

## 1.Easy

### 5234. 移除字母异位词后的结果数组

<details>
<summary>Tips</summary>

1. 用Map判断异位词
2. 维护2个指针left,right从同一方向遍历
3. 每次不是异位词的时候left=right
4. 每次循环right++

</details>

[https://leetcode.cn/problems/find-resultant-array-after-removing-anagrams/](https://leetcode.cn/problems/find-resultant-array-after-removing-anagrams/)

### 1089. 复写零

<details>
<summary>Tips</summary>

1. 找到0就就开始右移动即可

</details>

[https://leetcode.cn/problems/duplicate-zeros/](https://leetcode.cn/problems/duplicate-zeros/)

## 2. Medium

### 面试题 01.05. 一次编辑

<details>
<summary>Tips</summary>

1. 分情况讨论2者的长度差
2. 然后双指针移动

</details>

[https://leetcode.cn/problems/one-away-lcci/](https://leetcode.cn/problems/one-away-lcci/)

### 面试题 17.11. 单词距离

<details>
<summary>Tips</summary>

1. 同方向的双指针
2. 每次和左边最后的下标比较即可

</details>


[https://leetcode.cn/problems/find-closest-lcci/](https://leetcode.cn/problems/find-closest-lcci/)

### 777. 在LR字符串中交换相邻字符

<details>
<summary>Tips</summary>

1. 双指针(同时遍历2个字符串),L和R在state和end的相对位置是固定的
2. L可以左移所以是>=
3. R是右移所以是<=

</details>

[https://leetcode.cn/problems/swap-adjacent-in-lr-string/](https://leetcode.cn/problems/swap-adjacent-in-lr-string/)