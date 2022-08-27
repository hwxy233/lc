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