package com.coolslow.leetcode.topics.tree;

import com.coolslow.leetcode.topics.tree.ds.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的层次遍历
 * by MrThanksgiving
 */
public class Code102BinaryTreeLevelOrderTraversal {

    /**
     * <pre>
     * 题目：
     *      给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
     *
     * 例如:
     *      给定二叉树: [3,9,20,null,null,15,7],
     *
     *          3
     *         / \
     *        9  20
     *          /  \
     *         15   7
     *      返回其层次遍历结果：
     *      [
     *        [3],
     *        [9,20],
     *        [15,7]
     *      ]
     *
     * </pre>
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();
        queue.add(root);
        TreeNode temp;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new LinkedList<>();
            result.add(list);
            for (int i = 0; i < size; i++) {
                temp = queue.poll();
                if (temp != null)
                    list.add(temp.val);
                if (temp != null && temp.left != null)
                    queue.add(temp.left);
                if (temp != null && temp.right != null)
                    queue.add(temp.right);
            }
        }
        return result;
    }

}
