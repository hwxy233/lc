<!-- TOC -->

* [Queue](#queue)
    * [1. Easy](#1-easy)
        * [933. 最近的请求次数](#933-)
    * [2. Medium](#2-medium)
        * [622. 设计循环队列](#622-)
        * [641. 设计循环双端队列](#641-)
        * [面试题 17.09. 第 k 个数](#-1709--k-)

<!-- TOC -->

# Queue

## 1. Easy

### 933. 最近的请求次数

<details>
<summary>Tips</summary>

1. t是递增的
2. 所以用队列维护一个在[t-3000,t]范围的滑动窗口即可

</details>

[https://leetcode-cn.com/problems/number-of-recent-calls/](https://leetcode-cn.com/problems/number-of-recent-calls/)

## 2. Medium

### 622. 设计循环队列

<details>
<summary>Tips</summary>

1. 用一个数组存储数据
2. 记录一个头index,一个尾index
3. 取值时记得求模

</details>

[https://leetcode.cn/problems/design-circular-queue/](https://leetcode.cn/problems/design-circular-queue/)

### 641. 设计循环双端队列

<details>
<summary>Tips</summary>

1. 有几个坑
2. head和tail定义为可以取到
3. head相当于是add为--,delete为++,初始化为0
4. tail相当于是add为++,delete为--,初始化为-1,当tail为-1并且取tail时要用head和size计算出tail
5. 所有操作要对maxSize求模

</details>

[https://leetcode.cn/problems/design-circular-deque/](https://leetcode.cn/problems/design-circular-deque/)

### 面试题 17.09. 第 k 个数

<details>
<summary>Tips</summary>

1. 优先级队列,每次选最小的进行乘3,5,7
2. 注意要用`long`

</details>

[https://leetcode.cn/problems/get-kth-magic-number-lcci/](https://leetcode.cn/problems/get-kth-magic-number-lcci/)