## 1447.最简分数

b = x % y  
求最大公约数f(x,y)=f(y,b)  
https://leetcode-cn.com/problems/simplified-fractions/

## 553. 最优除法

肯定是从第二个数开始加括号这样算出来的结果最大  
https://leetcode-cn.com/problems/optimal-division/

## 564. 寻找最近的回文数

生成前一半-1到前一半+1的回文数,以及10的(len-1)次方-1,10的len次方+1  
https://leetcode-cn.com/problems/find-the-closest-palindrome/

## 258. 各位相加

```java
class Solution {
    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }
}
```

https://leetcode-cn.com/problems/add-digits/

## 504. 七进制数

辗转相除法  
https://leetcode-cn.com/problems/base-7/

## 2038. 如果相邻两个颜色均相同则删除当前颜色

找出中间的A和B的数量然后比较  
https://leetcode-cn.com/problems/remove-colored-pieces-if-both-neighbors-are-the-same-color/

## 2028. 找出缺失的观测数据

求出sumN,然后算出商和余数  
余数个数的分配商+1  
n-余数,分配商  
https://leetcode-cn.com/problems/find-missing-observations/

## 693. 交替位二进制数

右移  
亦或  
+1与  
https://leetcode-cn.com/problems/binary-number-with-alternating-bits/

## 728. 自除数

https://leetcode-cn.com/problems/self-dividing-numbers/

## 191. 位1的个数

2种方法

1. 不断和2的i次方做与运算,由地位到高位计算1的个数,结果不为0就+1
2. lowbit,不断和(n-1)做与运算,该运算可以将地位由1变为0

https://leetcode-cn.com/problems/number-of-1-bits/

## 204. 计数质数

从[2,根号n]判断求模  
https://leetcode-cn.com/problems/count-primes/

## 762. 二进制表示中质数个计算置位

https://leetcode-cn.com/problems/prime-number-of-set-bits-in-binary-representation/

## 780. 到达终点

反向运算  
https://leetcode-cn.com/problems/reaching-points/