# Bfs

## 1. Easy

### 433. 最小基因变化

<details>
<summary>Tips</summary>

1. 每次把替换的8*4种可能进行遍历,只要最后能找到就是答案
2. 这样可以保证找到的一定是最短的

</details>

[https://leetcode-cn.com/problems/minimum-genetic-mutation/](https://leetcode-cn.com/problems/minimum-genetic-mutation/)

## 3. Hard

### 675. 为高尔夫比赛砍树

<details>
<summary>Tips</summary>

1. 题目的意思是最小的到最大的走,最短路径肯定要考虑bfs
2. 第一个位置是(0,0)求最短路径所以bfs而不是dfs
3. 纵轴是x,横轴是y

</details>

[https://leetcode.cn/problems/cut-off-trees-for-golf-event/](https://leetcode.cn/problems/cut-off-trees-for-golf-event/)