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