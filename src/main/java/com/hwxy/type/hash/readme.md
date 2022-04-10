# 哈希表的题目目录

## 349. 两个数组的交集

[https://leetcode-cn.com/problems/intersection-of-two-arrays/][349]

## 1. 两数之和

是否存在剩余value的index,不能取重复自己

[https://leetcode-cn.com/problems/two-sum/][1]

## 242. 有效的字母异位词找

记录出现次数,26个字母
[https://leetcode-cn.com/problems/valid-anagram/][242]

## 454. 四数相加 II

[https://leetcode-cn.com/problems/4sum-ii/][454]

## 15. 三数之和

双指针
[https://leetcode-cn.com/problems/3sum/][15]

## 18. 四数之和

双指针  
n数之和就是n-1层循环  
不能这样做,不如target=-18,num[0]=-16,num[1]=-2,num[3]=0,num[4]=0  
注意 > i+1  
[https://leetcode-cn.com/problems/4sum/][18]

## 1001. 网格照明

二维坐标,可以用x - y表示正对角线,x + y表示反对角线  
https://leetcode-cn.com/problems/grid-illumination/

## 2006. 差的绝对值为 K 的数对数目

前到后的话可以之遍历一次  
https://leetcode-cn.com/problems/count-number-of-pairs-with-absolute-difference-k/

## 1189. “气球” 的最大数量

可以尝试用数组  
https://leetcode-cn.com/problems/maximum-number-of-balloons/

## 720. 词典中最长的单词

排序然后用set记录有没有前缀,必须从第一个字母开始有才行

https://leetcode-cn.com/problems/longest-word-in-dictionary/

## 954. 二倍数对数组

我理解错了  
这题就是找到(2/arr.length)对的组合使得后一个是前一个的2倍  
排序,从小的开始凑对数,注意要绝对值排序,因为是*2的关系,比如[4,-2,2,-4] => [-2,2,-4,4]才行  
更新数量,这里default个0防止大数*2没有更大的数

https://leetcode-cn.com/problems/array-of-doubled-pairs/

## 804. 唯一摩尔斯密码词

直接用个map记录映射  
然后找个set去重  
可以map替换为数组  
https://leetcode-cn.com/problems/unique-morse-code-words