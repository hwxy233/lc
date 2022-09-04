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

### 929. 独特的电子邮件地址

<details>
<summary>Tips</summary>

1. isDomain直接append然后continue

</details>

[https://leetcode.cn/problems/unique-email-addresses/](https://leetcode.cn/problems/unique-email-addresses/)

### 1200. 最小绝对差

<details>
<summary>Tips</summary>

1. 排序然后相邻求差的绝对值看下是否最小
2. 是的话就add
3. 否则清空重新add

</details>

[https://leetcode.cn/problems/minimum-absolute-difference/](https://leetcode.cn/problems/minimum-absolute-difference/)

### 1260. 二维网格迁移

<details>
<summary>Tips</summary>

1. 二维数组转一维数组,然后推算一个映射关系

</details>

[https://leetcode.cn/problems/shift-2d-grid/](https://leetcode.cn/problems/shift-2d-grid/)

### 1331. 数组序号转换

<details>
<summary>Tips</summary>

1. 复制一个新数组用于排序
2. 使用一个Map记录排序后的值和对应的序号(map.size()+1)

</details>

[https://leetcode.cn/problems/rank-transform-of-an-array/](https://leetcode.cn/problems/rank-transform-of-an-array/)

### 1282. 用户分组

<details>
<summary>Tips</summary>

1. 使用Map<Integer, List<Integer>>存储即可

</details>

[https://leetcode.cn/problems/group-the-people-given-the-group-size-they-belong-to/
](https://leetcode.cn/problems/group-the-people-given-the-group-size-they-belong-to/
)

### 1413. 逐步求和得到正数的最小值

<details>
<summary>Tips</summary>

1. 前缀和

</details>

[https://leetcode.cn/problems/minimum-value-to-get-positive-step-by-step-sum/
](https://leetcode.cn/problems/minimum-value-to-get-positive-step-by-step-sum/
)

### 1450. 在既定时间做作业的学生人数

<details>
<summary>Tips</summary>

1. 遍历一遍比较统计结果即可

</details>

[https://leetcode.cn/problems/number-of-students-doing-homework-at-a-given-time/](https://leetcode.cn/problems/number-of-students-doing-homework-at-a-given-time/)

### 1460. 通过翻转子数组使两个数组相等

<details>
<summary>Tips</summary>

1. 比较次数一样即可

</details>

[https://leetcode.cn/problems/make-two-arrays-equal-by-reversing-sub-arrays/
](https://leetcode.cn/problems/make-two-arrays-equal-by-reversing-sub-arrays/
)

### 1464. 数组中两元素的最大乘积

<details>
<summary>Tips</summary>

1. 维护2个值就行

</details>

[https://leetcode.cn/problems/maximum-product-of-two-elements-in-an-array/
](https://leetcode.cn/problems/maximum-product-of-two-elements-in-an-array/
)

### 1656. 设计有序流

<details>
<summary>Tips</summary>

1. 用个数组统计即可

</details>

[https://leetcode.cn/problems/design-an-ordered-stream/
](https://leetcode.cn/problems/design-an-ordered-stream/
)

### 1470. 重新排列数组

<details>
<summary>Tips</summary>

1. 新建一个数组
2. 然后每次填充2个元素,一个是i,另一个是i+n:

```java
    ans [i*2]=nums [i];
        ans [i*2+1]=nums [i+n];
   ```

</details>

[https://leetcode.cn/problems/shuffle-the-array/](https://leetcode.cn/problems/shuffle-the-array/)

### 1475. 商品折扣后的最终价格

<details>
<summary>Tips</summary>

1. 双重循环遍历即可

</details>

[https://leetcode.cn/problems/final-prices-with-a-special-discount-in-a-shop/
](https://leetcode.cn/problems/final-prices-with-a-special-discount-in-a-shop/
)

### 1582. 二进制矩阵中的特殊位置

<details>
<summary>Tips</summary>

1. 求每行和每列的和
2. 然后依次判断每个arr[i][j]如果那个位置的行和-1 == 0 && 列和-1 == 0

</details>

[https://leetcode.cn/problems/special-positions-in-a-binary-matrix/
](https://leetcode.cn/problems/special-positions-in-a-binary-matrix/)

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

### 890. 查找和替换模式

<details>
<summary>Tips</summary>

1. 用2个HashMap构造双映射

</details>

[https://leetcode.cn/problems/find-and-replace-pattern/](https://leetcode.cn/problems/find-and-replace-pattern/)

### 532. 数组中的 k-diff 数对

<details>
<summary>Tips</summary>

1. 用HashMap记录值和数量即可

</details>

[https://leetcode.cn/problems/k-diff-pairs-in-an-array/](https://leetcode.cn/problems/k-diff-pairs-in-an-array/)

324. 摆动排序 II

<details>
<summary>Tips</summary>

1. 拷贝一个新数组后排序
2. left指向中间如果长度是奇数则指向中间后一个位置,right从长度-1开始
3. 先放left--,然后放right--
4. 最后如果是奇数,将最后的位置赋值成排序后的0元素

</details>

[https://leetcode.cn/problems/wiggle-sort-ii/](https://leetcode.cn/problems/wiggle-sort-ii/)

### 31. 下一个排列

<details>
<summary>Tips</summary>

1. 先从右向左找到i-1 < i的i-1
2. 再从右向左找到第一个 > i-1的索引
3. 交换那个索引和i-1
4. 反转i以及后面的元素
5. 其实画个二维坐标就懂了,比如230241 => 230412

</details>

[https://leetcode.cn/problems/next-permutation/](https://leetcode.cn/problems/next-permutation/)

### 556. 下一个更大元素 III

<details>
<summary>Tips</summary>

1. 同31

</details>

[https://leetcode.cn/problems/next-greater-element-iii/](https://leetcode.cn/problems/next-greater-element-iii/)

### 658. 找到 K 个最接近的元素

<details>
<summary>Tips</summary>

1. 先按照规则排序
2. 然后取前k个
3. 再排序

</details>

[https://leetcode.cn/problems/find-k-closest-elements/](https://leetcode.cn/problems/find-k-closest-elements/)