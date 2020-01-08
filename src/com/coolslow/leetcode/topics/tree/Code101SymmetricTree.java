package com.coolslow.leetcode.topics.tree;

import com.coolslow.leetcode.topics.tree.ds.TreeNode;

/**
 * 对称二叉树
 * by MrThanksgiving
 */
public class Code101SymmetricTree {

    /**
     * <pre>
     * 题目：
     *      给定一个二叉树，检查它是否是镜像对称的。
     *
     * 例如：
     *      二叉树 [1,2,2,3,4,4,3] 是对称的。
     *
     *          1
     *         / \
     *        2   2
     *       / \ / \
     *      3  4 4  3
     *
     *      但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
     *
     *          1
     *         / \
     *        2   2
     *         \   \
     *         3    3
     *
     *
     *               1
     *           /      \
     *         2         2
     *       / \        / \
     *      3   4      4   3
     *     /\   /\    /\   /\
     *    1 2  3 4   4 3  2 1
     *
     * 说明:
     *      如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
     *
     * </pre>
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

}
