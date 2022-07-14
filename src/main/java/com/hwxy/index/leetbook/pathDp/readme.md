# pathDp

路径dp问题  
[https://leetcode.cn/leetbook/read/path-problems-in-dynamic-programming](https://leetcode.cn/leetbook/read/path-problems-in-dynamic-programming)

## 1. Easy

## 2. Medium

### 931. 下降路径最小和

<details>
<summary>Tips</summary>

1. dp[i][j] = min(dp[i - 1][j], dp[i - 1][j - 1], dp[i - 1][j + 1]) + matrix[i][j]
2. 第一行开始到(i,j)位置的和的最小值,最后返回最后一行的最小值
3. 只是用前一行和当前行的数据,所以可以用压缩数组存储

</details>

[https://leetcode.cn/leetbook/read/path-problems-in-dynamic-programming/r85adr/](https://leetcode.cn/leetbook/read/path-problems-in-dynamic-programming/r85adr/)

### 1289. 下降路径最小和 II

<details>
<summary>Tips</summary>

1. dp[0][j] = min or nextMin + grid[i][j]
2. 到(i,j)的最小路径和,一行就足够了实际上用不到前一行的数据
3. 记录前一行的最小和次小值以及对应的列

</details>

[https://leetcode.cn/leetbook/read/path-problems-in-dynamic-programming/r8oh2h/](https://leetcode.cn/leetbook/read/path-problems-in-dynamic-programming/r8oh2h/)