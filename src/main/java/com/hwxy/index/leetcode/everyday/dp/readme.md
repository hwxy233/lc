# DP

## 2. Medium

### 467. 环绕字符串中唯一的子字符串

<details>
<summary>Tips</summary>

1. 子串问题优先考虑dp[i]以第i个字母结尾的dp,或者是滑动窗口
2. dp[i]为第i个字母结尾的最长子串长度
3. dp[cs[i]-'a'] = cs[i] - cs[i-1] == 1 ? Math.max(dp[cs[i] - 'a'], length) : 1
4. dp[cs[0]-'a'] = 1

</details>

[https://leetcode.cn/problems/unique-substrings-in-wraparound-string/](https://leetcode.cn/problems/unique-substrings-in-wraparound-string/)

### 926. 将字符串翻转到单调递增

<details>
<summary>Tips</summary>

1. 如果字符s0到i-1是单调的,则翻转/不翻转i的位置后也会保持单调
2. dp[i][0]和dp[i][1]表示让i位置字符是0或1的最小翻转次数
3. 0的话要求前面也得是0
4. dp[i][0] = dp[i-1][0] + s[i] == 1 ? 1 : 0
5. 1的话前面可以是0/1,所以取最小值
6. dp[i][1] = min(dp[i-1][0],dp[i-1][1]) + s[i] == 0 ? 1 : 0

</details>

[https://leetcode.cn/problems/flip-string-to-monotone-increasing/](https://leetcode.cn/problems/flip-string-to-monotone-increasing/)

### 剑指 Offer II 091. 粉刷房子

<details>
<summary>Tips</summary>

1. 第i个位置用3种颜色的最小cost,`int[][] dp = new int[costs.length][3];`
2. 分别计算各种颜色的最小值=前面2种的最小值+当前这种颜色的cost,
3. ```java
   dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i][0];
   dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + costs[i][1];
   dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + costs[i][2];
   ```
4. 最后比较最后位置3种的最小值即可

</details>

[https://leetcode.cn/problems/JEj789/](https://leetcode.cn/problems/JEj789/)

### 522. 最长特殊序列 II

<details>
<summary>Tips</summary>

1. 参考1143的找最长子串的做法
2. 目的就是判断每个子串是否是其他字符串的子串,是的话就不是答案

</details>

[https://leetcode.cn/problems/longest-uncommon-subsequence-ii/](https://leetcode.cn/problems/longest-uncommon-subsequence-ii/)

### 1143. 最长公共子序列

<details>
<summary>Tips</summary>

1. dp[i][j]代表text1的前i个字符中和text2的前j个字符中的最长公共子串
2. 追加一个空格后就有了初始值第一行第一列为1(因为有了相同的" ")
3. 如果当前字符相等则=前一个+1,否则取前面的最大值

</details>


[https://leetcode.cn/problems/longest-common-subsequence/](https://leetcode.cn/problems/longest-common-subsequence/)

### 873. 最长的斐波那契子序列的长度

<details>
<summary>Tips</summary>

1. dp[i][j]代表使用arr[i]为最后一个,arr[j]位倒数第二个的数量
2. dp[i][j] = max(dp[j][k] + 1, 3),下标 k < j < i, 且arr[k] < arr[j] < arr[i]

</details>


[https://leetcode.cn/problems/length-of-longest-fibonacci-subsequence/](https://leetcode.cn/problems/length-of-longest-fibonacci-subsequence/)

## 3. Hard

### 730. 统计不同回文子序列

<details>
<summary>Tips</summary>

1. dp[x][i][j]表示以字符x开头下标i到j的回文串的长度,根据i和j位置的字符是否相等有4中情况
    1. 如果i和j位置的字符是c
        1. 那么i+1,j-1位置的回文串在首尾都加上x还是回文串,并且会新增加x和xx2个回文串
    2. j是c,那么就等于i+1到j的回文串数量
    3. i是c,那么就等于i到j-1的回文串数量
    4. 都不是,那就i+1到j-1

</details>


[https://leetcode.cn/problems/count-different-palindromic-subsequences/submissions/](https://leetcode.cn/problems/count-different-palindromic-subsequences/submissions/)