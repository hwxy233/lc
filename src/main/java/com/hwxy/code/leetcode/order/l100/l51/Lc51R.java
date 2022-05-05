package com.hwxy.code.leetcode.order.l100.l51;

import java.util.LinkedList;
import java.util.List;

/**
 * 干嘛的
 *
 * @author hwxy
 * @date 2022/02/04
 **/
public class Lc51R {

    public static void main(String[] args) {
        System.out.println(new Lc51R().solveNQueens(4));
    }

    private List<List<String>> res = new LinkedList<>();

    private String[][] curRes;

    public List<List<String>> solveNQueens(int n) {
        if (n < 1) {
            return res;
        }
        curRes = new String[n][n];
        backtracking(n, 0);
        return res;
    }

    private void backtracking(int n, int row) {
        if (row == n) {
            List<String> cur = new LinkedList<>();
            for (int i = 0; i < curRes.length; i++) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int j = 0; j < curRes[0].length; j++) {
                    if (curRes[i][j] == null) {
                        stringBuilder.append(".");
                    } else {
                        stringBuilder.append(curRes[i][j]);
                    }
                }
                cur.add(stringBuilder.toString());
            }
            res.add(cur);
            return;
        }
        // 列
        for (int i = 0; i < n; i++) {
            if (!isValide(row, i)) {
                continue;
            }
            curRes[row][i] = "Q";
            // 下一行
            backtracking(n, row + 1);
            curRes[row][i] = ".";
        }
    }

    private boolean isValide(int line, int column) {
        // 同一列有没有
        for (int i = 0; i < line; i++) {
            if ("Q".equals(curRes[i][column])) {
                return false;
            }
        }
        // 45度,是>=0
        for (int i = line - 1, j = column + 1; i >= 0 && j < curRes.length; i--, j++) {
            if ("Q".equals(curRes[i][j])) {
                return false;
            }
        }
        // 135度,是>=0
        for (int i = line - 1, j = column - 1; i >= 0 && j >= 0; i--, j--) {
            if ("Q".equals(curRes[i][j])) {
                return false;
            }
        }
        return true;
    }
}
