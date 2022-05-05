## 1. Easy

### 217. 存在重复元素

使用一个Set即可  
https://leetcode-cn.com/problems/contains-duplicate/

### 242. 有效的字母异位词

使用2个HashMap  
https://leetcode-cn.com/problems/valid-anagram/

### 1. 两数之和

一个HashMap,value存储下标,遍历2遍  
https://leetcode-cn.com/problems/two-sum/

## 2. Medium

### 49. 字母异位词分组

HashMap的key先进行排序  
https://leetcode-cn.com/problems/group-anagrams/

### 347. 前 K 个高频元素

1. HashMap + value排序
2. HashMap + PriorityQueue当做堆  
   https://leetcode-cn.com/problems/top-k-frequent-elements/

### 238. 除自身以外数组的乘积

要求不能使用除法,
时间复杂度O(n)  
可以用2个数组:

1. 一个存储i所有左侧的乘积
2. 一个存储i所有右侧的乘积
3. 那么每个i的结果就是i对应位置的左边和右边的乘积

https://leetcode-cn.com/problems/product-of-array-except-self/

### 128. 最长连续序列

用一个Set去记录所有的不重复的num  
然后对每个num不断+1看看Set里有没有  
https://leetcode-cn.com/problems/longest-consecutive-sequence/