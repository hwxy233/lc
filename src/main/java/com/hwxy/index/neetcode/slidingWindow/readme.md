# SlidingWindow

## 1. Easy

### 121. 买卖股票的最佳时机

<details>
<summary>Tips</summary>

1. 右边不断移动,左边只要大于右边就进行右移

</details>

[https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/)

## 2. Medium

### 3. 无重复字符的最长子串

<details>
<summary>Tips</summary>

1. 维护一个滑动窗口
2. 以及一个Set记录字符出现
3. 每次右移到新字符时如果Set已经用过则要不断右移左窗口直到Set消失

</details>

[https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/](https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/)