package com.coolslow.leetcode.topics.tree.ds;

import com.coolslow.datastruct.utils.MyUtils;
import com.sun.javafx.binding.StringFormatter;

import java.text.Format;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeNodeUtil {

    public static TreeNode getTree(Integer[] data) {
        if (data == null || data.length == 0) return null;
        int count = data.length;
        TreeNode[] array = new TreeNode[count];
        for (int i = 0; i < count; i++) {
            array[i] = new TreeNode(data[i]);
        }
        TreeNode root = array[0], temp;
        for (int i = 0; i < count; i++) {
            temp = array[i];
            if (temp.val == null) {
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

    public static void printBFS(TreeNode data) {
        if (data == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(data);
        TreeNode temp;
        while (!queue.isEmpty()) {
            temp = queue.poll();
            MyUtils.print(temp.val + " , ");
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }

    }

    public static void printPre(TreeNode data) {
        if (data == null) return;
        TreeNode temp;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(data);
        while (!stack.isEmpty()) {
            temp = stack.pop();
            MyUtils.print(temp.val + " , ");
            if (temp.right != null) {
                stack.push(temp.right);
            }
            if (temp.left != null) {
                stack.push(temp.left);
            }
        }
    }

    public static void printOrder(TreeNode data) {
        if (data == null) return;
        TreeNode temp = data;
        Stack<TreeNode> stack = new Stack<>();
        while (temp != null || !stack.isEmpty()) {
            while (temp != null) {
                stack.push(temp);
                temp = temp.left;
            }
            temp = stack.pop();
            MyUtils.print(temp.val + " , ");
            if (temp.right != null) {
                temp = temp.right;
            } else {
                temp = null;
            }

        }
    }

    public static void printPost(TreeNode data) {
        if (data == null) return;
        TreeNode temp = data, visit = null;
        Stack<TreeNode> stack = new Stack<>();
        while (temp != null || !stack.isEmpty()) {
            while (temp != null) {
                stack.push(temp);
                temp = temp.left;
            }
            temp = stack.peek();
            if (temp.right == null || temp.right == visit) {
                temp = stack.pop();
                visit = temp;
                MyUtils.print(temp.val + " , ");
                temp = null;
            } else {
                temp = temp.right;
            }
        }
    }

    public static int getHeight(TreeNode data) {
        if (data == null) return 0;
        TreeNode temp = data, visit = null;
        Stack<TreeNode> stack = new Stack<>();
        int height = 1;
        while (temp != null || !stack.isEmpty()) {
            while (temp != null) {
                stack.push(temp);
                temp = temp.left;
            }
            temp = stack.peek();
            if (temp.right == null || temp.right == visit) {
                height = Math.max(stack.size(), height);
                temp = stack.pop();
                visit = temp;
                temp = null;
            } else {
                temp = temp.right;
            }
        }
        return height;
    }


}
