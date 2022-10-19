package com.hwxy.code.leetcode.order.l1700.l1700;

/**
 * 1700. 无法吃午餐的学生数量
 * https://leetcode.cn/problems/number-of-students-unable-to-eat-lunch/
 *
 * @author hwxy
 * @date 2022/10/19
 **/
public class Lc1700 {
    public int countStudents(int[] students, int[] sandwiches) {
        if (students == null || sandwiches == null || sandwiches.length != students.length) {
            return 0;
        }
        // 分别统计数量
        int[] cnts = new int[2];
        for (int s : students) {
            cnts[s]++;
        }
        for (int s : sandwiches) {
            // 只要为0了就说明没有吃的了
            if (cnts[s] == 0) {
                break;
            }
            cnts[s]--;
        }
        return cnts[0] + cnts[1];
    }
}
