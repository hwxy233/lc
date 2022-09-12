# BinarySearch

## 1. Easy

### 1608. 特殊数组的特征值

<details>
<summary>Tips</summary>

1. 蓝红二分查找
2. blue:nums[mid]<x

</details>

[https://leetcode.cn/problems/special-array-with-x-elements-greater-than-or-equal-x/](https://leetcode.cn/problems/special-array-with-x-elements-greater-than-or-equal-x/)

## 2. Medium

### 34. 在排序数组中查找元素的第一个和最后一个位置

<details>
<summary>Tips</summary>

1. 蓝红二分查找
2. b站
3. [https://www.bilibili.com/video/BV1d54y1q7k7?spm_id_from=333.337.search-card.all.click](https://www.bilibili.com/video/BV1d54y1q7k7?spm_id_from=333.337.search-card.all.click)

</details>

[https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/](https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/)

### 378. 有序矩阵中第 K 小的元素

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

### 875. 爱吃香蕉的珂珂

<details>
<summary>Tips</summary>

1. 对值进行二分查找
2. 下界是1(一小时最少吃一根)-1,上界是堆的最大值+1
3. isBlue为吃香蕉速度为mid时所花时间>h,所以最终返回r

</details>

[https://leetcode.cn/problems/koko-eating-bananas/](https://leetcode.cn/problems/koko-eating-bananas/)

### 2226. 每个小孩最多能分到多少糖果

<details>
<summary>Tips</summary>

1. 对值进行二分查找
2. 下界为0(1-1),上界为平均值+1
3. isBlue:按照mid分的堆数>=k,也就是最大的堆数,返回l

</details>

[https://leetcode.cn/problems/maximum-candies-allocated-to-k-children/](https://leetcode.cn/problems/maximum-candies-allocated-to-k-children/)

### 497. 非重叠矩形中的随机点

<details>
<summary>Tips</summary>

1. 因为是等概率所以直接在rects随机不等的因为各矩形的面积不同
2. 所以要按照面积随机,然后二分找到矩形,再在矩形里随机

</details>


[https://leetcode.cn/problems/random-point-in-non-overlapping-rectangles/](https://leetcode.cn/problems/random-point-in-non-overlapping-rectangles/)

## 3. Hard

### 668. 乘法表中第k小的数

<details>
<summary>Tips</summary>

1. 和378题一样

</details>

[https://leetcode.cn/problems/kth-smallest-number-in-multiplication-table/](https://leetcode.cn/problems/kth-smallest-number-in-multiplication-table/)

### 719. 找出第 K 小的数对距离

<details>
<summary>Tips</summary>

1. 对值二分然后统计对数,l应该是0-1,r应该是最大差值+1
2. isBlue为小于等于差值m的对数<k,返回r

</details>

[https://leetcode.cn/problems/find-k-th-smallest-pair-distance/](https://leetcode.cn/problems/find-k-th-smallest-pair-distance/)