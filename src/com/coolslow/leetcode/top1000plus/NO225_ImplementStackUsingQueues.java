package com.coolslow.leetcode.top1000plus;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 225. 用队列实现栈
 *
 * 使用队列实现栈的下列操作：
 *
 * - push(x) -- 元素 x 入栈
 * - pop() -- 移除栈顶元素
 * - top() -- 获取栈顶元素
 * - empty() -- 返回栈是否为空
 *
 */
public class NO225_ImplementStackUsingQueues {

    public class MyStack {
        private Queue<Integer> queue1;
        private Queue<Integer> queue2;

        public MyStack() {
            queue1 = new LinkedList<>();
            queue2 = new LinkedList<>();
        }

        public void push(int x) {
            queue1.add(x);
        }

        public int pop() {
            while(queue1.size() > 1) {
                queue2.add(queue1.poll());
            }
            int ans = queue1.poll();

            while(queue2.size() > 0) {
                queue1.add(queue2.poll());
            }

            return ans;
        }

        public int top() {
            while(queue1.size() > 1) {
                queue2.add(queue1.poll());
            }
            int ans = queue1.peek();
            queue2.add(queue1.poll());

            while(queue2.size() > 0) {
                queue1.add(queue2.poll());
            }

            return ans;
        }

        public boolean empty() {
            return queue1.isEmpty();
        }
    }
}
