package com.coolslow.playground.binary_tree;

/**
 * 101. 对称二叉树
 *
 * 给定一个二叉树，检查它是否是镜像对称的。
 * 例如，二叉树 [1, 2, 2, 3, 4, 4, 3] 是对称的。
 */
public class NO101_SymmetricTree {

    // 实际上是100题，判断两棵树是否相等的变形。
    // 因为，如果是一个对称二叉树，name其左右子树必然对称。转换为比较左右两颗树是否相等。
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    private boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return check(p.left, q.right) && check(p.right, q.left);
    }
}
