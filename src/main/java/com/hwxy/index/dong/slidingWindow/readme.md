# SlidingWindow

## 2. Medium

### 567. 字符串的排列

<details>
<summary>Tips</summary>

1. 相当于是一个定长窗口, `right - left + 1 >= s1cs.length`
2. `valid == need.size()`,这时说明找到了返回`true`

</details>

[https://leetcode.cn/problems/permutation-in-string/](https://leetcode.cn/problems/permutation-in-string/)

### 438. 找到字符串中所有字母异位词

<details>
<summary>Tips</summary>

1. 相当于是一个定长窗口, `right - left + 1 >= pcs.length`
2. `valid == need.size()`,这时说明找到了`add(left)`

</details>

[https://leetcode.cn/problems/find-all-anagrams-in-a-string/](https://leetcode.cn/problems/find-all-anagrams-in-a-string/)

### 3. 无重复字符的最长子串

<details>
<summary>Tips</summary>

1. 没有`need`和`valid`
2. `window.get(offerC) > 1`,进行缩小窗口
3. `ans = Math.max(ans, right - left + 1);`更新答案

</details>

[https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/](https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/)

## 3. Hard

### 76. 最小覆盖子串

<details>
<summary>Tips</summary>

1. 先找到一个满足条件的最长窗口
2. 然后缩小,条件是valid == need.size()

</details>

[https://leetcode.cn/problems/minimum-window-substring/](https://leetcode.cn/problems/minimum-window-substring/)