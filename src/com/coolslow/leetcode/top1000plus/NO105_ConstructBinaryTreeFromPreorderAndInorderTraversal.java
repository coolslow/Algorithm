package com.coolslow.leetcode.top1000plus;

import com.coolslow.leetcode.top1000plus.datastructure.TreeNode;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 *
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出：
 * 前序遍历 preorder = [3, 9, 20, 15, 7]
 * 中序遍历 inorder = [9, 3, 15, 20, 7]
 *
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 思路：
 *  preorder的第一个元素必然为root，在inorder里找到root，在它之前的为左子树，在它之后的为右子树，分别递归。
 */
public class NO105_ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private static TreeNode buildTreeHelper(int[] preorder, int p_start, int p_end, int[] inorder, int i_start, int i_end) {
        // preorder 为空时，直接返回 null
        if (p_start == p_end) {
            return null;
        }
        // 前序遍历的第一个节点必定是root根节点
        int root_val = preorder[p_start];
        TreeNode root = new TreeNode(root_val);

        // 在中序遍历中找到根节点的位置
        int i_root_index = 0;
        for(int i = i_start; i < i_end; i++) {
            if (root_val == inorder[i]) {
                i_root_index = i;
                break;
            }
        }
        int leftNum = i_root_index - i_start;
        // 递归构造左子树
        root.left = buildTreeHelper(preorder, p_start + 1, p_start + leftNum + 1, inorder, i_start, i_root_index);
        // 递归构造右子树
        root.right = buildTreeHelper(preorder, p_start + leftNum + 1, p_end, inorder, i_root_index + 1, i_end);
        return root;
    }
}
