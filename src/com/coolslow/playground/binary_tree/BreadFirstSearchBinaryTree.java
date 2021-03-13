package com.coolslow.playground.binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 剑指Offer 32 - 1. 从上到下打印二叉树
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 * 例如:
 * 给定二叉树: [3, 9, 20, null, null, 15, 7]
 *      3
 *     / \
 *    9  20
 *      /  \
 *     15   7
 * 返回：[3, 9, 20, 15, 7]
 *
 * 注意：节点总数 <= 1000
 */
public class BreadFirstSearchBinaryTree {

    public int[] bfsPrintBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        if (root == null) {
            return new int[0];
        }

        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            res.add(node.val);

            if(node.left != null) {
                queue.add(node.left);
            }
            if(node.right != null) {
                queue.add(node.right);
            }
        }
        int[] r = new int[queue.size()];
        for(int i = 0; i < queue.size(); i++) {
            r[i] = res.get(i);
        }
        return r;
    }
}
