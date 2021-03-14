package com.coolslow.playground.binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. 二叉树的层序遍历
 * 给定一棵二叉树，请返回其按 “层序遍历” 得到的节点值。（即逐层地，从左到右访问所有节点）。
 *
 * 示例：二叉树：[3, 9, 20, null, null, 15, 7]
 *         3
 *       /  \
 *      9   20
 *         /  \
 *       15    7
 * 返回其层序遍历的结果：
 * [
 *  [3],
 *  [9, 20],
 *  [15, 7]
 * ]
 */
public class NO102_BinaryTreeLevelOrderTraversal {
    /**
     * 方法一：广度优先搜索(BFS)
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        // 根节点为null时，返回空数组：[]
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            // 用于记录每一层的元素的List
            List<Integer> level = new ArrayList<>();
            // 必须获取此时的队列长度
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                // size中包含几个元素，就会向ArrayList中添加几个元素
                level.add(node.val);
                // 将下一层节点推入队列
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(level);
        }
        return res;
    }
}
