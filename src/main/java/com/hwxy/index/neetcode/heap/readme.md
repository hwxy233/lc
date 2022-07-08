# Heap

## 3.Hard

### 295. 数据流的中位数

<details>
<summary>Tips</summary>

1. 使用2个pq,做成对顶堆
2. 一个用小顶堆存较大一般的数据
3. 一个用大顶堆存较小一半的数据
4. 保证小顶堆的长度>=大顶堆的长度
5. 每次进堆要先进另一个然后poll回需要的那个防止乱序

</details>

[https://leetcode.cn/problems/find-median-from-data-stream/submissions/](https://leetcode.cn/problems/find-median-from-data-stream/submissions/)