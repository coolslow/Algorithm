package com.coolslow.playground.binary_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 * 给定一棵二叉树的根节点 root，返回它的 中序 遍历
 *
 * 示例1：
 *      1
 *       \
 *        2
 *       /
 *      3
 * 输入：root = [1, null, 2, 3]
 * 输出：[1, 3, 2]
 */
public class NO094_BinaryTreeInorderTraversal {

    /**
     * 时间复杂度：O(n)，其中 n 为二叉树节点的个数。二叉树的遍历中每个节点都会被访问一次切只会被访问一次。
     * 空间复杂度：O(n)，空间复杂度取决于递归的栈的深度，而栈深度在二叉树退化为一个链时会达到 O(n) 级别。
     * @param root 给定的二叉树的根节点。
     * @return 返回一个满足前序遍历条件的List
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    private void inorder(TreeNode root, List<Integer> res) {
        // 终止条件
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }
}
