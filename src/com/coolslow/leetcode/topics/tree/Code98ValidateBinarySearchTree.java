package com.coolslow.leetcode.topics.tree;

import com.coolslow.leetcode.topics.tree.ds.TreeNode;

import java.util.Stack;

/**
 * 验证二叉搜索树
 * by MrThanksgiving
 */
public class Code98ValidateBinarySearchTree {

    /**
     * <pre>
     * 题目：
     *      给定一个二叉树，判断其是否是一个有效的二叉搜索树。
     *
     *      假设一个二叉搜索树具有如下特征：
     *      节点的左子树只包含小于当前节点的数。
     *      节点的右子树只包含大于当前节点的数。
     *      所有左子树和右子树自身必须也是二叉搜索树。
     *
     * 示例 1:
     *      输入:
     *          2
     *         / \
     *        1   3
     *      输出: true
     *
     * 示例 2:
     *      输入:
     *          5
     *         / \
     *        1   4
     *           / \
     *          3   6
     *      输出: false
     *      解释: 输入为: [5,1,4,null,null,3,6]。
     *           根节点的值为 5 ，但是其右子节点值为 4 。
     *
     * </pre>
     */
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        long lastValue = Long.MIN_VALUE;
        while (temp != null || !stack.isEmpty()) {
            while (temp != null) {
                stack.push(temp);
                temp = temp.left;
            }
            temp = stack.pop();
            if (temp.val <= lastValue) return false;
            lastValue = temp.val;
            if (temp.right != null) {
                temp = temp.right;
            } else {
                temp = null;
            }
        }
        return true;
    }


    public boolean isValidBST2(TreeNode root) {
        return isValidBST(root, null, null);
    }

    public boolean isValidBST(TreeNode root, Integer min, Integer max) {
        if (root == null) return true;
        Integer val = root.val;
        if (min != null && min >= val) return false;
        if (max != null && max <= val) return false;
        if (!isValidBST(root.left, min, val)) return false;
        if (!isValidBST(root.right, val, max)) return false;
        return true;
    }

}
