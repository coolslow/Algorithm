package com.coolslow.playground.binary_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 145. 二叉树的后续遍历
 * 给定一棵二叉树，返回它的后续遍历的结果。
 *
 * 示例：
 * 输入：[1, null, 2, 3]
 *    1
 *     \
 *     2
 *    /
 *   3
 *
 * 输出：[3, 2, 1]
 */
public class NO145_BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorder(root, res);
        return res;
    }

    private void postorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        postorder(root.left, res);
        postorder(root.right, res);
        res.add(root.val);
    }
}
