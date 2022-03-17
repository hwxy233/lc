package com.hwxy.order.l600.l599;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 599. 两个列表的最小索引总和
 * https://leetcode-cn.com/problems/minimum-index-sum-of-two-lists/
 * 
 * @author hwxy
 * @date 2022/03/17
 **/
public class Lc599 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        if (list1 == null || list1.length == 0 || list2 == null || list2.length == 0) {
            return list1;
        }
        String[] minLenList;
        String[] maxLenList;
        if (list1.length >= list2.length) {
            minLenList = list2;
            maxLenList = list1;
        } else {
            minLenList = list1;
            maxLenList = list2;
        }
        Map<String, Integer> resIndexMap = new HashMap<>(minLenList.length);
        for (int i = 0; i < minLenList.length; i++) {
            resIndexMap.put(minLenList[i], i);
        }
        int sum = Integer.MAX_VALUE;
        Set<String> res = new HashSet<>();
        for (int i = 0; i < maxLenList.length; i++) {
            Integer minIndex = resIndexMap.get(maxLenList[i]);
            if (minIndex == null) {
                continue;
            }
            int s = minIndex + i;
            if (s > sum) {
                continue;
            }
            if (s < sum) {
                res.clear();
                sum = s;
            }
            res.add(maxLenList[i]);
        }
        return res.toArray(new String[0]);
    }
}
