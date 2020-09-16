package com.coolslow.leetcode.top1000plus;
import com.coolslow.leetcode.top1000plus.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 102 二叉树的层序遍历
 *
 * 给定一个二叉树，请按"层序遍历"返回节点值。（即逐层地从左到右访问所有节点）。
 *
 * 示例：
 * 二叉树 - [3, 9, 30, null, null, 15, 7]
 *          3
 *         / \
 *        9  20
 *          /  \
 *         15   7
 * 返回其层次遍历结果为：
 * [
 *    [3],
 *    [9, 20],
 *    [15, 7],
 * ]
 */
public class NO102_BinaryTreeLevelOrderTraversal {

    /**
     * 迭代解法
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param root 给定的二叉树
     * @return 返回一个按层遍历得到的数组List
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) {
            return new ArrayList<List<Integer>>();
        }
        // 用于存储待返回的数据
        List<List<Integer>> res = new ArrayList<>();
        // 用链表来存储给定二叉树
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(queue.size() > 0) {
            int size = queue.size();
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            for(int i = 0; i < size; i++) {
                TreeNode t = queue.remove();
                tmp.add(t.val);
                if(t.left != null) {
                    queue.add(t.left);
                }
                if(t.right != null) {
                    queue.add(t.right);
                }
            }
            res.add(tmp);
        }
        return res;
    }

    /**
     * 递归实现
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(h) h 表示二叉树的高度
     * @param root 给定的二叉树
     * @return 返回一个按层遍历得到的数组List
     */
    public static List<List<Integer>> levelOrderWithDFS(TreeNode root) {
        if(root == null) {
            return new ArrayList<List<Integer>>();
        }

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        dfs(1, root, res);
        return res;
    }

    // 采用递归的办法对二叉树的左右子树分别遍历
    private static void dfs(int depth, TreeNode root, List<List<Integer>> res) {
        if(res.size() < depth) {
            res.add(new ArrayList<Integer>());
        }

        res.get(depth - 1).add(root.val);

        if(root.left != null) {
            dfs(depth + 1, root.left, res);
        }

        if(root.right != null) {
            dfs(depth + 1, root.right, res);
        }
    }
}
