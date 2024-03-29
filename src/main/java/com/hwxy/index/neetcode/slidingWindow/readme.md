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

### 424. 替换后的最长重复字符

<details>
<summary>Tips</summary>

1. 每次右移时记录该字符出现的次数和最多出现字符放入次数进行比较
2. 如果发现此时窗口长度-最大字符长度>k的话说明需要滑动窗口,减少最左字符的次数
3. 最终的结果就是窗口的长度
4. 窗口增大和最多字符的次数一定是同时增长的,如果窗口长度不变(平移)那么最多字符的次数一定不变

</details>

[https://leetcode-cn.com/problems/longest-repeating-character-replacement/](https://leetcode-cn.com/problems/longest-repeating-character-replacement/)

## 3. Hard

### 76. 最小覆盖子串

<details>
<summary>Tips</summary>

1. 不断向右移动记录字符直到满足次数
2. 这是更新结果并开始不断左移
3. 直到不满足次数停止左移开始右移重复1,2

</details>

[https://leetcode-cn.com/problems/minimum-window-substring/](https://leetcode-cn.com/problems/minimum-window-substring/)