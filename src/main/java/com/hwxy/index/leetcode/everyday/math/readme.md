# Math

## 1. Easy

### 1037. 有效的回旋镖

<details>
<summary>Tips</summary>

1. 使用斜率判断3点共线
2. (y3−y1)(x2−x1)−(y2−y1)(x3−x1)=0

</details>

[https://leetcode.cn/problems/valid-boomerang/](https://leetcode.cn/problems/valid-boomerang/)

## 2. Medium

### 462. 最少移动次数使数组元素相等 II

<details>
<summary>Tips</summary>

1. 在数轴上,只有所有数到中心点的距离才能最短
2. 所以排序后直接求和中心点的差的和

</details>

[https://leetcode.cn/problems/minimum-moves-to-equal-array-elements-ii/](https://leetcode.cn/problems/minimum-moves-to-equal-array-elements-ii/)

### 478. 在圆内随机生成点

<details>
<summary>Tips</summary>

1. 在正方形上选点如果不在圆内就继续选
2. `random.nextDouble() * (2 * radius) - radius;`生成一个[-R,R]的x和y

</details>

[https://leetcode.cn/problems/generate-random-point-in-a-circle/]()