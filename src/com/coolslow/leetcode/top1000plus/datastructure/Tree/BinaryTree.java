package com.coolslow.leetcode.top1000plus.datastructure.Tree;

/**
 * 二叉树TreeNode的范型定义
 */
public class BinaryTree {

    public static class TreeNode<T> {
        T val;
        // 左子树
        public TreeNode<T> left;
        // 右子树
        public TreeNode<T> right;

        TreeNode(T x, TreeNode<T> left, TreeNode<T> right) {
            this.val = x;
            this.left = left;
            this.right = right;
        }
    }
}
