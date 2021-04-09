package com.coolslow.playground.binary_tree;

/**
 * 129. 求根节点到叶子节点的数字之和
 * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：
 * - 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 *
 * 叶节点 是指没有子节点的节点。
 *
 * 示例：
 *          1
 *        /  \
 *      2     3
 *  输入：root = [1, 2, 3]
 *  输出：25
 *
 *  解释：
 *  从根到叶子节点路径 1 -> 2代表数字12
 *  从根到叶子节点路径 1 -> 3代表数字13
 *  因此：数字总和为：12 + 13 = 25
 */
public class NO129_SumRootToLeafNumbers {
//    public int sumNumbers(TreeNode root) {
//        int height = getTreeHeight(root);
//    }
//    递归求解，无需去求树的高度
//    private int getTreeHeight(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        int leftHeight = getTreeHeight(root.left);
//        int rightHeight = getTreeHeight(root.right);
//        int res = Math.max(leftHeight, rightHeight) + 1;
//        return res;
//    }
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    public int helper(TreeNode root, int sum) {
        if (root == null) return 0;
        int tmp = sum * 10 + root.val;

        if(root.left == null && root.right == null) {
            return tmp;
        } else {
            return helper(root.left, tmp) + helper(root.right, tmp);
        }
    }
}
