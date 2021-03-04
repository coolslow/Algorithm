package com.coolslow.playground.binary_tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3, 9, 20, null, null, 15, 7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度3 。
 *
 */
public class NO104_MaxDepthOfBinaryTree {

    /**
     * 方法一：递归的DFS方法
     * - 时间复杂度为O(n)
     * - 空间复杂度为O(height) -> 极端情况下为O(n)，其蜕变为一个链表
     *
     * @param root 树的跟节点
     * @return 最大深度
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public int maxDepthII(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int l = maxDepthII(root.left);
        int r = maxDepthII(root.right);

        return Math.max(l, r) + 1;
    }

    /**
     * 广度优先搜索 (BFS)
     * 时间复杂度：O(n)
     * 空间复杂度：O(width) -> 最坏情况 O(n)
     * @param root TreeNode 根节点
     * @return 返回最大深度
     */
    public int maxDepthBFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while(!queue.isEmpty()) {
            int n = queue.size();
            for(int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
            depth++;
        }
        return depth;
    }
}
