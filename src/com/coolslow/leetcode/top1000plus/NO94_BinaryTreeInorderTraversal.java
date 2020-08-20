package com.coolslow.leetcode.top1000plus;

import com.coolslow.leetcode.top1000plus.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 *
 * 示例:
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 */
public class NO94_BinaryTreeInorderTraversal {

    // 解法一：递归中顺遍历
    public static List<Integer> inOrderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);

        return res;
    }

    private static void helper(TreeNode root, List<Integer> res) {
        if(root != null) {
            if(root.left != null) {
                helper(root.left, res);
            }
            res.add(root.val);
            if(root.right != null) {
                helper(root.right, res);
            }
        }
    }
}
