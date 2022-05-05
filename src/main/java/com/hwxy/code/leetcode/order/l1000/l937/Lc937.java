package com.hwxy.code.leetcode.order.l1000.l937;

import java.util.Arrays;

/**
 * 937. 重新排列日志文件
 * https://leetcode-cn.com/problems/reorder-data-in-log-files/
 * 
 * @author hwxy
 * @date 2022/05/03
 **/
public class Lc937 {
    public String[] reorderLogFiles(String[] logs) {
        if (logs == null || logs.length == 0) {
            return logs;
        }
        // 所有 字母日志 都排在 数字日志 之前。
        // 字母日志 在内容不同时，忽略标识符后，按内容字母顺序排序；在内容相同时，按标识符排序。
        // 数字日志 应该保留原来的相对顺序。
        SortEntry[] sortEntries = new SortEntry[logs.length];
        for (int i = 0; i < logs.length; i++) {
            sortEntries[i] = new SortEntry(i, logs[i]);
        }
        Arrays.sort(sortEntries, (o1, o2) -> {
            // 分成标识符和剩余部分
            String[] splits1 = o1.getLog().split(" ", 2);
            boolean isDigit1 = Character.isDigit(splits1[1].charAt(0));
            String[] splits2 = o2.getLog().split(" ", 2);
            boolean isDigit2 = Character.isDigit(splits2[1].charAt(0));
            // 数字按照相对顺序
            if (isDigit1 && isDigit2) {
                return Integer.compare(o1.getIndex(), o2.getIndex());
            }
            if (isDigit1) {
                // 2不是数字,所以1排在后面
                return 1;
            } else if (isDigit2) {
                // 1不是数字,所以1排在前面
                return -1;
            } else {
                // 都是字母,先比较内容
                int sc = splits1[1].compareTo(splits2[1]);
                if (sc != 0) {
                    return sc;
                }
                return splits1[0].compareTo(splits2[0]);
            }
        });
        String[] res = new String[sortEntries.length];
        for (int i = 0; i < sortEntries.length; i++) {
            res[i] = sortEntries[i].log;
        }
        return res;
    }

    /**
     * 存储日志内容和下标
     */
    static class SortEntry {
        private final int index;
        private final String log;

        public SortEntry(int index, String log) {
            this.index = index;
            this.log = log;
        }

        public int getIndex() {
            return index;
        }

        public String getLog() {
            return log;
        }
    }
}
