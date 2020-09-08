package com.coolslow.top1000plus;

import com.coolslow.leetcode.top1000plus.datastructure.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Title: NO144_BinaryTreePreorderTraversal
 * Desc: todo
 * Date: 2020/9/8 5:29 下午
 * Author: ming
 *
 * 题目：二叉树的前序遍历
 * 给定一个二叉树，返回它的"前序"遍历。
 *
 * 示例:
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,2,3]
 *
 * ------------------------------------------------------------
 * 展开
 * ------------------------------------------------------------
 * 有两种通用的遍历树的策略：
 * - 深度优先遍历（DFS）
 *   在这个策略中，采用 [深度] 作为优先级，以便从根开始一直到达某个确定的叶子节点，然后再返回根到达另一个分支。
 *   深度优先搜索策略又可以根据根结点、左孩子和右孩子的相对顺序被细分为 '前序遍历'、'中序遍历'、'后序遍历'。
 * - 广度优先遍历（BFS）
 *
 */
public class NO144_BinaryTreePreorderTraversal {

    /**
     * 递归解法
     * @param root 给定的二叉树
     * @return 返回前序遍历的结果
     */
    public static List<Integer> preorderTraversalWithRecursion(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if(root == null) return res;
        helper(root, res);
        return res;
    }

    private static void helper(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        // 向LinkedList中插入根节点的值
        res.add(root.val);

        // 递归处理左侧分支的数据
        if(root.left != null) {
            helper(root.left, res);
        }

        // 递归处理右侧分支的数据
        if(root.right != null) {
            helper(root.right, res);
        }
    }

    /**
     * 迭代解法
     * @param root 给定的二叉树
     * @return 返回前序遍历的结果
     */
    public static List<Integer> preorderTraversalWithIteration(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> res = new LinkedList<>();

        if(root == null) {
            return res;
        }

        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            res.add(node.val);

            if(node.right != null) {
                stack.add(node.right);
            }
            if(node.left != null) {
                stack.add(node.left);
            }
        }
        return res;
    }
}
