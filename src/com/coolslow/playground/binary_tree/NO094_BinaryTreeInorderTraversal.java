package com.coolslow.playground.binary_tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 * 给定一棵二叉树的根节点 root，返回它的 中序 遍历
 *
 * 示例1：
 *      1
 *       \
 *        2
 *       /
 *      3
 * 输入：root = [1, null, 2, 3]
 * 输出：[1, 3, 2]
 */
public class NO094_BinaryTreeInorderTraversal {

    /**
     * 方法一：递归
     * 时间复杂度：O(n)，其中 n 为二叉树节点的个数。二叉树的遍历中每个节点都会被访问一次切只会被访问一次。
     * 空间复杂度：O(n)，空间复杂度取决于递归的栈的深度，而栈深度在二叉树退化为一个链时会达到 O(n) 级别。
     * @param root 给定的二叉树的根节点。
     * @return 返回一个满足前序遍历条件的List
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    private void inorder(TreeNode root, List<Integer> res) {
        // 终止条件
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }

    /**
     * 方法二：迭代
     * 递归和迭代的区别在于，递归时隐式维护了一个栈，二在迭代时需要显示地将这个栈模拟出来。
     * @param root
     * @return
     */
    public List<Integer> inorderTraversalII(TreeNode root) {
        // 声明一个List，用于存放要返回的数据
        List<Integer> res = new ArrayList<>();
        // 声明一个双端队列
        Deque<TreeNode> stack = new LinkedList<>();
        while(root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                // 处理左子树，上一步的输出是下一步的输入
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            // 处理右子树
            root = root.right;
        }
        return res;
    }
}
