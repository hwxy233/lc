# unionFind 并查集

## 3. Hard

### 952. 按公因数计算最大组件大小

<details>
<summary>Tips</summary>

1. 先找到参数数组的最大值
2. 使用并查集,找出每个数的每个因数,将本身和因数以及本身和因数的商构建并查集
3. 构建完成后,遍历每个数字进行找根并增加该根的集合大小,最后返回最大的大小
4. [b站教程](https://www.bilibili.com/video/av31199020?vd_source=ae37b8a39773bf433c9dd1810387008b)

</details>

[https://leetcode.cn/problems/largest-component-size-by-common-factor/](https://leetcode.cn/problems/largest-component-size-by-common-factor/)