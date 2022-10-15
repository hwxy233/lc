<!-- TOC -->

* [Greedy](#greedy)
    * [1.Easy](#1easy)
        * [942. 增减字符串匹配](#942-)
        * [1403. 非递增顺序的最小子序列](#1403-)
        * [646. 最长数对链](#646-)
    * [2.Medium](#2medium)
        * [670. 最大交换](#670-)
    * [3. Hard](#3-hard)
        * [871. 最低加油次数](#871-)

<!-- TOC -->

# Greedy

## 1.Easy

### 942. 增减字符串匹配

<details>
<summary>Tips</summary>

1. 贪心🤔
2. 每次都选最大/最小数
3. 只要是I就赋值成min++,D就是max--
4. 再根据最后一位是I还是D给结果的最后一个元素赋值

</details>

[https://leetcode.cn/problems/di-string-match/](https://leetcode.cn/problems/di-string-match/)

### 1403. 非递增顺序的最小子序列

<details>
<summary>Tips</summary>

1. 排序后贪心
2. 每次都选最大数

</details>

[https://leetcode.cn/problems/minimum-subsequence-in-non-increasing-order/
](https://leetcode.cn/problems/minimum-subsequence-in-non-increasing-order/
)

### 646. 最长数对链

<details>
<summary>Tips</summary>

1. 按照pair[1]进行排序
2. 然后每次找大于pair[0] > max然后将pair[1]赋值给max

</details>

[https://leetcode.cn/problems/maximum-length-of-pair-chain/](https://leetcode.cn/problems/maximum-length-of-pair-chain/)

## 2.Medium

### 670. 最大交换

<details>
<summary>Tips</summary>

1. 贪心
2. 每个数字不应该<后面的数字,否则与后面最大的交换

</details>

[https://leetcode.cn/problems/maximum-swap/](https://leetcode.cn/problems/maximum-swap/)

### 769. 最多能完成排序的块

<details>
<summary>Tips</summary>

1. 贪心
2. 每次找最大值,只有当最大值为当前下标时说明前面的可以是一组

</details>

[https://leetcode.cn/problems/max-chunks-to-make-sorted/](https://leetcode.cn/problems/max-chunks-to-make-sorted/)

## 3. Hard

### 871. 最低加油次数

<details>
<summary>Tips</summary>

1. 使用一个优先级队列,油量大到小排序
2. 每次用当前的油行驶到最远,然后将路过的加油站的油放到队列中
3. 当油没有的时候就从队列取出路过的最多的油加油
4. 如果没油了且没有加油站就返回-1说明到不了

</details>

[https://leetcode.cn/problems/minimum-number-of-refueling-stops/](https://leetcode.cn/problems/minimum-number-of-refueling-stops/)