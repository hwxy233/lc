# BinarySearch

## 2. Medium

### 34. 在排序数组中查找元素的第一个和最后一个位置

<details>
<summary>Tips</summary>

1. 蓝红二分查找
2. b站https://www.bilibili.com/video/BV1d54y1q7k7?spm_id_from=333.337.search-card.all.click

</details>

[https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/](https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/)

378. 有序矩阵中第 K 小的元素

<details>
<summary>Tips</summary>

1. 是对值的数量做蓝红二分,不是下标
2. 为什么值二分的结果一定在数组里?
3. 因为返回时的结果是数组中第k小的结果
4. 如果不在数组里,那么第k小的是谁呢?

</details>

[https://leetcode.cn/problems/kth-smallest-element-in-a-sorted-matrix/](https://leetcode.cn/problems/kth-smallest-element-in-a-sorted-matrix/)

### 436. 寻找右区间

<details>
<summary>Tips</summary>

1. 对每个右区间二分搜索,找出>=有区间的最小的做区间,可能没有做区间
2. 可以用二维数组排序代替HashMap和List的存储

</details>

[https://leetcode.cn/problems/find-right-interval/](https://leetcode.cn/problems/find-right-interval/)

## 3. Hard

### 668. 乘法表中第k小的数

<details>
<summary>Tips</summary>

1. 和378题一样

</details>

[https://leetcode.cn/problems/kth-smallest-number-in-multiplication-table/](https://leetcode.cn/problems/kth-smallest-number-in-multiplication-table/)