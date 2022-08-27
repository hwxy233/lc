package com.hwxy.code.leetcode.order.l1500.l1450;

/**
 * 1450. 在既定时间做作业的学生人数
 * https://leetcode.cn/problems/number-of-students-doing-homework-at-a-given-time/
 *
 * @author hwxy
 * @date 2022/08/19
 */
public class Lc1450 {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        if (startTime == null
                || endTime == null
                || startTime.length != endTime.length
                || queryTime <= 0) {
            return 0;
        }
        int ans = 0;
        for (int i = 0; i < startTime.length; i++) {
            if (startTime[i] <= queryTime && queryTime <= endTime[i]) {
                ans++;
            }
        }
        return ans;
    }
}
