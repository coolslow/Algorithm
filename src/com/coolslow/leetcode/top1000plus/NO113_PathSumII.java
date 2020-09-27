package com.coolslow.leetcode.top1000plus;

import com.coolslow.leetcode.top1000plus.datastructure.TreeNode;
import com.sun.source.tree.Tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Title: NO113_PathSumII
 * Desc: 路径总和II
 * Date: 2020/9/27 4:55 下午
 * Author: ming
 *
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 */
public class NO113_PathSumII {
    /**
     * 解法一：深度优先
     * @param root 给定的二叉树
     * @param sum 给定的总和
     * @return 返回满足总和为 sum 的列表
     */
    public static List<List<Integer>> pathSumII(TreeNode root, int sum) {
        List<List<Integer>> ret = new LinkedList<>();
        Deque<Integer> path = new LinkedList<>();
        dfs(root, ret, path, sum);
        return ret;
    }

    private static void dfs(TreeNode root, List<List<Integer>> ret, Deque<Integer> path, int sum) {
        if(root == null) {
            return;
        }
        path.offerLast(root.val);
        sum -= root.val;
        if(root.left == null && root.right == null && sum == 0) {
            ret.add(new LinkedList<>(path));
        }
        dfs(root.left, ret, path, sum);
        dfs(root.right, ret, path, sum);

        path.pollLast();
    }
}
