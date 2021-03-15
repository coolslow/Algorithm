package com.coolslow.playground.binary_tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 297. 二叉树的序列化与反序列化
 *
 * 序列化：将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或内存中。
 * 同事，也可以通过网络进行传输，反序列化则采用相反的方式重构得到原来的数据结构或对象。
 */
public class NO297_SerializeAndDeserializeBinaryTree {
    // 首先定义编码的规则：
    // tree: []
    // tree node -> "," 用逗号区分
    // node.val -> String(val)
    // 如果tree node为null -> null
    public String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder();
        // TreeNode开始标记
        res.append("[");
        Queue<TreeNode> queue = new LinkedList<>();
        // 将根节点入队
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur == null) {
                res.append("null,");
            } else {
                // 带有","标记作为节点之间的分隔标记
                res.append(cur.val + ",");
                queue.offer(cur.left);
                queue.offer(cur.right);
            }
        }
        // 取除"["和"]"以外的部分
        res.substring(1, res.length() - 1);
        // TreeNode结束标记
        res.append("]");

        return res.toString();
    }

    public TreeNode deserialize(String data) {
        String[] nodes = data.substring(1, data.length() - 1).split(",");
        TreeNode root = getNode(nodes[0]);
        Queue<TreeNode> parents = new LinkedList<>();
        TreeNode parent = root;
        boolean isLeft = true;
        for(int i = 1; i < nodes.length; i++) {
            TreeNode cur = getNode(nodes[i]);
            if(isLeft) {
                parent.left = cur;
            } else {
                parent.right = cur;
            }
            if(cur != null) {
                parents.add(cur);
            }
            isLeft = !isLeft;
            if (isLeft) {
                parent = parents.poll();
            }
        }
        return root;
    }

    private TreeNode getNode(String val) {
        if(val.equals("null")) {
            return null;
        }
        return new TreeNode(Integer.valueOf(val));
    }
}
