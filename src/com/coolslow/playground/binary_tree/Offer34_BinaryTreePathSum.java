package com.coolslow.playground.binary_tree;
import java.util.LinkedList;
import java.util.List;

/**
 * 34. 二叉树中和为某一值的路径
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。
 * 从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 */
public class Offer34_BinaryTreePathSum {
    private List<List<Integer>> result = new LinkedList<List<Integer>>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        LinkedList<Integer> curPath = new LinkedList<Integer>();
        dfs(curPath, root, sum);
        return result;
    }

    private void dfs(LinkedList<Integer> curPath, TreeNode curRoot, int target) {
        if (curRoot == null) {
            return;
        }

        curPath.add(curRoot.val);
        target -= curRoot.val;
        if ((target == 0) && (curRoot.left == null) && (curRoot.right == null)) {
            result.add(new LinkedList<Integer>(curPath));
        } else {
            dfs(curPath, curRoot.left, target);
            dfs(curPath, curRoot.right, target);
        }
        curPath.removeLast();   // 清除当前状态，回溯
    }
}
