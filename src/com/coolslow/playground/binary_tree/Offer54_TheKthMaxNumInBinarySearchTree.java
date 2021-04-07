package com.coolslow.playground.binary_tree;

/**
 * 剑指Offer 54. 二叉搜索树的第K大节点
 *
 * 给定一棵二叉搜索树，请找出其中第K大的节点。
 *
 * 示例1：
 * 输入：root = [3, 1, 4, null, 2], k = 1
 *           3
 *         /   \
 *        1     4
 *         \
 *         2
 * 输出：4
 *
 * 示例2：
 * 输入：root = [5, 3, 6, 2, 4, null, null, 1], k = 3
 *           5
 *         /  \
 *        3    6
 *      /  \
 *     2    4
 *   /
 *  1
 * 输出：4
 */
public class Offer54_TheKthMaxNumInBinarySearchTree {

    // 时间复杂度：O(n^2)
    // 空间复杂度：O(n)
    public int numTrees(int n) {
        int[] g = new int[n + 1];
        g[0] = 1;
        g[1] = 1;

        for(int i = 2; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                g[i] += g[j - 1] * g[i - j];
            }
        }
        return g[n];
    }
}
