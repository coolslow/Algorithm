package com.coolslow.leetcode.topics.tree;

import com.coolslow.datastruct.utils.MyUtils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * by MrThanksgiving
 */
public class Code116PopulatingNextRightPointersInEachNode {

    /**
     * <pre>
     * 题目：
     *      给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
     *
     *      struct Node {
     *        int val;
     *        Node *left;
     *        Node *right;
     *        Node *next;
     *      }
     *      填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
     *      初始状态下，所有 next 指针都被设置为 NULL。
     *
     * </pre>
     */
    public Node connect(Node root) {
        if (root == null) return null;
        Node pre = root;
        Node curr;
        while (pre.left != null) {
            curr = pre;
            while (curr !=null){
                curr.left.next = curr.right;
                if(curr.next !=null){
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }
            pre = pre.left;
        }
        return root;
    }


    public Node connect2(Node root) {
        if (root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node temp;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                temp = queue.poll();
                if (temp != null) {
                    if (i != size - 1) {
                        temp.next = queue.peek();
                    }
                    if (temp.left != null) {
                        queue.add(temp.left);
                    }
                    if (temp.right != null) {
                        queue.add(temp.right);
                    }
                }
            }
        }
        return root;
    }

    public static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }

        public static Node getNode(Integer[] data) {
            if (data == null || data.length == 0) return null;
            int count = data.length;
            Node[] array = new Node[count];
            for (int i = 0; i < count; i++) {
                if (data[i] != null)
                    array[i] = new Node(data[i]);
                else
                    array[i] = null;
            }
            Node root = array[0], temp;
            for (int i = 0; i < count; i++) {
                temp = array[i];
                if (temp == null) {
                    continue;
                }
                if (2 * i + 1 < count) {
                    if (data[2 * i + 1] != null) {
                        temp.left = array[2 * i + 1];
                    }
                }
                if (2 * i + 2 < count) {
                    if (data[2 * i + 2] != null) {
                        temp.right = array[2 * i + 2];
                    }
                }
            }
            return root;
        }

        public static void printBFS(Node data) {
            if (data == null) return;
            Queue<Node> queue = new LinkedList<>();
            queue.add(data);
            Node temp;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    temp = queue.poll();
                    if (temp != null) {
                        if (temp.next != null) {
                            MyUtils.print(temp.val + "( next = " + temp.next.val + " ) , ");
                        } else {
                            MyUtils.print(temp.val + "( next = null  ) , ");
                        }
                        if (temp.left != null) {
                            queue.add(temp.left);
                        }
                        if (temp.right != null) {
                            queue.add(temp.right);
                        }
                    }
                }
                MyUtils.println();
            }
        }
    }

}
