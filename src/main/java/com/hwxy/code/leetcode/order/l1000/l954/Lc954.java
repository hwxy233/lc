package com.hwxy.code.leetcode.order.l1000.l954;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 954. 二倍数对数组
 * https://leetcode-cn.com/problems/array-of-doubled-pairs/
 * 
 * @author hwxy
 * @date 2022/04/01
 **/
public class Lc954 {
    public static void main(String[] args) {
        System.out.println(new Lc954().canReorderDoubled(new int[] {4, -2, 2, -4}));
    }

    /**
     * 我理解错了
     * 这题就是找到(2/arr.length)对的组合使得后一个是前一个的2倍
     * 
     * @param arr
     * @return
     */
    public boolean canReorderDoubled(int[] arr) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        // 统计出各数字的数量,待会凑对数做减法
        Map<Integer, Integer> valueCnt = new HashMap<>(arr.length);
        for (int i : arr) {
            valueCnt.put(i, valueCnt.getOrDefault(i, 0) + 1);
        }
        // 先看下0的数量是不是偶数
        if (valueCnt.getOrDefault(0, 0) % 2 != 0) {
            return false;
        }
        // 排序,从小的开始凑对数,注意要绝对值排序,因为是*2的关系,比如[4,-2,2,-4] => [-2,2,-4,4]才行
        List<Integer> arrList = valueCnt.keySet().stream()
                .sorted(Comparator.comparingInt(Math::abs)).collect(Collectors.toList());
        for (int i : arrList) {
            int aCnt = valueCnt.get(i);
            int bCnt = valueCnt.getOrDefault(i * 2, 0);
            // 大的数量一定要>=小的数量
            if (aCnt > bCnt) {
                return false;
            }
            // 更新数量,这里default个0防止大数*2没有更大的数
            valueCnt.put(i * 2, valueCnt.getOrDefault(i * 2, 0) - valueCnt.get(i));
        }
        return true;
    }
}
