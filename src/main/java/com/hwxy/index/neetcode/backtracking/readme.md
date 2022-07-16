# Backtracking

## 2. Medium

39. 组合总和

<details>
<summary>Tips</summary>

1. 每个数字可以用多次
2. 所以回溯时的下一个下标是i而不是i+1

</details>

[https://leetcode.cn/problems/combination-sum/](39.组合总和https://leetcode.cn/problems/combination-sum/)

### 79. 单词搜索

<details>
<summary>Tips</summary>

1. 在外层使用for来遍历坐标
2. 每个坐标再回溯并遍历上下左右
3. 直到当前坐标的字符等于word的最后一个字符结束

</details>

[https://leetcode.cn/problems/word-search/](https://leetcode.cn/problems/word-search/)

### 46. 全排列

<details>
<summary>Tips</summary>

1. 回溯,每次都从0开始,需要一个used来去重

</details>

[https://leetcode.cn/problems/permutations/](https://leetcode.cn/problems/permutations/)

### 78. 子集

<details>
<summary>Tips</summary>

1.回溯,放在最上面收集

</details>

[https://leetcode.cn/problems/subsets/](https://leetcode.cn/problems/subsets/)

### 90. 子集 II

<details>
<summary>Tips</summary>

1. 回溯,树层去重

```java
// 同一层去重,实际上可以直接return因为后面都是前面遍历过的,不需要continue
if(i>0&&nums[i]==nums[i-1]&&used[i-1]==0){
        return;
        }
```

</details>

[https://leetcode.cn/problems/subsets-ii/](https://leetcode.cn/problems/subsets-ii/)