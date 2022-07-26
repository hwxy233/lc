# LinkedList

## 2. Medium

### 剑指 Offer II 029. 排序的循环链表

<details>
<summary>Tips</summary>

1. 除了空||1个外,就2种情况
2. 一种是正常插,一种是插在最大后最小前
3. 只遍历一次如果没有插就说明全部相等,随便插即可

</details>

[https://leetcode.cn/problems/4ueAj6/](https://leetcode.cn/problems/4ueAj6/)

## 3. Hard

### 1206. 设计跳表

<details>
<summary>Tips</summary>

1. 最基本思路,最底层的链表有所有的值,没增加一层,减少一半的值
2. 先向右找,不断找right.val < num的也就是找到小于目标值的最大值
3. 然后比较right.val和目标值
4. 然后找down
5. https://www.bilibili.com/video/BV1kT4y1F7Nr?spm_id_from=333.337.search-card.all.click&vd_source=ae37b8a39773bf433c9dd1810387008b
6. https://zxi.mytechroad.com/blog/desgin/leetcode-1206-design-skiplist/

</details>

[https://leetcode.cn/problems/design-skiplist/](https://leetcode.cn/problems/design-skiplist/)
