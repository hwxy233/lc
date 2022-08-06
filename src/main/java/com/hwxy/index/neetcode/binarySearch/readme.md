# BinarySearch

## 1.Easy

### 33. 搜索旋转排序数组

<details>
<summary>Tips</summary>

1. 直接二分即可
2. 如果找到的mid满足nums[0] <= nums[mid]
    1. 说明[0,mid]是递增区间
        1. 只要判断target是否在区间里即可
            1. 在的话就缩小r,否则增加l
    2. 否则说明[mid,length-1]是递增区间
        1. 判断target是否在这段递增区间里
            1. 在的话增加l,否则缩小r

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