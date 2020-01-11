package com.coolslow.leetcode.top100plus.datastructure.Tree;

public class BinaryTree {

    public static class TreeNode<T> {
        T val;
        // 左子树
        TreeNode<T> left;
        // 右子树
        TreeNode<T> right;

        TreeNode(T x, TreeNode<T> left, TreeNode<T> right) {
            this.val = x;
            this.left = left;
            this.right = right;
        }
    }
}
