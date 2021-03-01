package com.coolslow.playground.binary_tree;

/**
 * 617. 合并二叉树
 * 给定两个二叉树，想象当你将他们中的一个覆盖到另一个上时，两个二叉树的一些节点会重叠。
 *
 * 如果要将它们合并为一个心的二叉树，合并的规则时如果两个节点重叠，那么将他们的值相加作为节点合并后的新值。
 * 否则，不为null的节点将直接作为新二叉树的节点。
 *
 * 示例1：
 *  输入：
 *       Tree 1                     Tree 2
 *         1                         2
 *        / \                       / \
 *       3   2                     1   3
 *      /                           \   \
 *     5                             4   7
 *  输出:
 *  合并后的树:
 * 	     3
 * 	    / \
 * 	   4   5
 * 	  / \   \
 * 	 5   4   7
 */
public class MergeTwoBinaryTree {
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

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return new TreeNode(0);
    }
}
