package com.coolslow.leetcode.top1000plus;
import com.coolslow.leetcode.top1000plus.datastructure.TreeNode;
import com.sun.source.tree.Tree;

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
}
