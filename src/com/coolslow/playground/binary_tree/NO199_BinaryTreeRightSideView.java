package com.coolslow.playground.binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 199. 二叉树的右视图
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * 示例：
 * 输入：[1, 2, 3, null, 5, null, 4]
 * 输出：[1, 3, 4]
 *
 * 解释：
 *           1         <---
 *         /  \
 *        2    3       <---
 *         \    \
 *          5    4     <---
 */
public class NO199_BinaryTreeRightSideView {
    /**
     * 方法一：广度优先遍历
     * 这也是最直观的方法
     * @param root
     * @return
     */
    public List<Integer> rightSideViewBFS(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if(cur.left != null) {
                    queue.offer(cur.left);
                }
                if(cur.right != null) {
                    queue.offer(cur.right);
                }
                // 当前层的最后一个节点的值存入list
                if(i == size - 1) {
                    res.add(cur.val);
                }
            }
        }

        return res;
    }

    /**
     * 方法二：深度优先遍历
     * @param root
     * @return
     */
    public List<Integer> rightSideViewDFS(TreeNode root) {
        dfs(root, 0);
        return res;
    }
    // 声明一个全局的list，用于存放返回结果
    List<Integer> res = new ArrayList<>();

    // 递归遍历整棵树（先遍历右子树，再遍历左子树）
    private void dfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (depth == res.size()) {
            res.add(root.val);
        }
        depth++;
        dfs(root.right, depth);
        dfs(root.left, depth);
    }
}
