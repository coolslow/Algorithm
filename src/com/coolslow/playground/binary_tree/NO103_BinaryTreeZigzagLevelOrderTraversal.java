package com.coolslow.playground.binary_tree;

import java.util.*;

/**
 * 103. 二叉树的锯齿形层序遍历
 * 给定一棵二叉树，返回其节点值的锯齿形层序遍历。（即：先从左往右，再从右往左进行下一层遍历，一次类推，层与层之间交替进行）。
 *
 * 例如：给定二叉树 [3, 9, 20, null, null, 15, 7]
 *     3
 *    / \
 *   9  20
 *     /  \
 *   15    7
 * 返回锯齿形层序遍历如下：
 * [
 *  [3],
 *  [20, 9],
 *  [15, 7]
 * ]
 */

public class NO103_BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // 默认为左子树
        boolean isOrderLeft = true;

        while(!queue.isEmpty()) {
            Deque<Integer> levelList = new LinkedList<>();
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (isOrderLeft) {
                    levelList.offerLast(cur.val);
                } else {
                    levelList.offerFirst(cur.val);
                }

                if(cur.left != null) {
                    queue.offer(cur.left);
                }
                if(cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            list.add(new LinkedList<>(levelList));
            isOrderLeft = !isOrderLeft;
        }

        return list;
    }
}
