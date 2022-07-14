# Tires(字典树)

## 2. Medium

### 648. 单词替换

<details>
<summary>Tips</summary>

1. 注意最短替换,如果有先end=true的就立刻返回进行替换

</details>

[https://leetcode.cn/problems/replace-words/](https://leetcode.cn/problems/replace-words/)

### 676. 实现一个魔法字典

<details>
<summary>Tips</summary>

1. 字典树+dfs
2. 一定要改一次字符才行

</details>

[https://leetcode.cn/problems/implement-magic-dictionary/](https://leetcode.cn/problems/implement-magic-dictionary/)

## 3. Hard

### 745. 前缀和后缀搜索

<details>
<summary>Tips</summary>

1. 使用2个字典树,一个正着存,一个倒着存
2. 并且分别存储index最后求交集
3. 求交集可以倒着查正着存的只要有就是最大的index

</details>

[https://leetcode.cn/problems/prefix-and-suffix-search/](745.前缀和后缀搜索https://leetcode.cn/problems/prefix-and-suffix-search/)