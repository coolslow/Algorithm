package com.coolslow.leetcode.topics.tree;

import com.coolslow.leetcode.topics.tree.ds.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 从前序与中序遍历序列构造二叉树
 * by MrThanksgiving
 */
public class Code105ConstructBinaryTreeFromPreOrderAndInorderTraversal {

    /**
     * <pre>
     * 题目：
     *      根据一棵树的前序遍历与中序遍历构造二叉树。
     *
     * 注意:
     *      你可以假设树中没有重复的元素。
     *
     * 例如，给出
     *      前序遍历 preorder = [3,9,20,15,7]
     *      中序遍历 inorder = [9,3,15,20,7]
     *      返回如下的二叉树：
     *
     *          3
     *         / \
     *        9  20
     *          /  \
     *         15   7
     *
     * </pre>
     */

    private Map<Integer, Integer> index = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) return null;
        for (int i = 0; i < inorder.length; i++) {
            index.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    public TreeNode helper(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {
        if (pStart == pEnd) return null;
        TreeNode root = new TreeNode(preorder[pStart]);
        int m = index.get(preorder[pStart]);
        int n = m - iStart;
        root.left = helper(preorder, pStart + 1, pStart + n + 1, inorder, iStart, m + 1);
        root.right = helper(preorder, pStart + n + 1, pEnd, inorder, m + 1, iEnd);
        return root;
    }
}