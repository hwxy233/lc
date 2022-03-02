package com.hwxy.order.l1700.l1601;

/**
 * 1601. 最多可达成的换楼请求数目
 * https://leetcode-cn.com/problems/maximum-number-of-achievable-transfer-requests/submissions/
 * 
 * @author hwxy
 * @date 2022/02/28
 **/
public class Lc1601 {
    public static void main(String[] args) {
        // System.out.println(new Lc1601().maximumRequests(5,
        // new int[][] {{0, 1}, {1, 0}, {0, 1}, {1, 2}, {2, 0}, {3, 4}}));
        // System.out.println(new Lc1601().maximumRequests(4,
        // new int[][] {{0, 3}, {3, 1}, {1, 2}, {2, 0}}));
        System.out.println(new Lc1601().maximumRequests(3,
                new int[][] {{1, 2}, {1, 2}, {2, 2}, {0, 2}, {2, 1}, {1, 1}, {1, 2}}));
    }


    private int ans;

    public int maximumRequests(int n, int[][] requests) {
        ans = 0;
        dfs(new int[n], requests, 0, 0);
        return ans;
    }

    // 可选选项：接受当前request、不接受当前request
    // 当前状态：各楼的人员流动情况
    // 结束条件：所有选择遍历一次，若各楼层流入流出为0，可行，若不为0，则不可行
    private void dfs(int[] count, int[][] requests, int cur, int chosen) {
        if (cur >= requests.length) {
            if (chosen > ans && isAcceptable(count)) {
                ans = chosen;
            }
            return;
        }

        dfs(count, requests, cur + 1, chosen);

        count[requests[cur][0]] -= 1;
        count[requests[cur][1]] += 1;
        dfs(count, requests, cur + 1, chosen + 1);
        count[requests[cur][1]] -= 1;
        count[requests[cur][0]] += 1;
    }

    private boolean isAcceptable(int[] cnt) {
        for (int c : cnt) {
            if (c != 0) {
                return false;
            }
        }
        return true;
    }
}
