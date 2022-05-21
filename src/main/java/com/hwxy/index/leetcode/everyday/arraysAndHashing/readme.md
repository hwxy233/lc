# ArraysAndHashing

## 1. Easy

### 944. 删列造序

<details>
<summary>Tips</summary>

1. 竖着遍历即可

</details>

[https://leetcode.cn/problems/delete-columns-to-make-sorted/](https://leetcode.cn/problems/delete-columns-to-make-sorted/)

### 961. 在长度 2N 的数组中找出重复 N 次的元素

<details>
<summary>Tips</summary>

1. 用Set记录出现的只要重复了就是答案

</details>

[https://leetcode.cn/problems/n-repeated-element-in-size-2n-array/](https://leetcode.cn/problems/n-repeated-element-in-size-2n-array/)

### 953. 验证外星语词典

<details>
<summary>Tips</summary>

1. 记得每次比较后根据长度再进行一次额外判断

</details>

[https://leetcode.cn/problems/verifying-an-alien-dictionary/](https://leetcode.cn/problems/verifying-an-alien-dictionary/)

## 2.Medium

### 442. 数组中重复的数据

<details>
<summary>Tips</summary>

1. 原地哈希
2. 题目说了nums[i]的范围是[1,n]最多出现2次
3. 所以原地交换,只要nums[i]只出现1次则必定在nums[i]-1的位置,
4. nums[i] != nums[nums[i] - 1]不断进行交换,最后只要nums[i]-1!=i的都是结果

</details>

[https://leetcode-cn.com/problems/find-all-duplicates-in-an-array/](https://leetcode-cn.com/problems/find-all-duplicates-in-an-array/)

### 6064. 不含特殊楼层的最大连续楼层数

<details>
<summary>Tips</summary>

1. 直接遍历specials即可
2. 每次计算差值时记得-1
3. 遍历完再计算一遍

</details>


[https://leetcode.cn/contest/weekly-contest-293/problems/maximum-consecutive-floors-without-special-floors/](https://leetcode.cn/contest/weekly-contest-293/problems/maximum-consecutive-floors-without-special-floors/)

### 面试题 01.05. 一次编辑

<details>
<summary>Tips</summary>

1. 长度最多相差一个
2. 不相同就最多多进一个 || 补一个

</details>

[https://leetcode.cn/problems/one-away-lcci/](https://leetcode.cn/problems/one-away-lcci/)