package com.coolslow.leetcode.from_scratch.Tree;

import com.coolslow.leetcode.topics.tree.ds.TreeNode;

/**
 * 平衡二叉树
 *
 * 给定一个二叉树，判断它是否是高度平衡的二叉树
 *
 * 高度平衡的二叉树定义为：
 * - 一个二叉树每个节点的左右两个子树的高度差的绝对值不超过1
 *
 * 示例1：
 *       3
 *      / \
 *     9  20
 *       /  \
 *     15    7
 * 输入: root = [3, 9, 20, null, null, 15, 7]
 * 输出: true
 *
 * 示例2：
 *              1
 *             / \
 *            2   2
 *           / \
 *          3   3
 *         / \
 *        4   4
 * 输入: root = [1, 2, 2, 3, 3, null, null, 4, 4]
 * 输出: true
 *
 * NOTE: 判断一棵树是否为平衡二叉树，那么关键点是仅且仅当这棵树的左右子树都是平衡二叉树时，整棵树才满足条件，因此可以用递归的办法求解。
 */
public class NO110_BalancedBinaryTree {
    public static boolean isBalanced(TreeNode root) {
        // 根节点为null，则必然是一颗平衡二叉树
        if (root == null) {
            return true;
        } else {
            return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }
    }
    // 递归计算树的高度
    private static int height(TreeNode node) {
        if(node == null) {
            return 0;
        } else {
            return Math.max(height(node.left), height(node.right)) + 1;
        }
    }
}
