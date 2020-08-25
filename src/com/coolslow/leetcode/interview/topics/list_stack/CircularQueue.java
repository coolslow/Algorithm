package com.coolslow.leetcode.interview.topics.list_stack;

/**
 * 个人实现的循环队列
 */
public class CircularQueue {

    private int[] queue;
    private int head;
    private int tail;
    private int size;

    public CircularQueue(int k) {
        queue = new int[k];
        head = -1;
        tail = -1;
        size = k;
    }

    // 入队操作, 从队尾操纵
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        if (isEmpty()) {
            head = 0;
        }
        tail = (tail + 1) % size;
        queue[tail] = value;

        return true;
    }

    // 出队操作, 从队头操纵
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }

        if (head == tail) {
            head = -1;
            tail = -1;
            return true;
        }
        head = (head + 1) % size;
        return true;
    }

    // 获取循环队列队头元素
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return queue[head];
    }

    // 获取循环队列队尾元素
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return queue[tail];
    }

    // 判断循环队列是否为空
    public boolean isEmpty() {
        return head == -1;
    }

    // 判断循环队列是否已满
    public boolean isFull() {
        return ((tail + 1) % size) == head;
    }
}
