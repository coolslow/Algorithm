package com.coolslow.leetcode.top1000plus;

import com.coolslow.leetcode.top1000plus.datastructure.TreeNode;

/**
 * 112. 路径总和
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 *
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5 -> 4 -> 11 -> 2。
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *         val = x;
 *     }
 * }
 */
public class NO112_PathSum {

    /**
     * 解法一：递归方式处理
     * @param root
     * @param sum
     * @return
     */
    public static boolean hasPathSum(TreeNode root, int sum) {
        // 从根结点开始，如果root为null，则肯定无解
        if (root == null) {
            return false;
        }
        // 如果根结点的左右子树都为空，则判断根结点的值与sum的关系，相等为true，否则为false
        if (root.left == null && root.right == null) {
            return sum - root.val == 0;
        }
        // 递归判断左右子二叉树的结果。
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
