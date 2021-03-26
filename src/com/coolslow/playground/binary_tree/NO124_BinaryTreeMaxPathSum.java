package com.coolslow.playground.binary_tree;

/**
 * 124. [困难] 二叉树中最大路径和
 *
 * "路径"被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中至多出现一次。该路径至少包含一个节点，且不一定经过根节点。
 * 路径和 是路径中各节点值的总和。
 * 给定一个二叉树的根节点root，返回其最大路径和。
 *
 * 示例1：
 *       1
 *     /  \
 *    2    3
 * 输入：root = [1, 2, 3]
 * 输出：6
 * 解释：最优路径是 2 -> 1 -> 3，路径和为 2 + 1 + 3 = 6
 *
 * 示例2：
 *      -10
 *      /  \
 *    9    20
 *        /   \
 *      15     7
 * 输入：root = [-10, 9, 20, null, null, 15, 7]
 * 输出：42
 * 解释：最优路径是 15 -> 20 -> 7，路径和为 15 + 20 + 7
 *
 */
public class NO124_BinaryTreeMaxPathSum {
    int sumMax = Integer.MAX_VALUE;
    public int maxPathSum(TreeNode root) {
        getMax(root);
        return sumMax;
    }

    private int getMax(TreeNode node) {
        if (node  == null) {
            return 0;
        }
        int leftMax = Math.max(getMax(node.left), 0);
        int rightMax = Math.max(getMax(node.right), 0);

        int tmpRes = node.val + leftMax + rightMax;
        sumMax = Math.max(sumMax, tmpRes);

        return node.val + Math.max(leftMax, rightMax);
    }
}
