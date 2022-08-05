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