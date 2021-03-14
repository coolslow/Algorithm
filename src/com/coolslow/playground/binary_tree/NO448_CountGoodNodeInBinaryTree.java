package com.coolslow.playground.binary_tree;

/**
 * 给你一颗根为root的二叉树，清返回二叉树好节点的数目。
 * [好节点]X定义为：从根节点到该节点X所经过的节点中，没有任何节点的值大于X的值。
 *
 * 示例：
 *          3(✅)
 *         /  \
 *       1     4(✅)
 *      /     /  \
 *    3(✅)  1   5(✅)
 *
 * 输入：root = [3, 1, 4, 3, null, 1, 5]
 * 输出：4
 * 上图中：标记为(✅)的是好节点
 * 节点 4 -> (3,4) 是路径中的最大值。
 * 节点 5 -> (3,4,5) 是路径中的最大值。
 * 节点 3 -> (3,1,3) 是路径中的最大值。
 *
 * 基本思路：
 * 采用深度优先遍历算法。记录以根节点为基础点的左右子树中好节点的个数count，最后返回count + 1，因为根节点也是好节点。
 *
 */
public class NO448_CountGoodNodeInBinaryTree {

    public int goodNodes(TreeNode root) {
        return countChildNode(root) + 1;
    }

    private int countChildNode(TreeNode root) {
        // 好节点标记，初始值为0
        int ans = 0;
        if(root.left != null) {
            if(root.left.val >= root.val) {
                ans++;
            } else {
                // 如果左子树的值小于根节点的值，则将左子树的值用根节点的值取代
                // 这样的目的是方便让子树的（左右）子树的值和根节点的进行比较。
                root.left.val = root.val;
            }
            ans += countChildNode(root.left);
        }

        if(root.right != null) {
            if(root.right.val >= root.val) {
                ans++;
            } else {
                root.right.val = root.val;
            }
            ans += countChildNode(root.right);
        }

        return ans;
    }
}
