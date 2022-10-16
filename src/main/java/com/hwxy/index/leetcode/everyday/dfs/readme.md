<!-- TOC -->

* [DFS](#dfs)
    * [2. Medium](#2-medium)
        * [241. 为运算表达式设计优先级](#241-)

<!-- TOC -->

# DFS

## 2. Medium

### 241. 为运算表达式设计优先级

<details>
<summary>Tips</summary>

1. 将每个符号分割的左右区间分别计算
2. 在将2边的结果用当前的运算符进行计算得到结果

</details>

[https://leetcode.cn/problems/different-ways-to-add-parentheses/](https://leetcode.cn/problems/different-ways-to-add-parentheses/)

### 886. 可能的二分法

<details>
<summary>Tips</summary>

1.

染色法模板(https://www.bilibili.com/video/BV1DW411Z7G6)

2. 建图
3. 染色dfs, 未染色为0, 染红色为1, 染蓝色为-1
4. 对i染色,并递归的对i的邻居染色,如果有染色失败的说明false
    1. 给自己染色color
        1. 如果邻居和自己颜色一样就不对了
        2. 染相反的颜色-color

</details>

[https://leetcode.cn/problems/possible-bipartition/](https://leetcode.cn/problems/possible-bipartition/)