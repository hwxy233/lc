## 1. Easy

### 217. 存在重复元素

<details>
<summary>Tips</summary>

1. 使用一个Set即可

</details>

[https://leetcode-cn.com/problems/contains-duplicate/](https://leetcode-cn.com/problems/contains-duplicate/)

### 242. 有效的字母异位词

<details>
<summary>Tips</summary>

1. 使用2个HashMap

</details>

[https://leetcode-cn.com/problems/valid-anagram/](https://leetcode-cn.com/problems/valid-anagram/)

### 1. 两数之和

<details>
<summary>Tips</summary>

1. 一个HashMap,value存储下标,遍历2遍

</details>

[https://leetcode-cn.com/problems/two-sum/](https://leetcode-cn.com/problems/two-sum/)

## 2. Medium

### 49. 字母异位词分组

<details>
<summary>Tips</summary>

1. HashMap的key先进行排序

</details>

[https://leetcode-cn.com/problems/group-anagrams/](https://leetcode-cn.com/problems/group-anagrams/)

### 347. 前 K 个高频元素

<details>
<summary>Tips</summary>

1. HashMap + value排序
2. HashMap + PriorityQueue当做堆

</details>

[https://leetcode-cn.com/problems/top-k-frequent-elements/](https://leetcode-cn.com/problems/top-k-frequent-elements/)

### 238. 除自身以外数组的乘积

<details>
<summary>Tips</summary>
要求不能使用除法,时间复杂度O(n)<br>  
可以用2个数组:<br>

1. 一个存储i所有左侧的乘积
2. 一个存储i所有右侧的乘积
3. 那么每个i的结果就是i对应位置的左边和右边的乘积

</details>

[https://leetcode-cn.com/problems/product-of-array-except-self/](https://leetcode-cn.com/problems/product-of-array-except-self/)

### 128. 最长连续序列

<details>
<summary>Tips</summary>

1. 用一个Set去记录所有的不重复的num
2. 然后对每个num不断+1看看Set里有没有

</details>

[https://leetcode-cn.com/problems/longest-consecutive-sequence/](https://leetcode-cn.com/problems/longest-consecutive-sequence/)