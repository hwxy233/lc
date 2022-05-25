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