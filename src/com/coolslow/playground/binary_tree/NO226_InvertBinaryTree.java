package com.coolslow.playground.binary_tree;

/**
 * 226. 翻转二叉树
 *
 * 翻转一棵二叉树。
 * 示例：
 * 输入：
 *       4
 *     /   \
 *   2      7
 *  / \    / \
 * 1   3  6   9
 *
 * 输出：
 *       4
 *     /   \
 *   7      2
 *  / \    / \
 * 9   6  3   1
 */
public class NO226_InvertBinaryTree {

    public TreeNode invertBinaryTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertBinaryTree(root.left);
        TreeNode right = invertBinaryTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }
}
