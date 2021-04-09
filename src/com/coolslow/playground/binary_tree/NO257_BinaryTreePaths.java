package com.coolslow.playground.binary_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 257. 二叉树的所有路径
 * 给定一棵二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明：叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 输入：
 *          1
 *        /  \
 *       2    3
 *        \
 *         5
 * 输出：["1->2->5", "1->3"]
 * 解释：所有根节点到叶子节点的路径分别为：
 *  a: 1 -> 2 -> 5
 *  b: 1 -> 3
 *
 */
public class NO257_BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        dfsPaths(root, "", paths);
        return paths;
    }

    private void dfsPaths(TreeNode root, String path, List<String> paths) {
        if (root != null) {
            // 关键点，在声明StringBuilder时，不要忘记将path传入，这个初始化是基于保存了上一个路径的数据而来的。
            StringBuilder pathSB = new StringBuilder(path);
            pathSB.append(Integer.toString(root.val));
            // 表示是叶子节点
            if (root.left == null && root.right == null) {
                paths.add(pathSB.toString());
            } else {
                // 否则执行递归操作
                pathSB.append("->");
                dfsPaths(root.left, pathSB.toString(), paths);
                dfsPaths(root.right, pathSB.toString(), paths);
            }
        }
    }
}
