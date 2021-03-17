package com.coolslow.playground;

import java.util.LinkedList;
import java.util.Queue;

public class playground {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    /* =================================== **/
    /* 序列化和反序列化二叉树                  **/
    /* =================================== **/
    public class LeetCode_NO297 {
        // use [] to tag a tree node
        // use "," to split nodes
        // if node equals null -> null
        // node.val -> String(node.val)
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while(!queue.isEmpty()) {
                TreeNode node = queue.poll();
                // 当节点为空时
                if (node == null) {
                    sb.append("null, ");
                } else {
                    sb.append(node.val + ",");
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
            sb.substring(1, sb.length() - 1);
            sb.append("]");

            return sb.toString();
        }

//        public TreeNode deserialize(String data) {
//
//        }
    }

}
