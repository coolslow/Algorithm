package com.coolslow.playground.binary_tree;

import java.util.LinkedList;

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
 *
 * 时间复杂度：O(n), n为二叉树节点的个数
 * 空间复杂度：O(n)，使用的空间由递归栈的深度决定，等于当前节点在二叉树中的高度。平均情况
 * 二叉树高度和节点个数的关系：O(lgn)。最坏情况，树退化为一个链表，空间负载度为O(n)
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

    // 更直观的深度优先遍历写法
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

    /**
     * 广度优先搜索翻转二叉树
     * @param root 二叉树
     * @return 返回一棵翻转的二叉树
     */
    public TreeNode invertTreeWithBFS(TreeNode root) {
        if (root == null) {
            return null;
        }
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        while(!list.isEmpty()) {
            TreeNode tmp = list.poll();
            TreeNode left = tmp.left;
            tmp.left = tmp.right;
            tmp.right = left;

            if (tmp.left != null) {
                list.add(tmp.left);
            }
            if (tmp.right != null) {
                list.add(tmp.right);
            }
        }
        return root;
    }
}
