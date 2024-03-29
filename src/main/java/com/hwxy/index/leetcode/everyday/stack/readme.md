<!-- TOC -->

* [Stack](#stack)
    * [1. Easy](#1-easy)
        * [1021. 删除最外层的括号](#1021-)
    * [2. Medium](#2-medium)
        * [735. 行星碰撞](#735-)
        * [636. 函数的独占时间](#636-)
        * [946. 验证栈序列](#946-)
        * [921. 使括号有效的最少添加](#921-)

<!-- TOC -->

# Stack

## 1. Easy

### 1021. 删除最外层的括号

<details>
<summary>Tips</summary>

1. 使用Stack
2. 先判断右括号pop
3. 然后Stack非空就append
4. 最后判断左括号push

</details>

[https://leetcode.cn/problems/remove-outermost-parentheses/](https://leetcode.cn/problems/remove-outermost-parentheses/)

## 2. Medium

### 735. 行星碰撞

<details>
<summary>Tips</summary>

1. 使用Stack
2. 保存向右方向的行星
3. 每次遇到向左的出栈比较大小

</details>

[https://leetcode.cn/problems/asteroid-collision/](https://leetcode.cn/problems/asteroid-collision/)

### 636. 函数的独占时间

<details>
<summary>Tips</summary>

1. 使用Stack
2. 存放上一个执行的函数
3. 遇到start和end分别讨论,注意直接给start加时间最简单

</details>

[https://leetcode.cn/problems/exclusive-time-of-functions/](https://leetcode.cn/problems/exclusive-time-of-functions/)

### 946. 验证栈序列

<details>
<summary>Tips</summary>

1. 使用Stack
2. 模拟这个pop的过程即可
3. 每次push完就比较栈顶和pop序列是否一样
4. 一样就不断pop
5. 如果最后栈为空则可以

</details>

[https://leetcode.cn/problems/validate-stack-sequences/](https://leetcode.cn/problems/validate-stack-sequences/)

### 921. 使括号有效的最少添加

<details>
<summary>Tips</summary>

1. 使用Stack
2. 必须左右匹配才行

</details>

[https://leetcode.cn/problems/minimum-add-to-make-parentheses-valid/](https://leetcode.cn/problems/minimum-add-to-make-parentheses-valid/)

### 856. 括号的分数

<details>
<summary>Tips</summary>

1. 避免上层没有数据的情况
2. 如果当前层是0则说明只要给前一层+1即可,否则要*2

</details>

[https://leetcode.cn/problems/score-of-parentheses/](https://leetcode.cn/problems/score-of-parentheses/)