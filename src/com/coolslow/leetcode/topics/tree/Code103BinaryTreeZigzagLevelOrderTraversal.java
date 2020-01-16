package com.coolslow.leetcode.topics.tree;

import com.coolslow.leetcode.topics.tree.ds.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的锯齿形层次遍历
 * by MrThanksgiving
 */
public class Code103BinaryTreeZigzagLevelOrderTraversal {

    /**
     * <pre>
     * 题目：
     *      给定一个二叉树，返回其节点值的锯齿形层次遍历。（
     *      即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
     *
     * 例如：
     *      给定二叉树 [3,9,20,null,null,15,7],
     *
     *          3
     *         / \
     *        9  20
     *          /  \
     *         15   7
     *      返回锯齿形层次遍历如下：
     *      [
     *        [3],
     *        [20,9],
     *        [15,7]
     *      ]
     *
     * </pre>
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int index = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if (temp != null) {
                    if (index % 2 == 1) {
                        list.add(temp.val);
                    } else {
                        list.addFirst(temp.val);
                    }
                    if (temp.left != null) queue.add(temp.left);
                    if (temp.right != null) queue.add(temp.right);
                }
            }
            index++;
            result.add(list);
        }
        return result;
    }

}
