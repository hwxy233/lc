<!-- TOC -->

* [String](#string)
    * [1. Easy](#1-easy)
        * [1108. IP 地址无效化](#1108-ip-)
        * [1374. 生成每种字符都是奇数个的字符串](#1374-)
        * [1408. 数组中的字符串匹配](#1408-)
        * [面试题 01.02. 判定是否互为字符重排](#-0102-)
        * [面试题 01.09. 字符串轮转](#-0109-)
        * [1624. 两个相同字符之间的最长子字符串](#1624-)
        * [1694. 重新格式化电话号码](#1694-)
        * [1784. 检查二进制字符串字段](#1784-)

<!-- TOC -->

# String

## 1. Easy

### 1108. IP 地址无效化

<details>
<summary>Tips</summary>

1. 简单模拟,遍历替换即可

</details>

[https://leetcode.cn/problems/defanging-an-ip-address/](https://leetcode.cn/problems/defanging-an-ip-address/)

### 1374. 生成每种字符都是奇数个的字符串

<details>
<summary>Tips</summary>

1. 分情况讨论n即可

</details>

[https://leetcode.cn/problems/generate-a-string-with-characters-that-have-odd-counts/](https://leetcode.cn/problems/generate-a-string-with-characters-that-have-odd-counts/)

### 1408. 数组中的字符串匹配

<details>
<summary>Tips</summary>

1. 简单模拟,遍历替换即可

</details>


[https://leetcode.cn/problems/string-matching-in-an-array/](https://leetcode.cn/problems/string-matching-in-an-array/)

### 面试题 01.02. 判定是否互为字符重排

<details>
<summary>Tips</summary>

1. 转`char[]`然后排序
2. 比较相等

</details>

[https://leetcode.cn/problems/check-permutation-lcci/](https://leetcode.cn/problems/check-permutation-lcci/)

### 面试题 01.09. 字符串轮转

<details>
<summary>Tips</summary>

1. s1与自身相加
2. 判断是否包含s2

</details>

[https://leetcode.cn/problems/string-rotation-lcci/](https://leetcode.cn/problems/string-rotation-lcci/)

### 1624. 两个相同字符之间的最长子字符串

<details>
<summary>Tips</summary>

1. 分别统计每个字符的下标即可
2. 然后计算出每个的最大和最小差值的最大值

</details>

[https://leetcode.cn/problems/largest-substring-between-two-equal-characters/](两个相同字符之间的最长子字符串https://leetcode.cn/problems/largest-substring-between-two-equal-characters/)

### 1694. 重新格式化电话号码

<details>
<summary>Tips</summary>

1. 直接模拟即可

</details>

[https://leetcode.cn/problems/reformat-phone-number/](https://leetcode.cn/problems/reformat-phone-number/)

### 1784. 检查二进制字符串字段

<details>
<summary>Tips</summary>

1. 遍历,求出连续1的段数

</details>

[https://leetcode.cn/problems/check-if-binary-string-has-at-most-one-segment-of-ones/](https://leetcode.cn/problems/check-if-binary-string-has-at-most-one-segment-of-ones/)