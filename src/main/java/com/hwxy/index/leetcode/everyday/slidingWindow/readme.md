# 滑动窗口

## 2. Medium

### 713. 乘积小于 K 的子数组

<details>
<summary>提示</summary>
1. 双指针法维护一个滑动窗口<br>
2. 计算连续子数组的个数的公式为right-left+1<br>  
3. 因为每个新子数组就是最初的元素nums[left]不断增加后面的元素nums[left+1]直到nums[right]相当于所有元素的个数<br>  
</details>

[https://leetcode-cn.com/problems/subarray-product-less-than-k/](https://leetcode-cn.com/problems/subarray-product-less-than-k/)