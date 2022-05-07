# BinarySearch

## 1.Easy

### 33. 搜索旋转排序数组

<details>
<summary>Tips</summary>

1. 找到翻转点(并且可以进行比较),前和后分别升序有序
2. 后一个区间进行二分查找

</details>

[https://leetcode-cn.com/problems/search-in-rotated-sorted-array/](https://leetcode-cn.com/problems/search-in-rotated-sorted-array/)

### 153. 寻找旋转排序数组中的最小值

<details>
<summary>Tips</summary>

1. 如果nums[0] < nums[length-1]说明整体有序返回nums[0]
2. 否则是2部分分别升序,需要找到前一半的最后一个位置
3. 找到nums[i] > nums[i+1] && nums[i] > nums[i-1],答案就是nums[i+1]
4. 二分时nums[mid]不断和nums[0]进行比较看是否在正确的区间里来移动left或是right

</details>

[https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/](https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/)