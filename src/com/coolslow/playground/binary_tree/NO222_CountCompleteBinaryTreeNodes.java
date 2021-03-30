package com.coolslow.playground.binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 222. 完全二叉树的节点个数
 *
 * 给定一棵完全二叉树的根节点root，求出该树的节点个数。
 * 完全二叉树的定义如下：
 * 在完全二叉树中，除了底层节点可能没有被填满外，其余每层节点都达到最大值。
 * 并且最下面一层的节点都集中在该层最左边的若干位置。
 *
 * 示例：1
 *                    1
 *                  /   \
 *                2      3
 *              /  \    /
 *            4     5  6
 * 输入：root = [1, 2, 3, 4, 5, 6]
 * 输出：6
 */
public class NO222_CountCompleteBinaryTreeNodes {
    /**
     * 最基本的方法，用层序遍历的方式，将节点存储在ArrayList中，求list中有多少个数即可。
     */
    public int countNodes(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            list.add(cur.val);

            if (cur.left != null) {
                queue.offer(cur.left);
            }

            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
        return list.size();
    }

    /**
     * 用递归的方式求二叉树节点
     * @param root
     * @return
     */
    public int countNodesII(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return countNodesII(root.left) + countNodesII(root.right) + 1;
    }

    /**
     * 利用题目中 “完全二叉树” 的条件进行处理
     * @param root
     * @return
     */
    public int countNodesBestMatch(TreeNode root) {
        int count = 0, height = treeHeight(root);
        while(root != null) {
            //如果右子树的高度是树的高度减1，那么左子树就是满二叉树
            if (treeHeight(root.right) == height - 1) {//左子树是满二叉树
                count += 1 << height - 1;
                root = root.right;
            } else {//右子树是满二叉树
                count += 1 << height - 2;
                root = root.left;
            }
            height--;
        }
        return count;
    }

    // 因为是完全二叉树，因此，可以对左子树递归求解树高
    private int treeHeight(TreeNode root) {
        return root == null ? 0 : treeHeight(root.left) + 1;
    }
}
