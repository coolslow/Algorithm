package com.coolslow.playground.binary_tree;

/**
 * 814. 二叉树剪枝
 * 给定二叉树根结点 root ，此外树的每个结点的值要么是 0，要么是 1。
 * 返回移除了所有不包含 1 的子树的原二叉树。
 *
 * 说明：
 * 给定的二叉树最多有100个节点。
 * 每个节点的值只会为0 或 1。
 *
 * 思路：
 * 只对当前节点需要进行的操作进行分析即可。
 * 1. 当前节点值是否为1
 * 2. 左右子树是否可以被删除
 */
public class NO814_BinaryTreePruning {

    /**
     * 官方题解
     * @param root 给定的二叉树（只含0｜1）
     * @return 返回剪枝后的二叉树
     */
    public TreeNode pruneTree(TreeNode root) {
        return containOne(root) ? root : null;
    }

    private boolean containOne(TreeNode node) {
        // 如果根节点为空，不含1，返回false
        if (node == null) {
            return false;
        }
        boolean left = containOne(node.left);
        boolean right = containOne(node.right);
        // 如果左子树不包含1，则将左子树设为null
        if(!left) {
            node.left = null;
        }
        // 如果右子树不包含1，则将右子树设为null
        if(!right) {
            node.right = null;
        }

        // 理解这里的含义很重要，站在当前节点的位置上考虑，如果它此刻的值为1，则不论左右子树是否包含1，都会返回true。
        // 如果它的val不为1，则必然为0，则返回后进入到pruneTree的逻辑，直接返回 null，否则返回root。满足题目要求。
        return node.val == 1 || left || right;
    }
}
