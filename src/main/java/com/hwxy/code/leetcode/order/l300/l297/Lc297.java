package com.hwxy.code.leetcode.order.l300.l297;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.hwxy.code.ds.TreeNode;

/**
 * 297. 二叉树的序列化与反序列化
 * https://leetcode.cn/problems/serialize-and-deserialize-binary-tree/
 * 
 * @author hwxy
 * @date 2022/05/11
 **/
public class Lc297 {
    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode root = codec.deserialize("1,2,N,N,3,4,N,N,5,N,N");
        String s = codec.serialize(root);
        System.out.println(s);
    }
}


/**
 * 把null值编码进去,这样就可以唯一确定一课树了
 */
class Codec {
    public static final String N = "N";
    public static final String SP = ",";
    public static final String N_SP = "N,";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        dfsSerialize(sb, root);
        return sb.substring(0, sb.length() - 1);
    }

    /**
     * 先序遍历
     * 
     * @param sb
     * @param root
     */
    private void dfsSerialize(StringBuilder sb, TreeNode root) {
        if (root == null) {
            sb.append(N_SP);
            return;
        }
        sb.append(root.val).append(SP);
        dfsSerialize(sb, root.left);
        dfsSerialize(sb, root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) {
            return null;
        }
        List<String> dataStrList = new ArrayList<>(Arrays.asList(data.split(SP)));
        return dfsDeserialize(dataStrList);
    }

    /**
     * 每次pop队首元素来代替游标
     * 只要是null了就说明这个子树到底了
     * 
     * @param dataStrList
     * @return
     */
    private TreeNode dfsDeserialize(List<String> dataStrList) {
        if (dataStrList.isEmpty()) {
            return null;
        }
        if (N.equals(dataStrList.get(0))) {
            dataStrList.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(dataStrList.get(0)));
        dataStrList.remove(0);
        root.left = dfsDeserialize(dataStrList);
        root.right = dfsDeserialize(dataStrList);
        return root;
    }
}
