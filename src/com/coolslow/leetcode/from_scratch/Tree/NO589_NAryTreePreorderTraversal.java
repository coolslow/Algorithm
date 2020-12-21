package com.coolslow.leetcode.from_scratch.Tree;

import java.util.*;

/**
 * 589. N叉树的前序遍历
 *
 * 给定一个N叉树，返回其节点值的前序遍历
 *
 * 例如，给定一个三叉树：
 *                  1
 *                / ｜ \
 *               3  2  4
 *             / \
 *            5   6
 * 返回其前序遍历: [1, 3, 5, 6, 2, 4]
 *
 * NOTE: 前序遍历既：根 -> 左 -> 右
 */

public class NO589_NAryTreePreorderTraversal {

    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public static List<Integer> preorder(Node root) {

        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();

        if (root == null) {
            return output;
        }
        stack.add(root);

        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            output.add(node.val);
            Collections.reverse(node.children);
            for(Node item: node.children) {
                stack.add(item);
            }
        }
        return output;
    }
}
