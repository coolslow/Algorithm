package com.coolslow.playground.binary_tree;

/**
 * 98. 验证二叉搜索树
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *  - 节点的左子树只包含小于当前节点的数。
 *  - 节点的右子树只包含大于当前节点的数。
 *  - 所有左子树和右子树自身必须也是二叉搜索树。
 *
 * 示例1：
 * 输入：
 *      2
 *    /  \
 *   1    3
 * 输出：true
 *
 * 示例2：
 * 输入：
 *      5
 *    /  \
 *   1    4
 *      /  \
 *     3    6
 * 输出：false
 */
public class NO098_ValidateBinarySearchTree {

//    public boolean isValidBST(TreeNode root) {
//        if (root == null) {
//            return true;
//        }
//        if (root != null && (root.val < root.left.val || root.val > root.right.val)) {
//            return false;
//        }
//        return isValidBST(root.left) && isValidBST(root.right);
//    }

    public boolean isValidBST(TreeNode root) {

        // 这里配置Long长型的最大和最小值来辅助判断BST树
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode node, long lower, long higher) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= higher) {
            return false;
        }
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, higher);
    }
}
