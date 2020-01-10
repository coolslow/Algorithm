package com.coolslow.leetcode.topics.design;

import java.util.Stack;

/**
 * 最小栈
 * by MrThanksgiving
 */
public class Code155MinStack {

    /**
     * <pre>
     * 题目：
     *      设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
     *      push(x) -- 将元素 x 推入栈中。
     *      pop() -- 删除栈顶的元素。
     *      top() -- 获取栈顶元素。
     *      getMin() -- 检索栈中的最小元素。
     *
     * 示例:
     *      MinStack minStack = new MinStack();
     *      minStack.push(-2);
     *      minStack.push(0);
     *      minStack.push(-3);
     *      minStack.getMin();   --> 返回 -3.
     *      minStack.pop();
     *      minStack.top();      --> 返回 0.
     *      minStack.getMin();   --> 返回 -2.
     *
     * </pre>
     */
    private Node top;
    Stack<Integer> minStack = new Stack<>();

    public Code155MinStack() {
    }

    public void push(int x) {
        Node node = new Node(x);
        if (top == null) {
            top = node;
            minStack.push(x);
        } else {
            Node t = top;
            top = node;
            node.next = t;
            int min = minStack.peek();
            if (x <= min) {
                minStack.push(x);
            }
        }

    }

    public void pop() {
        if (top == null) return;
        int m = top.v;
        top = top.next;
        if (minStack.size() > 0) {
            if (m <= minStack.peek()) minStack.pop();
        }
    }

    public int top() {
        if (top == null) return 0;
        return top.v;
    }

    public int getMin() {
        if (minStack.size() > 0) {
            return minStack.peek();
        }
        return 0;
    }

    static class Node {
        int v;
        Node next;

        Node(int v) {
            this.v = v;
        }
    }

}
