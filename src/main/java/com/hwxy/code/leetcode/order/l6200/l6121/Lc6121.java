package com.hwxy.code.leetcode.order.l6200.l6121;

import java.util.*;

/**
 * 6121. 裁剪数字后查询第 K 小的数字
 * https://leetcode.cn/contest/weekly-contest-302/problems/query-kth-smallest-trimmed-number/
 * 
 * @author hwxy
 * @date 2022/07/17
 **/
public class Lc6121 {
    private Map<Integer, List<Pair>> trimiKiNums;

    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        if (nums == null || queries == null) {
            return null;
        }
        int[] ans = new int[queries.length];
        trimiKiNums = new HashMap<>();
        for (int i = 0; i < queries.length; i++) {
            ans[i] = getIndex(nums, queries[i][0], queries[i][1]);
        }

        return ans;
    }

    private int getIndex(String[] nums, int ki, int trimi) {
        List<Pair> sortedNums = trimiKiNums.get(trimi);
        if (sortedNums == null) {
            sortedNums = new ArrayList<>(nums.length);
            for (int i = 0; i < nums.length; i++) {
                Pair pair = new Pair();
                pair.index = i;
                pair.val = nums[i].substring(nums[i].length() - trimi);
                sortedNums.add(pair);
            }
            sortedNums.sort(new Comparator<Pair>() {
                @Override
                public int compare(Pair o1, Pair o2) {
                    if (Objects.equals(o1.val, o2.val)) {
                        return Integer.compare(o1.index, o2.index);
                    }
                    return o1.val.compareTo(o2.val);
                }
            });
            trimiKiNums.put(trimi, sortedNums);
        }
        return sortedNums.get(ki - 1).index;
    }



    class Pair {
        String val;
        int index;
    }
}
