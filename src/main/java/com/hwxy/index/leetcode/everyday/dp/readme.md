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