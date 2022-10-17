<!-- TOC -->

* [滑动窗口](#)
    * [2. Medium](#2-medium)
        * [713. 乘积小于 K 的子数组](#713--k-)
        * [438. 找到字符串中所有字母异位词](#438-)
        * [剑指 Offer II 041. 滑动窗口的平均值](#-offer-ii-041-)
    * [3. Hard](#3-hard)
        * [76. 最小覆盖子串](#76-)

<!-- TOC -->

# 滑动窗口

模板:[https://leetcode.cn/problems/find-all-anagrams-in-a-string/solution/hua-dong-chuang-kou-tong-yong-si-xiang-jie-jue-zi-/](https://leetcode.cn/problems/find-all-anagrams-in-a-string/solution/hua-dong-chuang-kou-tong-yong-si-xiang-jie-jue-zi-/)

## 2. Medium

### 713. 乘积小于 K 的子数组

<details>
<summary>Tips</summary>

1. 双指针法维护一个滑动窗口
2. 计算连续子数组的个数的公式为right-left+1
3. 因为每个新子数组就是最初的元素nums[left]不断增加后面的元素nums[left+1]直到nums[right]相当于所有元素的个数

</details>

[https://leetcode-cn.com/problems/subarray-product-less-than-k/](https://leetcode-cn.com/problems/subarray-product-less-than-k/)

### 438. 找到字符串中所有字母异位词

<details>
<summary>Tips</summary>

1. 套用模板即可

</details>

[https://leetcode.cn/problems/find-all-anagrams-in-a-string/](https://leetcode.cn/problems/find-all-anagrams-in-a-string/)

### 剑指 Offer II 041. 滑动窗口的平均值

<details>
<summary>Tips</summary>

1. 使用一个队列即可

</details>

[https://leetcode.cn/problems/qIsx9U/](https://leetcode.cn/problems/qIsx9U/)

### 904. 水果成篮

<details>
<summary>Tips</summary>

1. 使用map作为窗口记录出现次数
2. 只要出现第三种数字就滑动直到2种
3. 只要cnt=0了就移出

</details>

[https://leetcode.cn/problems/fruit-into-baskets/](https://leetcode.cn/problems/fruit-into-baskets/)

## 3. Hard

### 76. 最小覆盖子串

<details>
<summary>Tips</summary>

1. 套用模板即可
2. https://leetcode.cn/problems/find-all-anagrams-in-a-string/solution/hua-dong-chuang-kou-tong-yong-si-xiang-jie-jue-zi-/

</details>

[https://leetcode.cn/problems/minimum-window-substring/](https://leetcode.cn/problems/minimum-window-substring/)