package com.hwxy.code.leetcode.order.l1000.l944;

/**
 * 944. 删列造序
 * https://leetcode.cn/problems/delete-columns-to-make-sorted/
 * 
 * @author hwxy
 * @date 2022/05/12
 **/
public class Lc944 {
    /**
     * 竖着遍历即可
     * 
     * @param strs
     * @return
     */
    public int minDeletionSize(String[] strs) {
        if (strs == null || strs.length == 0) {
            return 0;
        }
        int height = strs.length;
        int length = strs[0].length();
        int ans = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 1; j < height; j++) {
                // 注意这里不要=
                if (strs[j].charAt(i) < strs[j - 1].charAt(i)) {
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }
}
