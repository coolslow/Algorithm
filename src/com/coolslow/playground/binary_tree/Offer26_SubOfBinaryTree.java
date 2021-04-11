package com.coolslow.playground.binary_tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Offer 26. 树的子结构
 * 输入两颗二叉树A和B，判断B是不是A的子结构。（约定，空树不是任意一个树的子结构）
 * B是A的子结构，即A中出现和B相同的结构和节点值。
 *
 * 例：
 * 给定树 A：
 *        3
 *      /  \
 *     4    5
 *   /  \
 *  1    2
 *
 *  给定树 B：
 *     4
 *    /
 *   1
 * 返回 true，因为B与A的一个子树具有相同的结构和节点值。
 *
 * 输入：A = [1, 2, 3], B = [3, 1]
 * 输出：false
 *
 * 输入：A = [3, 4, 5, 1, 2], B = [4, 1]
 * 输出：true
 */
public class Offer26_SubOfBinaryTree {

    /**
     * 思路：判断B是A的子结构，埃米尔子结构的根节点可能为树A的任意一个节点。那么分析一下实际有三种可能：
     * 1. B的根节点对应A的根节点
     * 2. B的根节点对应A的左子树
     * 3. B的根节点对应A的右子树
     * 4. A或B为null，直接返回false
     *
     * 复杂度分析：
     * 设M为A的节点个数，N为B的节点个数。
     * - 时间复杂度：O(M * N)，遍历A：O(M)，比较A和B：O(N)
     * - 空间负载度：O(M)，最差情况就是遍历了A的所有节点。
     *
     * @param a
     * @param b
     * @return 布尔值，true ｜ false的判断
     */
    public boolean isSubTree(TreeNode a, TreeNode b) {
        if (b == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(a);
        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if(cur.val == b.val) {
                if (helper(cur, b)) {
                    return true;
                }
            }
            if (cur.left != null) {
                queue.offer(cur.left);
            }

            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
        return false;
    }

    private boolean helper(TreeNode nodeA, TreeNode nodeB) {
        Queue<TreeNode> queueA = new LinkedList<>();
        Queue<TreeNode> queueB = new LinkedList<>();

        queueA.offer(nodeA);
        queueB.offer(nodeB);

        while(!queueB.isEmpty()) {
            nodeA = queueA.poll();
            nodeB = queueB.poll();

            if(nodeA == null || nodeA.val != nodeB.val) {
                return false;
            }

            if (nodeB.left != null) {
                queueA.offer(nodeA.left);
                queueB.offer(nodeB.left);
            }

            if (nodeB.right != null) {
                queueA.offer(nodeA.right);
                queueB.offer(nodeB.right);
            }
        }
        return true;
    }

    public boolean isSubTreeII(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (recur(A, B) || isSubTreeII(A.left, B) || isSubTreeII(A.right, B));
    }

    private boolean recur(TreeNode A, TreeNode B) {
        if (B == null) return true;
        if (A == null || A.val != B.val) return false;

        return recur(A.left, B.left) && recur(A.right, B.right);
    }


    // https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/solution/shi-shang-luo-ji-zui-qing-chu-zui-rong-y-2q93/
    // 提交后AC执行时间最短。
    boolean res = false;

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        dfs(A, B);
        return res;
    }
    private void dfs(TreeNode a, TreeNode b) {
        if (a == null) {
            return;
        }
        if (a.val == b.val && isSubTreeHelper(a,b) ) {
            /**
             * 找到跟B相等的结点，找到后开始递归判断两个树是否相等
             * 如果存在就立刻返回
             */
            res = true;
            return;
        }
        dfs(a.left, b);
        dfs(a.right, b);
    }

    private boolean isSubTreeHelper(TreeNode A, TreeNode B) {
        if (A == null && B != null) {
            return false;
        }
        if (B == null){
            return true;
        }
        return A.val == B.val && isSubTreeHelper(A.left, B.left) && isSubTreeHelper(A.right, B.right);
    }
}
