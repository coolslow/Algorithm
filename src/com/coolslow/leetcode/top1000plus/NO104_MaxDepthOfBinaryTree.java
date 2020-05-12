package com.coolslow.leetcode.top1000plus;
import com.coolslow.leetcode.top1000plus.datastructure.Tree.BinaryTree.TreeNode;

/**
 * 104. 二叉树的最大深度
 *
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数
 * 说明：叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定一个二叉树：[3, 9, 20, null, null, 15, 7]
 *               3
 *             /  \
 *            9   20
 *               /  \
 *              15   7
 *
 * 返回其最大深度为 3
 */
public class NO104_MaxDepthOfBinaryTree {

    /**
     * 解法一：递归求解
     *
     * 深度有限的策略 DFS
     * 时间复杂度：每个节点只访问一次，因此时间复杂度O(N), N为节点的数量
     * 空间复杂度：
     *  - 最糟糕的情况下，树是全部不平衡二叉树。树向一侧倾斜，此时的时间复杂度为O(N)
     *  - 最好的情况，树是一个完全平衡二叉树，此时时间复杂度为O(log(N))
     *
     * @param root 给定的二叉树
     * @return 返回二叉树的最大深度
     */
    public static int maxDepth(TreeNode<Integer> root) {
        if(root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right) + 1;
    }
}

