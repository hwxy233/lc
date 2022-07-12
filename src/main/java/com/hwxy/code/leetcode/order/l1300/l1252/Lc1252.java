package com.hwxy.code.leetcode.order.l1300.l1252;

import java.util.HashMap;
import java.util.Map;

/**
 * 1252. 奇数值单元格的数目
 * https://leetcode.cn/problems/cells-with-odd-values-in-a-matrix/
 * 
 * @author hwxy
 * @date 2022/07/12
 **/
public class Lc1252 {
    public int oddCells(int m, int n, int[][] indices) {
        if (m < 1 || n < 1 || indices == null) {
            return 0;
        }
        Map<Integer, Integer> lineChangeCount = new HashMap<>();
        Map<Integer, Integer> columnChangeCount = new HashMap<>();
        for (int[] indic : indices) {
            updateCnt(lineChangeCount, indic[0]);
            updateCnt(columnChangeCount, indic[1]);
        }
        // 影响的行数 * 总列数 + 影响的列数*总行数 - (重复计算的点 + 2次变换抵消变化的点=影响行*影响列*2)
        return lineChangeCount.size() * n + columnChangeCount.size() * m
                - 2 * lineChangeCount.size() * columnChangeCount.size();
    }

    private void updateCnt(Map<Integer, Integer> changeCountMap, int lineColumn) {
        Integer lineChanged = changeCountMap.get(lineColumn);
        if (lineChanged == null) {
            changeCountMap.put(lineColumn, 1);
        } else {
            lineChanged += 1;
            if (lineChanged % 2 == 0) {
                changeCountMap.remove(lineColumn);
            } else {
                changeCountMap.put(lineColumn, 1);
            }
        }
    }
}
