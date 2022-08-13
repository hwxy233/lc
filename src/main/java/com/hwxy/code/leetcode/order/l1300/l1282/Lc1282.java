package com.hwxy.code.leetcode.order.l1300.l1282;

import java.util.*;

/**
 * 1282. 用户分组
 * https://leetcode.cn/problems/group-the-people-given-the-group-size-they-belong-to/
 * 
 * @author hwxy
 * @date 2022/08/12
 **/
public class Lc1282 {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        if (groupSizes == null || groupSizes.length == 0) {
            return Collections.emptyList();
        }
        List<List<Integer>> ans = new LinkedList<>();
        Map<Integer, List<Integer>> groups = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            int size = groupSizes[i];
            if (size == 1) {
                ans.add(List.of(i));
                continue;
            }
            List<Integer> group = groups.computeIfAbsent(size, ArrayList::new);
            group.add(i);
            if (group.size() == size) {
                ans.add(group);
                groups.remove(size);
            }
        }
        return ans;
    }
}
