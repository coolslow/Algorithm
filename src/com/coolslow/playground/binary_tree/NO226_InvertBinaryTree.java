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
    // 官方写法
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

    // 更直观的写法
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        // 不管在二叉树的哪一层，当前阶段需要做的就是交换其自身左右子树
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        // 递归调用左右子树
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
