package com.coolslow.playground.binary_tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 114. 二叉树展开为链表
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * - 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * - 展开后的单链表应该与二叉树【先序遍历】顺序相同。
 *
 * 示例：
 *              1                        1
 *            /   \                       \
 *          2      5                       2
 *        /  \      \                       \
 *       3    4      6                       3
 *                                            \
 *                                             4
 *                                              \
 *                                               5
 *                                                \
 *                                                 6
 *  输入：root = [1, 2, 5, 3, 4, null, 6]
 *  输出：[1, null, 2, null, 3, null, 4, null, 5, null, 6]
 */
public class NO114_FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        preorder(root, list);
        int size = list.size();
        for(int i = 1; i < size; i++) {
            TreeNode prev = list.get(i - 1);
            TreeNode curr = list.get(i);
            prev.left = null;
            prev.right = curr;
        }
    }
    // 递归实现前序遍历
    private void preorder(TreeNode root, List<TreeNode> list) {
        if(root != null) {
            list.add(root);
            preorder(root.left, list);
            preorder(root.right, list);
        }
    }


    // -------------------------------------------------
    public void flattenII(TreeNode root) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode node = root;
        while(node != null || !stack.isEmpty()) {
            while(node != null) {
                list.add(node);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        int size = list.size();
        for (int i = 1; i < size; i++) {
            TreeNode prev = list.get(i - 1);
            TreeNode curr = list.get(i);
            prev.left = null;
            prev.right = curr;
        }
    }
}
