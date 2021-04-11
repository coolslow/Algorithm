package com.coolslow.playground.binary_tree;

/**
 * 剑指Offer 54. 二叉搜索树的第K大节点
 *
 * 给定一棵二叉搜索树，请找出其中第K大的节点。
 *
 * 示例1：
 * 输入：root = [3, 1, 4, null, 2], k = 1
 *           3
 *         /   \
 *        1     4
 *         \
 *         2
 * 输出：4
 *
 * 示例2：
 * 输入：root = [5, 3, 6, 2, 4, null, null, 1], k = 3
 *           5
 *         /  \
 *        3    6
 *      /  \
 *     2    4
 *   /
 *  1
 * 输出：4
 *
 * 关键：二叉树的中序遍历的逆序是递减序列。
 */
public class Offer54_TheKthMaxNumInBinaryTree {

    int res, k;
    public int KthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.right);

        if (k == 0) return;
        if(--k == 0) {
            res = root.val;
        }
        dfs(root.left);
    }
}
