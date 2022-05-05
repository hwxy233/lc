package com.hwxy.code.leetcode.order.l500.l427;

/**
 * 427. 建立四叉树
 * https://leetcode-cn.com/problems/construct-quad-tree/
 * 
 * @author hwxy
 * @date 2022/04/29
 **/
public class Lc427 {
    private int[][] grid;

    public Node construct(int[][] grid) {
        if (grid == null) {
            return null;
        }
        this.grid = grid;
        Node r = dfs(0, grid.length - 1, 0, grid[0].length - 1);
        return r;
    }

    /**
     * 构造4叉树
     * 检查x,y的范围如果相差是1的话说明到叶子了
     * 检查范围内的是否相同
     * 如果相同说明那个是null
     * 否则递归构造子树(每次注意范围的问题)
     * 
     * @param startX
     * @param endX
     * @param startY
     * @param endY
     * @return
     */
    private Node dfs(int startX, int endX, int startY, int endY) {
        if (endX - startX < 0) {
            return null;
        }
        boolean isAllSame = sameNode(startX, endX, startY, endY);
        Node root = new Node();
        root.val = grid[startX][startY] == 1;
        // 都相同
        if (isAllSame) {
            root.isLeaf = true;
            root.topLeft = null;
            root.topRight = null;
            root.bottomLeft = null;
            root.bottomRight = null;
        } else {
            // 注意闭区间,这里不加1直接除2
            int halfLength = (endX - startX) / 2;
            root.topLeft = dfs(startX, startX + halfLength, startY, startY + halfLength);
            root.topRight = dfs(startX, startX + halfLength, startY + halfLength + 1, endY);
            // 注意startX要+1
            root.bottomLeft =
                    dfs(startX + halfLength + 1, endX, startY, startY + halfLength);
            root.bottomRight = dfs(startX + halfLength + 1, endX, startY + halfLength + 1, endY);
        }
        return root;
    }

    private boolean sameNode(int startX, int endX, int startY, int endY) {
        int val = grid[startX][startY];
        for (int i = startX; i <= endX; i++) {
            for (int j = startY; j <= endY; j++) {
                if (grid[i][j] != val) {
                    return false;
                }
            }
        }
        return true;
    }
}


class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;


    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft,
            Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
