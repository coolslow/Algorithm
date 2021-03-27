package com.coolslow.playground.binary_tree;

/**
 * 235. 二叉树的最近公共祖先
 *
 * 给定一颗二叉树，找到该二叉树中两个指定节点的最近公共祖先。
 * 示例：
 *                       3
 *                     /   \
 *                   5      1
 *                 /  \    / \
 *                6   2   0   8
 *                   / \
 *                  7  4
 * 输入：root = [3, 5, 1, 6, 2, 0, 8, null, null, 7, 4], p = 5, q = 1
 * 输出：3
 * 解释：节点5和节点1的最近公共祖先是节点3
 */
public class NO235_LowestCommonAncestorOfBinaryTree {

    /**
     * 思路：从根节点开始遍历。
     * - 如果当前节点的值大于p和q的值，说明p和q应该在当前节点的左子树上，因此，将当前节点移动到它的左子节点
     * - 如果当前节点的值小于q和q的值，说明p和q应该在当前节点的右子树上，因此，将当前节点移动到它的右子节点
     * - 如果当前节点的值不满足上述两种情况的要求，说明当前节点就是"分岔点"，此时，p和q要么在当前节点的不同子树种，要么其一就是当前节点。
     *
     * @param root 二叉树根节点
     * @param p 给定的节点p
     * @param q 给定的节点q
     * @return 返回最近公共祖先节点
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 将最近公共祖先节点设为根节点
        TreeNode ancestor = root;

        while(true) {
            // 如果p、q的值都比根节点小，那么对于BST而言，p、q都处于左子树
            if(p.val < ancestor.val && q.val < ancestor.val) {
                ancestor = ancestor.left;
            } else if(p.val > ancestor.val && q.val > ancestor.val) {
                ancestor = ancestor.right;
            } else {
                break;
            }
        }
        return ancestor;
    }
}
