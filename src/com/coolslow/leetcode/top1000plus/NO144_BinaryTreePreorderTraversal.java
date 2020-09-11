package com.coolslow.leetcode.top1000plus;

import com.coolslow.leetcode.top1000plus.datastructure.TreeNode;
import java.util.LinkedList;
import java.util.List;

/**
 * 144. 二叉树的前序遍历
 *
 * 给定一个二叉树，返回他的前序遍历的结果。
 *
 * 示例：
 *
 * 输入：[1, null, 2, 3]
 *       1
 *        \
 *         2
 *        /
 *       3
 */

public class NO144_BinaryTreePreorderTraversal {

    public static List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();

        if(root == null) {
            return output;
        }

        // 将根结点压入栈中
        stack.add(root);
        /* 必须保证：先压右孩子，再压左孩子 */
        while(!stack.isEmpty()) {
            // pollLast方法返回列表的最后一个元素（同时也将该元素从列表中移除）
            TreeNode node = stack.pollLast();
            output.add(node.val);

            if(node.right != null) {
                stack.add(node.left);
            }

            if(node.left != null) {
                stack.add(node.right);
            }
        }
        return output;
    }
}
