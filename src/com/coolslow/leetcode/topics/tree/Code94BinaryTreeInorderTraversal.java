package com.coolslow.leetcode.topics.tree;

import com.coolslow.leetcode.topics.tree.ds.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的中序遍历
 * by MrThanksgiving
 */
public class Code94BinaryTreeInorderTraversal {

    /**
     * <pre>
     * 题目：
     *      给定一个二叉树，返回它的中序 遍历。
     *
     * 示例:
     *      输入: [1,null,2,3]
     *         1
     *          \
     *           2
     *          /
     *         3
     *      输出: [1,3,2]
     *
     * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
     *
     * </pre>
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while (temp != null || !stack.isEmpty()) {
            while (temp != null) {
                stack.push(temp);
                temp = temp.left;
            }
            temp = stack.pop();
            result.add(temp.val);
            if (temp.right != null) {
                temp = temp.right;
            } else {
                temp = null;
            }
        }
        return result;
    }

}
