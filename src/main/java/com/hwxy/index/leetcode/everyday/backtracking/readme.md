<!-- TOC -->

* [BackTracing](#backtracing)
    * [1. Easy](#1-easy)
        * [812. 最大三角形面积](#812-)
    * [2. Medium](#2-medium)
        * [464. 我能赢吗](#464-)

<!-- TOC -->

# BackTracing

## 1. Easy

### 812. 最大三角形面积

<details>
<summary>Tips</summary>

1. 三角形公式 S=(1/2)* | ((x2 - x1) * (y3 - y1) - (x3 - x1) * (y2 - y1)) |
2. 回溯找够3个点就算面积然后比较

</details>

[https://leetcode.cn/problems/largest-triangle-area/](https://leetcode.cn/problems/largest-triangle-area/)

## 2. Medium

### 464. 我能赢吗

<details>
<summary>Tips</summary>

1. https://www.bilibili.com/video/BV1ox411j74S?spm_id_from=333.337.search-card.all.click
2. 用一个int值(32位)可以记录下这最长的20个数,Arrays.toString(state)这样会超时

</details>

[https://leetcode.cn/problems/can-i-win/](https://leetcode.cn/problems/can-i-win/)

### 698. 划分为k个相等的子集

<details>
<summary>Tips</summary>

1. 注意到排序
2. 提前计算出可能分配的组数和平均值作为每组的和
3. 使用一个curSum记录当前的和
4. 使用一个curCnt记录达到sun时的数量,每次回溯时只要这个值等于了cnt就说明可以找到

</details>

[https://leetcode.cn/problems/partition-to-k-equal-sum-subsets/](https://leetcode.cn/problems/partition-to-k-equal-sum-subsets/)