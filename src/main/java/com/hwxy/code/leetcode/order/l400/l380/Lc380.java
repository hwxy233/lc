package com.hwxy.code.leetcode.order.l400.l380;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * 380. O(1) 时间插入、删除和获取随机元素
 * https://leetcode-cn.com/problems/insert-delete-getrandom-o1/
 * 
 * @author hwxy
 * @date 2022/04/13
 **/
public class Lc380 {}


/**
 * 非常的离谱使用int统计求模无法通过要使用random
 */
class RandomizedSet {
    private Set<Integer> set;
    private Random random;

    public RandomizedSet() {
        set = new HashSet<>();
        random = new Random();
    }

    public boolean insert(int val) {
        return set.add(val);
    }

    public boolean remove(int val) {
        return set.remove(val);
    }

    public int getRandom() {
        return set.stream().skip(random.nextInt(set.size())).findAny().get();
    }
}
