package com.coolslow.leetcode.from_scratch.Tree;

import com.coolslow.leetcode.topics.tree.ds.TreeNode;

/**
 * 101. 平衡二叉树
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

    /**
     * 方法一: 置顶向下的递归方法。
     *
     * 时间复杂度O(N^2)，N是二叉树中节点个数
     * 空间复杂度O(N)
     *
     * 由于至顶向下递归，对于同一个节点，函数height会被重复调用，导致时间复杂度变高。
     * @param root
     * @return
     */
    public static boolean isBalanced_I(TreeNode root) {
        // 根节点为null，则必然是一颗平衡二叉树
        if (root == null) {
            return true;
        } else {
            return Math.abs(height_I(root.left) - height_I(root.right)) <= 1 && isBalanced_I(root.left) && isBalanced_I(root.right);
        }
    }
    // 递归计算树的高度
    private static int height_I(TreeNode node) {
        if(node == null) {
            return 0;
        } else {
            return Math.max(height_I(node.left), height_I(node.right)) + 1;
        }
    }

    /**
     * 方法二: 至底向上的递归方法。
     * 如果是自底向上递归遍历，则height函数不会被调用重复调用。
     *
     * 此方法的时间复杂度为O(N)，空间复杂度为O(N)
     * 自底向上调用类似于后序遍历
     * @param root
     * @return
     */
    public static boolean isBalanced_II(TreeNode root) {
        return height_II(root) >= 0;
    }

    private static int height_II(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftHeight = height_II(root.left);
        int rightHeight = height_II(root.right);

        if(leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
