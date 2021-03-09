package com.coolslow.playground.binary_tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 105. 从前序与中序遍历序列构造一棵二叉树
 * 根据一棵树的前序遍历与中序遍历构造一棵二叉树
 *
 * 注意：
 * 可以假设树中没有重复的元素。
 *
 * 例如，给出：
 * 前序遍历：preorder = [3, 9, 20, 15, 7]
 * 中序遍历：inorder = [9, 3, 15, 20, 7]
 *
 * 返回二叉树如下：
 *                3
 *               / \
 *              9  20
 *                /  \
 *               15   7
 */
public class NO105_ConstructBinaryTreeFromPreOrderAndInorderTraversal {
    private Map<Integer, Integer> indexMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;

        // NOTE：为什么是将中序遍历的数组存入哈希表
        indexMap = new HashMap<>();
        for(int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }

        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    private TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        // 注意：前序遍历左右子树下标对比的意义？
        if (preorder_left > preorder_right) {
            return null;
        }
        // 前序遍历的第一个节点就是根节点
        int preorder_root = preorder_left;
        // 在中序遍历中定位根节点
        int inorder_root = indexMap.get(preorder[preorder_root]);

        // 先建立根节点
        TreeNode root = new TreeNode(preorder[preorder_root]);

        // 获取左子树的节点数
        int size_left_subtree = inorder_root - inorder_left;
        root.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorder_right - 1);
        root.right = myBuildTree(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right);

        return root;
    }
}
