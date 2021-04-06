package com.coolslow.playground.binary_tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 144. 二叉树的前序遍历
 * 给顶一颗二叉树的根节点 root，返回它节点值的前序遍历
 *
 * 示例：
 *      1
 *       \
 *        2
 *      /
 *     3
 * 输入：root = [1, null, 2, 3]
 * 输出：[1, 2, 3]
 */
public class NO144_BinaryTreePreorderTraversal {
    /**
     * 方法一：递归方式进行二叉树的前序遍历
     * @param root 二叉树根节点
     * @return 二叉树前序遍历组成的list
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root, res);

        return res;
    }

    private void preorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }

    /**
     * 方法二：迭代前序遍历二叉树
     * @param root
     * @return
     */
    public List<Integer> preorderTraversalII(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while(!stack.isEmpty() || node != null) {
            while(node != null) {
                res.add(node.val);
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();
            node = node.right;
        }
        return res;
    }

    /**
     * 方法三：Morris方式进行二叉树的前序遍历
     * 该方法的时间复杂度为 O(n),时间复杂度为 O(1)
     *
     * 备注：有一种巧妙的方法可以在线性时间内，只占用常数空间来实现前序遍历。
     * 这种方法由 J. H. Morris 在 1979 年的论文「Traversing Binary Trees Simply and Cheaply」中首次提出，因此被称为 Morris 遍历。
     *
     * Morris算法的思路：
     * 1. 新建临时节点，令该节点为root。
     * 2. 如果当前节点的左子节点为null，则将当前节点加入答案，并遍历当前节点的右子节点。
     * 3. 如果当前节点的左子节点不为null，在当前节点的左子树中找到当前节点在中序遍历下的前驱节点：
     *    - 如果前驱节点的右子节点为空，将前驱节点的右子节点设为当前节点。然后将当前节点加入答案，并将前驱节点的右子节点更新为当前节点。当前节点更新为当前节点的左子节点。
     *    - 如果前驱节点的左子节点为当前节点，将它的右子节点重新设为null。当前节点更新为当前节点的右子节点。
     * 4. 重复步骤2和3，直到遍历结束。
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversalIII(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }

        TreeNode p1 = root, p2 = null;
        while(p1 != null) {
            p2 = p1.left;
            // 如果当前节点的左子节点不为null
            if(p2 != null) {
                while(p2.right != null && p2.right != p1) {
                    p2 = p2.right;
                }
                if(p2.right == null) {
                    res.add(p1.val);
                    p2.right = p1;
                    p1 = p1.left;
                    continue;
                } else {
                    p2.right = null;
                }
            } else {
                res.add(p1.val);
            }
            p1 = p1.right;
        }
        return res;
    }
}
