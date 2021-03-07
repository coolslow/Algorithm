package com.coolslow.playground.binary_tree;

/**
 * 110. 判断平衡二叉树
 * 输入一棵二叉树的根节点，判断该树是否为平衡二叉树。
 * 判断条件：如果某个二叉树中任意节点的左右子树的深度相差 <= 1，则其为平衡二叉树。
 *
 * https://leetcode-cn.com/problems/balanced-binary-tree/ 相同
 *
 * 示例1：
 * 给定二叉树 [3, 9, 20, null, null, 15, 7]
 *      3
 *     / \
 *    9  20
 *      / \
 *    15   7
 * 返回 true
 *
 * 限制：0 <= 树的节点个数 <= 1000
 */
public class NO110_BalancedBinaryTree {
    // 方法1：后序遍历 + 剪枝（从底至顶）
    // 1. 当节点 root 左右子树的深度差 <= 1：则返回当前子树的深度，即节点 root 的左右子树的蛇毒最大值 + 1
    // 2. 当前节点 root 左右子树的深度差 >= 2：则返回 - 1，表示该树不为平衡二叉树。
    // 终止条件：
    // 1. 当 root 为空：返回树的高度为0
    // 2. 当左右子树深度为 -1：表示此树的左右子树不是平衡树，因此剪枝，直接返回 -1。
    // 时间复杂度O(N)、空间复杂度O(N)
    public boolean isBalanced(TreeNode root) {
        return recur(root) != -1;
    }

    private int recur(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = recur(root.left);
        // 递归调用，如果左子树返回-1表示它并非一颗平衡二叉树
        if (left == -1) {
            return -1;
        }
        int right = recur(root.right);
        // 递归调用，如果右子树返回-1表示它并非一颗平衡二叉树
        if (right == -1) {
            return -1;
        }

        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }

    public boolean isBalancedII(TreeNode root) {
        if (root == null) {
            return true;
        }

        return Math.abs(depth(root.left) - depth(root.right)) <= 1 && isBalanced(root.left) && isBalanced((root.right));
    }

    private int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(depth(node.left), depth(node.right)) + 1;
    }
}
