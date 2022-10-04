<!-- TOC -->

* [Math](#math)
    * [1. Easy](#1-easy)
        * [1037. 有效的回旋镖](#1037-)
    * [2. Medium](#2-medium)
        * [462. 最少移动次数使数组元素相等 II](#462--ii)
        * [478. 在圆内随机生成点](#478-)
        * [592. 分数加减运算](#592-)
        * [593. 有效的正方形](#593-)

<!-- TOC -->

# Math

## 1. Easy

### 1037. 有效的回旋镖

<details>
<summary>Tips</summary>

1. 使用斜率判断3点共线
2. (y3−y1)(x2−x1)−(y2−y1)(x3−x1)=0

</details>

[https://leetcode.cn/problems/valid-boomerang/](https://leetcode.cn/problems/valid-boomerang/)

### 1619. 删除某些元素后的数组均值

<details>
<summary>Tips</summary>

1. 题目的意思是删除前`5%`和后`5%`
2. 所以排序后,用长度除以20得到start
3. 计算[start,长度-start)的sum即可

</details>

[https://leetcode.cn/problems/mean-of-array-after-removing-some-elements/](https://leetcode.cn/problems/mean-of-array-after-removing-some-elements/)

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

### 592. 分数加减运算

<details>
<summary>Tips</summary>

1. 分子*分母,最后化简
2. 循环里每次找到一个分数
3. 化简需用最大公约数化简

</details>

[https://leetcode.cn/problems/fraction-addition-and-subtraction/](https://leetcode.cn/problems/fraction-addition-and-subtraction/)

### 593. 有效的正方形

<details>
<summary>Tips</summary>

1. 2条对角线的中点相同
    1. 对角线中点=(x1+x2)/2,(y1+y2)/2
2. 2条对角线的长度相同
    1. (x1-x2)*(x1-x2) + (y1-y2)*(y1-y2) = (x3-x4)*(x3-x4) + (y3-y4)*(y3-y4)
3. 2条对角线垂直相交
    1. 向量的积: (x1-x2)*(x3-x4) + (y1-y2)*(y3-y4) = 0

</details>

[https://leetcode.cn/problems/valid-square/](https://leetcode.cn/problems/valid-square/)

## 3.Hard

### 面试题 17.19. 消失的两个数字

<details>
<summary>Tips</summary>

1. 求出1到n的和,然后和实际缺少数`nums`的和相减
2. 差值就是缺的2个数的平均值(一定是一个在平均值左一个在右)
3. 再计算1到mid的和与`nums`中所有`<=mid`相减,这就得到了缺的第一个数
4. 然后用差值与第一个数相减就是第二个数

</details>


[https://leetcode.cn/problems/missing-two-lcci/](https://leetcode.cn/problems/missing-two-lcci/)