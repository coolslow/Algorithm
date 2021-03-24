package com.coolslow.playground.binary_tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 112. 路径总和
 * 给你二叉树的根节点root 和一个表示目标和的整数targetSum ，判断该树中是否存在 根节点到叶子节点 的路径，
 * 这条路径上所有节点值相加等于目标和targetSum 。
 *                      5
 *                    /   \
 *                   4     8
 *                 /      / \
 *                11    13   4
 *              /   \         \
 *             7     2         1
 *
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 * 输出：true
 *
 */
public class NO112_PathSum {

    /**
     * 方法一：广度优先
     * 时间复杂度：O(N)
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // 先判断根节点是否为null, 为空则直接返回false
        if (root == null) {
            return false;
        }
        // 用于存储节点
        Queue<TreeNode> queueNode = new LinkedList<>();
        // 用于存储节点的值
        Queue<Integer> queueVal = new LinkedList<>();
        queueNode.offer(root);
        queueVal.offer(root.val);
        while(!queueNode.isEmpty()) {
            TreeNode cur = queueNode.poll();
            int tmp = queueVal.poll();
            // 满足左右子树为空则表示为叶子节点
            if(cur.left == null && cur.right == null) {
                if (tmp == targetSum) {
                    return true;
                }
                continue;
            }
            // 左子树不为空时，将左子树入队
            if (cur.left != null) {
                queueNode.offer(cur.left);
                queueVal.offer(cur.left.val + tmp);
            }
            // 右子树不为空时，将右子树入队
            if (cur.right != null) {
                queueNode.offer(cur.right);
                queueVal.offer(cur.right.val + tmp);
            }
        }
        return false;
    }

    public boolean hasPathSumII(TreeNode root, int targetNum) {
        if (root == null) {
            return false;
        }
        // 终止的条件：即叶子节点与目标值之差是否为0
        if (root.left == null && root.right == null) {
            return targetNum - root.val == 0;
        }

        boolean leftPathSum = hasPathSumII(root.left, targetNum - root.val);
        boolean rightPathSum = hasPathSumII(root.right, targetNum - root.val);

        return leftPathSum || rightPathSum;
    }
}
