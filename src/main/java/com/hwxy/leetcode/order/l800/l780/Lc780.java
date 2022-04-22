package com.hwxy.leetcode.order.l800.l780;

/**
 * 780. 到达终点
 * https://leetcode-cn.com/problems/reaching-points/
 * 
 * @author hwxy
 * @date 2022/04/09
 **/
public class Lc780 {
    public static void main(String[] args) {
        System.out.println(new Lc780().reachingPoints(1, 1, 3, 5));
        System.out.println(new Lc780().reachingPoints(1, 1, 2, 2));
        System.out.println(new Lc780().reachingPoints(1, 1, 1, 1));
    }

    private int tx;
    private int ty;

    /**
     * 反向运算
     * 
     * @param sx
     * @param sy
     * @param tx
     * @param ty
     * @return
     */
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        // 反向缩小tx,ty直到sx,sy || 如果tx==ty说明这就是初始状态
        while (tx > sx && ty > sy && tx != ty) {
            // tx比ty大,说明上一个状态是tx-ty,ty;所以直接将tx减去n个ty
            if (tx > ty) {
                tx = tx % ty;
            } else {
                ty = ty % tx;
            }
        }
        // 最后检查与sx,sy的关系
        if (tx == sx && ty == sy) {
            return true;
        }
        // 最后tx还需要修剪,由tx = sx + n*sy;所以直接判断(tx-sx)是不是sy的倍数
        if (tx > sx && ty == sy) {
            return (tx - sx) % sy == 0;
        } else if (tx == sx && ty > sy) {
            // 同理对于ty
            return (ty - sy) % sx == 0;
        }
        return false;
    }

    /**
     * 超时
     * 深度搜索
     * 看是否可以到达tx,ty
     * 
     * @param sx
     * @param sy
     * @return
     */
    private boolean bfs(int sx, int sy) {
        if (sx > tx || sy > ty) {
            return false;
        }
        if (sx == tx && sy == ty) {
            return true;
        }
        return bfs(sx, sx + sy) || bfs(sx + sy, sy);
    }
}
