package com.coolslow.leetcode.topics.tree;

import com.coolslow.leetcode.topics.tree.ds.TreeNode;

import java.util.Stack;

/**
 * 二叉树的最大深度
 * by MrThanksgiving
 */
public class Code104MaximumDepthOfBinaryTree {

    /**
     * <pre>
     * 题目：
     *      给定一个二叉树，找出其最大深度。
     *      二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
     *
     * 说明:
     *      叶子节点是指没有子节点的节点。
     *
     * 示例：
     *      给定二叉树 [3,9,20,null,null,15,7]，
     *      返回它的最大深度 3 。
     *
     * </pre>
     */
    int max = 0;

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int lm = maxDepth(root.left) + 1;
        int rm = maxDepth(root.right) + 1;
        return Math.max(lm, rm);
    }

    public int maxDepth2(TreeNode root) {
        if (root == null) return 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root, visited = null;
        int height = 1;
        while (temp != null || !stack.isEmpty()) {
            while (temp != null) {
                stack.push(temp);
                temp = temp.left;
            }
            temp = stack.peek();
            if (temp.right == null || temp.right == visited) {
                height = Math.max(height, stack.size());
                temp = stack.pop();
                visited = temp;
                temp = null;
            } else {
                temp = temp.right;
            }
        }
        return height;
    }

}
