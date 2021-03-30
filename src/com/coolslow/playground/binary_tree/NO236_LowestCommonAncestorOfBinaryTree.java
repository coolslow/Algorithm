package com.coolslow.playground.binary_tree;

/**
 * 236. 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * NOTE：该题和235题很类似，但235题是对一个BST树查找最近公共祖先，处理方法相对简单。
 *
 * 示例1：
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出：3
 * 解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
 *
 * 示例2：
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出：5
 * 解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
 *
 * 示例3：
 * 输入：root = [1,2], p = 1, q = 2
 * 输出：1
 *
 * ------------------------------------------------------------------------------------
 * 思路：
 * 使用递归的办法遍历整颗二叉树，定义fx表示x节点的子树是否包含p节点或q节点，如果包含则为true，否则为false。
 * 满足条件的最近公共祖先x一定满足如下条件：
 * (Fl && Fr) || ((x = p || x = q) && (Fl || Fr))
 * 上述公式初看比较复杂，但实际上就包含了两种情况：
 * 1. p和q分别在公共最近祖先的两侧
 * 2. p或者q就是最近公共祖先。
 *    - 若p是最近公共祖先，那么q必然在左右子树之一上存在
 *    - 对于q节点，反之亦然
 */
public class NO236_LowestCommonAncestorOfBinaryTree {
    TreeNode res = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return res;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean left = dfs(root.left, p, q);
        boolean right = dfs(root.right, p, q);

        if( (left && right) || (root.val == p.val || root.val == q.val) && (left || right)) {
            res = root;
        }

        return left || right || (root.val == p.val || root.val == q.val);
    }
}
