# 回溯相关的题目目录

## 77. 组合

给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。  
[https://leetcode-cn.com/problems/combinations/][lc 77]

### for循环条件剪枝

[lc 77]: https://leetcode-cn.com/problems/combinations/

## 216. 组合总和 III

找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
[https://leetcode-cn.com/problems/combination-sum-iii/][LC 216]

[LC 216]: https://leetcode-cn.com/problems/combination-sum-iii/

### for循环条件剪枝

## 17. 电话号码的字母组合

给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
[https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/][lc 17]

[lc 17]: https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/

## 39. 组合总和

[https://leetcode-cn.com/problems/combination-sum/][lc 39]

[lc 39]: https://leetcode-cn.com/problems/combination-sum/

## 40. 组合总和 II

### 这道题有去重的方法

[https://leetcode-cn.com/problems/combination-sum-ii/](https://leetcode-cn.com/problems/combination-sum-ii/)

## 131. 分割回文串

[https://leetcode-cn.com/problems/palindrome-partitioning/](https://leetcode-cn.com/problems/palindrome-partitioning/)

## 93. 复原ip地址

[https://leetcode-cn.com/problems/restore-ip-addresses/][lc 93]

[lc 93]: https://leetcode-cn.com/problems/restore-ip-addresses/

## 78. 子集

[https://leetcode-cn.com/problems/subsets/][lc 78]

### 关于for循环从0开始还是从index开始,0开始不去重;index开始去重

[lc 78]: https://leetcode-cn.com/problems/subsets/

## 90. 子集 II

### 这道题有去重的方法

[https://leetcode-cn.com/problems/subsets-ii/](https://leetcode-cn.com/problems/subsets-ii/)

## 491. 递增子序列

[https://leetcode-cn.com/problems/increasing-subsequences/](https://leetcode-cn.com/problems/increasing-subsequences/)

### 这道题有去重的方法(与之前的方法不同)

## 46. 全排列

[https://leetcode-cn.com/problems/permutations/](https://leetcode-cn.com/problems/permutations/)

## 47. 全排列 II

### 这道题有去重的方法

[https://leetcode-cn.com/problems/permutations-ii/](https://leetcode-cn.com/problems/permutations-ii/)

## 332. 重新安排行程(skip)

[https://leetcode-cn.com/problems/reconstruct-itinerary/](https://leetcode-cn.com/problems/reconstruct-itinerary/)

## 51. N 皇后

[https://leetcode-cn.com/problems/n-queens/](https://leetcode-cn.com/problems/n-queens/)

## 37. 解数独

[https://leetcode-cn.com/problems/sudoku-solver/](https://leetcode-cn.com/problems/sudoku-solver/)

### 二层递归

## 688. 骑士在棋盘上的概率

### 记忆化搜索

### 要用double存总次数

https://leetcode-cn.com/problems/knight-probability-in-chessboard/

## 1601. 最多可达成的换楼请求数目

dfs  
https://leetcode-cn.com/problems/maximum-number-of-achievable-transfer-requests/submissions/

## 2044. 统计按位或能得到最大值的子集数目

https://leetcode-cn.com/problems/count-number-of-maximum-bitwise-or-subsets/

## 386. 字典序排数

深度优先搜索  
从[1,9]每个都dfs一遍  
在dfs里对参数index进行[0,9]的index*=10 + i的dfs  
https://leetcode-cn.com/problems/lexicographical-numbers/

## 417. 太平洋大西洋水流问题

dfs从pacific的西和北找到所有能到pacific的  
同理从atlantic的东和南找到所有能到atlantic的  
如果某个下标都能到则就是结果  
https://leetcode-cn.com/problems/pacific-atlantic-water-flow/