package com.coolslow.playground.binary_tree;

/**
 * 111. 二叉树的最小深度
 *
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明：叶子节点是指没有子节点的节点。
 *
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：2
 *
 *          2
 *        /  \
 *     null   3
 *          /  \
 *       null   4
 *            /  \
 *         null   5
 *              /  \
 *           null   6
 *
 * 输入：root = [2,null,3,null,4,null,5,null,6]
 * 输出：5
 */
public class NO111_MinBinaryTreeDepth {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        // 必须是一个很大的数，用它和左右子树的深度进行比较
        int res = Integer.MAX_VALUE;
        if (root.left != null) {
            res = Math.min(minDepth(root.left), res);
        }
        if (root.right != null) {
            res = Math.min(minDepth(root.right), res);
        }
        return res + 1;
    }
}
