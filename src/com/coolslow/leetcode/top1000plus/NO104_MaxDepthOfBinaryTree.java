package com.coolslow.leetcode.top1000plus;
import com.coolslow.leetcode.top1000plus.datastructure.Tree.BinaryTree.TreeNode;

/**
 * 104. 二叉树的最大深度
 *
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数
 * 说明：叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定一个二叉树：[3, 9, 20, null, null, 15, 7]
 *               3
 *             /  \
 *            9   20
 *               /  \
 *              15   7
 *
 * 返回其最大深度为 3
 */
public class NO104_MaxDepthOfBinaryTree {

    public static int maxDepth(TreeNode<Integer> root) {
        if(root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right) + 1;
    }
}

