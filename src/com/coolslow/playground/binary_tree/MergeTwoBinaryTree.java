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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }

        TreeNode merged = new TreeNode(root1.val + root2.val);
        merged.left = mergeTrees(root1.left, root2.left);
        merged.right = mergeTrees(root1.right, root2.right);

        return merged;
    }
    // 仅仅是对方法一做了更精细的判断，本质还是深度遍历 + 递归。
    public TreeNode mergeTreesII(TreeNode root1, TreeNode root2) {
        TreeNode merged;
        if (root1 == null && root2 == null) {
            return null;
        }
        if (root1 != null && root2 == null) {
            merged = new TreeNode(root1.val);
            merged.left = mergeTreesII(root1.left, null);
            merged.right = mergeTreesII(root1.right, null);
        }
        else if (root1 == null && root2 != null) {
            merged = new TreeNode(root2.val);
            merged.left = mergeTreesII(null, root2.left);
            merged.right = mergeTreesII(null, root2.right);
        }
        else {
            merged = new TreeNode(root1.val + root2.val);
            merged.left = mergeTreesII(root1.left, root2.left);
            merged.right = mergeTreesII(root1.right, root2.right);
        }

        return merged;
    }
}
