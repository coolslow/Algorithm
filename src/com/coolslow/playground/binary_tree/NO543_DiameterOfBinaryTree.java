package com.coolslow.playground.binary_tree;

/**
 * 543. 二叉树的直径
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。
 * 这条路径可能穿过也可能不穿过根结点。
 *
 * 示例：
 * 给定二叉树
 *           1
 *         /  \
 *        2    3
 *      /  \
 *     4    5
 * 返回3，它的长度是路径：[4, 2, 1, 3]或者[5, 2, 1, 3]
 * 注意：两结点之间的路径长度是以它们之间边的数目表示。
 */
public class NO543_DiameterOfBinaryTree {
    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        dfs(root);

        return ans - 1;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);

        ans = Math.max(ans, left + right + 1);
        return Math.max(left, right) + 1;
    }
}
