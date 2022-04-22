package com.hwxy.leetcode.OJ.base.greedy;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * 区间问题
 *
 * @author hwxy
 * @date 2021/03/27
 **/
public class IntervalQuestion {
    public static void main(String[] args) {
        System.out.println(calJobNumber(5, new int[]{1, 2, 4, 6, 8}, new int[]{3, 5, 7, 9, 10}));
    }

    /**
     * 计算不能重叠的最多工作的数量(包括首尾都不能重叠)
     *
     * @param n 总工作数
     * @param s 工作的开始时间
     * @param t 工作的结束时间
     * @return 工作数
     */
    public static int calJobNumber(int n, int s[], int t[]) {
        List<Job> jobList = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            Job job = new Job();
            job.setStartTime(s[i]);
            job.setEndTime(t[i]);
            jobList.add(job);
        }
        // 按照结束时间小到大排序
        jobList.sort(Comparator.comparingInt(Job::getEndTime));
        // 每次选择开始时间大于上次结束时间的
        int count = 0;
        int lastEndTime = 0;
        for (Job job : jobList) {
            if (job.getStartTime() > lastEndTime) {
                count++;
                lastEndTime = job.getEndTime();
            }
        }
        return count;
    }

    static class Job {
        private int startTime;
        private int endTime;

        public int getStartTime() {
            return startTime;
        }

        public void setStartTime(int startTime) {
            this.startTime = startTime;
        }

        public int getEndTime() {
            return endTime;
        }

        public void setEndTime(int endTime) {
            this.endTime = endTime;
        }
    }
}
