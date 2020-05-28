package com.coolslow.leetcode.top1000plus;

import com.coolslow.leetcode.top1000plus.datastructure.TreeNode;
import com.sun.source.tree.Tree;

/**
 * 100. 相同的树
 *
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * 示例 1:
 * 输入:       1         1
 *           / \       / \
 *          2   3     2   3
 *
 *         [1,2,3],   [1,2,3]
 * 输出：false
 *
 * 示例 2:
 * 输入:      1          1
 *           /           \
 *          2             2
 *
 *         [1,2],     [1,null,2]
 * 输出: false
 *
 * 示例 3:
 * 输入:       1         1
 *           / \       / \
 *          2   1     1   2
 *
 *         [1,2,1],   [1,1,2]
 * 输出: false
 *
 */
public class NO100_SameBinaryTreeNode {

    /**
     * 递归法判断相同二叉树
     *
     * 时间复杂度 O(n) n 为树的节点树
     * 空间复杂度：最优情况（完全平衡二叉树）时为O(logN)，最坏情况下为O(n)，用于维护递归栈。
     *
     * @param p 第一个二叉树
     * @param q 第二个二叉树
     * @return 布尔值 true 表示相同，false 表示不通
     */
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }

        if(p == null || q == null) {
            return false;
        }

        if(p.val != q.val) {
            return false;
        }

        return isSameTree(p.right, q.right) && isSameTree(p.left, q.left);
    }

}
