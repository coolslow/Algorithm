package com.coolslow.playground.binary_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 144. 二叉树的前序遍历
 * 给顶一颗二叉树的根节点 root，返回它节点值的前序遍历
 *
 * 示例：
 *      1
 *       \
 *        2
 *      /
 *     3
 * 输入：root = [1, null, 2, 3]
 * 输出：[1, 2, 3]
 */
public class NO144_BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root, res);

        return res;
    }

    private void preorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }
}
